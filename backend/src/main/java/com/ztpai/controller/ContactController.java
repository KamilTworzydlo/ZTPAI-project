package com.ztpai.controllers;

import com.ztpai.dto.ContactRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    @PostMapping
    public void sendContact(@RequestBody ContactRequest request) {
        System.out.println("NOWE ZAPYTANIE:");
        System.out.println("Imię: " + request.getName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Produkt: " + request.getProduct());
        System.out.println("Treść: " + request.getMessage());
    }
}
