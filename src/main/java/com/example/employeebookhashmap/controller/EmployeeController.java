package com.example.employeebookhashmap.controller;

import com.example.employeebookhashmap.model.Employee;
import com.example.employeebookhashmap.service.impl.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.Map;

@RestController

@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String show() {
        return "тест";
    }



    @GetMapping("post")
    public Employee addEmployee(@RequestParam  String firstName, @RequestParam String secondName)  {

        return employeeService.addEmployee(firstName,secondName);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.removeEmployee(firstName,secondName);
    }

    @GetMapping("/get")
    public Employee getEmployee(@RequestParam String firstName,String secondName){
        return employeeService.getEmployee(firstName,secondName);
    }

    @GetMapping("getAll")
    public Collection<Employee> getEmployees() {
        return  employeeService.getEmployees();
    }

}


