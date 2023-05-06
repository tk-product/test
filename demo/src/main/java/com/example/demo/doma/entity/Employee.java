package com.example.demo.doma.entity;

import org.seasar.doma.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    public Integer id;

    public String name;

    public Integer age;

    public String contents;

    @Version
    public Integer version;

    @OriginalStates
    public Employee originalStates;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age
                + ", contents=" + contents + ", version=" + version + "]";
    }


}
