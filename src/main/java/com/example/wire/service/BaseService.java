package com.example.wire.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T, ID> {

    List<T> findAll();


    T findOne(ID id);


    T save(T entity);

    void delete(T entity);

    void flush();

    long count();

    T saveAndFlush(T entity);


}
