package com.fruta.btuco.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.fruta.btuco.dao.GenericDao;
import com.fruta.btuco.model.Resource;

public class GenericDaoImpl<T extends Resource> implements GenericDao<T> {

	@Autowired
	protected MongoTemplate mongoTemplate;

	protected Class<T> clazz;

	protected GenericDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> findAll() {
		return this.mongoTemplate.findAll(this.clazz);
	}

	@Override
	public List<T> findPage(int pageNumber, int pageSize) {
		Query paginatedQuery = new Query().limit(pageSize).skip((pageNumber - 1) * pageSize);
		return this.find(paginatedQuery);
	}

	@Override
	public T find(String id) {
		return this.mongoTemplate.findById(id, this.clazz);
	}

	@Override
	public T save(T resource) {
		this.mongoTemplate.save(resource);
		return resource;
	}

	@Override
	public T delete(String id) {
		T resource = this.find(id);
		if (resource != null) {
			this.mongoTemplate.remove(resource);
			return resource;
		}
		return null;
	}

	@Override
	public T update(T resource) {
		return this.save(resource);
	}

	protected List<T> find(Query query) {
		return this.mongoTemplate.find(query, this.clazz);
	}
}
