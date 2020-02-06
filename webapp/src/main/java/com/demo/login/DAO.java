package com.demo.login;

import java.util.List;

public interface DAO <T>{

	void save(T t);
	void delete(long id);
	T load(long id);
	List<T> loadAll();
}
