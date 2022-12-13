package com.JDBC.SpringJDBCTemplate.controller;

import com.JDBC.SpringJDBCTemplate.dto.Employee;
import com.JDBC.SpringJDBCTemplate.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empl")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("Starting add Employee");
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/user")
    public Employee update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }
    @GetMapping()
    public List<Employee> getAll(){
        return employeeService.allEmployee();
    }
}
