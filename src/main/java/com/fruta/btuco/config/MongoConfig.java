package com.fruta.btuco.config;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {

    @Value("${storage.repository.mongodb.server.db.name}")
    private String databaseName;

    @Value("${storage.repository.mongodb.server.replicaSet}")
    private String replicaSet;

    @Value("${storage.repository.mongodb.server.connectionsPerHost}")
    private int connectionsPerHost;

    @Value("${storage.repository.mongodb.server.threadsAllowedToBlockForConnectionMultiplier}")
    private int threadsAllowedToBlockForConnectionMultiplier;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongo = this.getMongoClient();
        return new SimpleMongoDbFactory(mongo, this.databaseName);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoDbFactory dbFactory = this.mongoDbFactory();
        return new MongoTemplate(dbFactory, this.mongoConverter(dbFactory));
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public MongoConverter mongoConverter(MongoDbFactory dbFactory) {
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(dbFactory);
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
        return mongoConverter;
    }

    private MongoClient getMongoClient() {
        MongoClientOptions options = this.getMongoOptions();
        List<ServerAddress> seeds = this.getSeeds();

        return new MongoClient(seeds, options);
    }

    private List<ServerAddress> getSeeds() {
        String[] serverPorts = this.replicaSet.split(",");
        return Arrays.asList(serverPorts).stream().map(mapToServerAddress).collect(Collectors.toList());
    }

    private static Function<String, ServerAddress> mapToServerAddress = (serverPort) -> {
        try {
            String[] p = serverPort.split(":");
            if (p.length == 1) {
                return new ServerAddress(p[0]);
            } else {
                return new ServerAddress(p[0], Integer.valueOf(p[1]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    private MongoClientOptions getMongoOptions() {
        return MongoClientOptions.builder().connectionsPerHost(this.connectionsPerHost)
            .threadsAllowedToBlockForConnectionMultiplier(this.threadsAllowedToBlockForConnectionMultiplier).build();
    }
}
