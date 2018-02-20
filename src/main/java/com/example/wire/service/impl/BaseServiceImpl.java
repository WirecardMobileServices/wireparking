package com.example.wire.service.impl;

import com.example.wire.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

abstract class BaseServiceImpl<T,ID extends Serializable,R extends JpaRepository<T,ID>> implements BaseService<T,ID>{

    @Override
    public T findOne(final ID id) {
        return getRepository().findOne(id);
    }


    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T save(final T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T saveAndFlush(final T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public void delete(final T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public long count() {
        return getRepository().count();
    }


    protected abstract R getRepository();




}
