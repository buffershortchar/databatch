package com.cqcfsw.databatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baofengxueque
 * @create 2020-05-19-10:03
 */

@Controller
public class DefaultController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/message")
    public String message() {
        return "chat90";
    }

    /**
     * http://localhost:8080/client
     * @return
     */
    @RequestMapping("/client")
    public String client() {
        return "client";
    }
}
