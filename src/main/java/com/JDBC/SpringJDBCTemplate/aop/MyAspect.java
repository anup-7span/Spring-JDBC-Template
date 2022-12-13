package com.JDBC.SpringJDBCTemplate.aop;

import com.JDBC.SpringJDBCTemplate.dto.Employee;
import com.JDBC.SpringJDBCTemplate.exception.CustomException;
import com.JDBC.SpringJDBCTemplate.utils.AopUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Autowired
    AopUtils aopUtils;
    @Pointcut("execution(* com.JDBC.SpringJDBCTemplate.controller.EmployeeController.getEmployee(..))")
    public void pointcutDemo(){}
    @Before("pointcutDemo()")
    public void beforeExecute (){
       System.out.println("execution Before started");
    /*    Employee employee = new Employee();
        Integer employeeId = employee.getId();
        if (employeeId != 0){
            throw new CustomException ("Execution started", HttpStatus.OK,1);
        }
        throw  new CustomException("Employee must not be null",HttpStatus.BAD_REQUEST,0);*/
    }
    @Before("pointcutDemo()")
    public void methodSignature(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method:-"+methodSignature);
    }

    @After("pointcutDemo()")
    public void afterExecution(){
        System.out.println("execution After");
    }
}
