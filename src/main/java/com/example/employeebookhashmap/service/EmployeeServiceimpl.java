package com.example.employeebookhashmap.service;

import com.example.employeebookhashmap.model.Employee;
import com.example.employeebookhashmap.service.impl.EmployeeService;
import org.springframework.stereotype.Service;
import ru.skypro.employeebookwithcollectionver1.exception.DuplicateEmployee;
import ru.skypro.employeebookwithcollectionver1.exception.EmployeeNotFound;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    Map<String,Employee> employees;

    public EmployeeServiceimpl() {
        employees = new HashMap<String,Employee>();
    }

    @Override
    public Employee addEmployee(String firstName, String secondName) {
        Employee employee = new Employee(firstName,secondName);
        String key = firstName +" "+secondName;
        if (!employees.containsKey(key)) {
            employees.put(key,employee);

            return employee;
        }

        throw new DuplicateEmployee();

    }

    @Override
    public Employee removeEmployee(String firstName, String secondName) {
        String key = firstName +" "+secondName;
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee getEmployee(String firstName, String secondName) {
        String key = firstName +" " + secondName;
        if(employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFound();
    }


    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

}


