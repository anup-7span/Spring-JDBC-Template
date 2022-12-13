package com.JDBC.SpringJDBCTemplate.service.impl;

import com.JDBC.SpringJDBCTemplate.dto.Employee;
import com.JDBC.SpringJDBCTemplate.feign.FeignClass;
import com.JDBC.SpringJDBCTemplate.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FeignClass feignClass;
    @Autowired
    Tracer tracer;

    private static String INSERT_EMPLOYEE_QUERY="INSERT INTO empl (id,first_name,last_name,age,employee_department)values(?,?,?,?,?)";
    private static String UPDATE_EMPLOYEE_BY_ID_QUERY="UPDATE empl SET first_name=?,last_name=? WHERE id=?";
    private static String GET_EMPLOYEE_BY_ID_QUERY="SELECT * FROM empl WHERE id=?";
    private static String DELETE_EMPLOYEE_BY_ID_QUERY="DELETE FROM empl WHERE id=?";
    private static String GET_EMPLOYEE_QUERY="SELECT * FROM empl";

    @Override
    public Employee saveEmployee(Employee employee) {
        Span span=this.tracer.nextSpan().name("custom-log");
        try{
            Tracer.SpanInScope sp=tracer.withSpan(span.start());
            span.tag("custom-tag","##3##");

        }finally {
            span.end();
        }
        employee.setEmployee_department(feignClass.getDepartment().getEmployee_department());
        jdbcTemplate.update(INSERT_EMPLOYEE_QUERY,employee.getId(),employee.getFirst_name(),employee.getLast_name(),employee.getAge(),employee.getEmployee_department());
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        jdbcTemplate.update(UPDATE_EMPLOYEE_BY_ID_QUERY,employee.getFirst_name(),employee.getLast_name(),employee.getId());
        return employee;
    }

    @Override
    public Employee getEmployee(Integer id) {
        return jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID_QUERY,(rs, rowNum) -> {
            return new Employee(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("age"),rs.getString("employee_department"));
        },id);
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID_QUERY,id);
        return "User deleted";
    }

    @Override
    public List<Employee> allEmployee() {
        return jdbcTemplate.query(GET_EMPLOYEE_QUERY,(rs, rowNum) -> {
            return new Employee(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("age"),rs.getString("employee_department"));
        });
    }
}
