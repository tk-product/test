package com.example.demo.doma.dao;

import com.example.demo.doma.entity.Employee;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface EmployeeDao {

    @Select
    List<Employee> selectAll();

    @Select
    Employee selectById(Integer id);

    @Insert
    int insert(Employee employee);

    @Update
    int update(Employee employee);

    @Delete
    int delete(Employee employee);

}
