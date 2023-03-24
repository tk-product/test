package com.example.demo.doma.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Script;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface AppDao {

    @Script
    void create();

    @Script
    void drop();

}
