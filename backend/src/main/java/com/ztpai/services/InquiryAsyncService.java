package com.ztpai.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class InquiryAsyncService {

    @Async
    public void runAsyncTask() {
        try {
            Thread.sleep(3000);
            System.out.println("Asynchroniczne zadanie wykonane w tle");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
