package com.ztpai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
public class SecureTestController {

    @GetMapping("/test")
    public String secure() {
        return "Dostęp przyznany – JWT działa";
    }
}
