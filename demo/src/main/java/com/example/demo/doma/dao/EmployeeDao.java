package com.example.demo.doma.dao;

import com.example.demo.doma.entity.Employee;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SqlLogType;

import java.util.List;
import java.util.Map;

@Dao
@ConfigAutowireable
public interface EmployeeDao {

    @Select
    List<Employee> selectAll();

    @Select
    Employee selectById(Integer id);

    @Insert(sqlFile = true)
    int insert(Employee entity);

    @Update(sqlFile = true, ignoreVersion = false, sqlLog = SqlLogType.FORMATTED)
    int update(Employee entity);

    @Delete
    int delete(Employee entity);

}
