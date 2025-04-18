package com.example.microsServices.department_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessegeController {

    @Value("${spring.boot.message}")
    String message;

    @GetMapping("messege")
    public String messege() {
        return message;
    }
}
