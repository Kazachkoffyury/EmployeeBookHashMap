package com.example.employeebookhashmap.service.impl;

import com.example.employeebookhashmap.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String secondName);
    Employee removeEmployee(String firstName,String secondName);
    Employee getEmployee(String firstName,String secondName);

    Collection<Employee> getEmployees();
}