package com.fruta.btuco.dao;

import java.util.List;

import com.fruta.btuco.model.Resource;

public interface GenericDao<T extends Resource> {
	public List<T> findAll();

	public List<T> findPage(int pageNumber, int pageSize);

	public T find(String id);

	public T save(T resource);

	public T delete(String id);

	public T update(T resource);

}
