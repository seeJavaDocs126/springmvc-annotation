package com.joyin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wd
 * @Classname HelloController
 * @Description TODO
 * @Date 2021-03-09 17:09
 * @Version V1.0
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "index";
    }

}
