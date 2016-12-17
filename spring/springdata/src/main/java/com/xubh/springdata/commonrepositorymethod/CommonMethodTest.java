package com.xubh.springdata.commonrepositorymethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonMethodTest<T, ID extends Serializable> extends JpaRepository<T, ID> {

    void method();

}
