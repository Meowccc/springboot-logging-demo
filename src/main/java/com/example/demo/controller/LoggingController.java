package com.example.demo.controller;

import com.example.demo.dto.TestReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meow
 */
@Slf4j
@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoggingController {


    @GetMapping("hello")
    public String hello() {
        log.info("Hello World in LoggingController ");
        return "Hello World!";
    }


    @PostMapping("hello")
    public TestReq helloPost(@RequestBody @Valid TestReq req) {
        log.info("Hello World in LoggingController req: {} .", req);
        return req;
    }

}
