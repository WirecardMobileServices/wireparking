package com.example.wire.service;

import com.querydsl.core.types.Predicate;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService<T,ID> extends BaseService<T,ID>  {


}
