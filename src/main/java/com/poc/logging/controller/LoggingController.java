package com.poc.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@Slf4j
public class LoggingController {

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        MDC.put("TRANSACTION_ID", UUID.randomUUID().toString());
        log.info("INFO log");
        return ResponseEntity.ok("UP");
    }

    @GetMapping("/error/{errorMessage}")
    public ResponseEntity<String> error(@RequestParam String errorMessage) throws Exception {
        if (errorMessage != null) {
            throw new Exception(errorMessage);
        }

        return ResponseEntity.ok("NADA !!!");
    }
}
