package com.student.management.jwt;

import lombok.Data;

@Data
public class JwtRequest {

    private String userName;
    private String userPassword;

}
