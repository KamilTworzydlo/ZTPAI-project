package com.ztpai.controller;

import com.ztpai.services.InquiryAsyncService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/async-test")
public class AsyncTestController {

    private final InquiryAsyncService inquiryAsyncService;

    public AsyncTestController(InquiryAsyncService inquiryAsyncService) {
        this.inquiryAsyncService = inquiryAsyncService;
    }

    @PostMapping
    public String triggerAsync() {
        inquiryAsyncService.runAsyncTask();
        return "Request accepted. Async task started.";
    }
}
