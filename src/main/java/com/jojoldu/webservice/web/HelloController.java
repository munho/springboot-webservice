package com.jojoldu.webservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/dev/hello")
    public String devHello(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if (!"DEV".equals(auth)) {
            throw new AccessDeniedException();
        }
        return "dev hello";
    }

    @GetMapping("/real/hello")
    public String productionHello(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if (!"PRODUCTION".equals(auth)) {
            throw new AccessDeniedException();
        }
        return "production hello";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    static class AccessDeniedException extends RuntimeException {

    }
}
