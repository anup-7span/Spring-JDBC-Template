package com.JDBC.SpringJDBCTemplate.feign;

import com.JDBC.SpringJDBCTemplate.dto.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo",url ="http://localhost:8083/department")
public interface FeignClass {
    @GetMapping("/get")
    Department getDepartment();
}
