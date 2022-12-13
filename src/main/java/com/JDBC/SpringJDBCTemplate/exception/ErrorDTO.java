package com.JDBC.SpringJDBCTemplate.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorDTO {
    private String msg;
    private List<String> errors;
    private Integer status;

    public ErrorDTO(List<String> errors, Integer status) {
        this.errors = errors;
        this.status = status;
    }

}
