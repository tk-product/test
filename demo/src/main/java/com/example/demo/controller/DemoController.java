package com.example.demo.controller;

import com.example.demo.doma.dao.EmployeeDao;
import com.example.demo.doma.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DemoController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/hello")
    public String hello(Model model) {
        List<Employee> employeeList = employeeDao.selectAll();
        model.addAttribute("message", employeeList.get(0).name);
        return "hello";
    }
}