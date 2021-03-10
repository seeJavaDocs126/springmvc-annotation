package com.joyin.controller;

import com.joyin.advice.MyControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wd
 * @Classname HelloController
 * @Description TODO
 * @Date 2021-03-09 17:09
 * @Version V1.0
 */
@Controller
public class HelloController {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "index";
    }

    /**
     * 全局配置测试
     * 1.全局数据绑定
     * 获取全局数据：方式一：Model model key:md -> md已在全局数据绑定时指定
     * @see MyControllerAdvice#bindData()
     * 方式二：@ModelAttribute(name = "md") Map<String,Object> map
     * 2.全局异常处理  int i = 1 / 0; 除0异常
     * @see MyControllerAdvice#customException(Exception) 处理，返回error.jsp
     * @return
     */
    @GetMapping("/advice")
    @ResponseBody
    public String testControllerAdvice(Model model) {
        logger.info("进入advice");
        Map<String, Object> map = model.asMap();
        System.out.println(map);
        int i = 1 / 0;
        return "hello controller advice";
    }





}
