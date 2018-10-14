package com.vm.spring.transaction.poc.dao;

import java.util.List;

public interface Dao<T> {

    long save(T t);

    T load(long id);

    int delete(long id);

    int update(T t);

    List<T> loadAll();
}