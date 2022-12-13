package com.JDBC.SpringJDBCTemplate.service;

import com.JDBC.SpringJDBCTemplate.dto.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee getEmployee(Integer id);
    String deleteEmployeeById(Integer id);
    List<Employee> allEmployee();
}
