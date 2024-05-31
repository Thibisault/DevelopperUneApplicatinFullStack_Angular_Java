//path: back/src/main/java/com/openclassrooms/mddapi/controller/ErrorController.java
package com.openclassrooms.mddapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/400")
    public String error400() {
        return "error/400";
    }

    @RequestMapping("/401")
    public String error401() {
        return "error/401";
    }

    @RequestMapping("/403")
    public String error403() {
        return "error/403";
    }

    @RequestMapping("/404")
    public String error404() {
        return "error/404";
    }

    @RequestMapping("/405")
    public String error405() {
        return "error/405";
    }

    @RequestMapping("/408")
    public String error408() {
        return "error/408";
    }

    @RequestMapping("/500")
    public String error500() {
        return "error/500";
    }

    @RequestMapping("/502")
    public String error502() {
        return "error/502";
    }

    @RequestMapping("/503")
    public String error503() {
        return "error/503";
    }

    @RequestMapping("/504")
    public String error504() {
        return "error/504";
    }
}