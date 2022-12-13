package com.JDBC.SpringJDBCTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String employee_department;
}
