package com.example.demo.controller;

import com.example.demo.doma.dao.EmployeeDao;
import com.example.demo.doma.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class DemoController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/hello")
    public String hello(Model model) {
//        model.addAttribute("message", "");
        Employee employee = employeeDao.selectById(1);
        System.out.println("★★selectById★★ " + employee.toString());
        employee.age = 666;
//        employee.version = 99;
        int result = employeeDao.update(employee);
        System.out.println("★★update★★ " + result);
        employee = employeeDao.selectById(1);
        System.out.println("★★selectById★★ " + employee.toString());

        // BatchInsert, BatchUpdate
        List<Employee> list = new ArrayList<>();
        Employee employee2 = new Employee();
        employee2.id = 22;
        employee2.name = "あああ";
        employee2.age = 2;
        employee2.version = 1;
        Employee employee3 = new Employee();
        employee3.id = 33;
        employee3.name = "いいい";
        employee3.age = 3;
        employee3.version = 1;
        list.add(employee2);
        list.add(employee3);

        int[] resultList = employeeDao.insert(list);
        System.out.println("★★batchInsert★★ " + Arrays.toString(resultList));
        //employee2.age = 222;
        List<Employee> listAll = employeeDao.selectAll();
        resultList = employeeDao.update(listAll);
        System.out.println("★★batchUpdate★★ " + Arrays.toString(resultList));

        return "hello";
    }
}