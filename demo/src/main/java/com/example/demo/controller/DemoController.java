package com.example.demo.controller;

import com.example.demo.doma.dao.EmployeeDao;
import com.example.demo.doma.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        employee.version = 99;
        int result = employeeDao.update(employee);
        System.out.println("★★update★★ " + result);
        employee = employeeDao.selectById(1);
        System.out.println("★★selectById★★ " + employee.toString());
        return "hello";
    }
}