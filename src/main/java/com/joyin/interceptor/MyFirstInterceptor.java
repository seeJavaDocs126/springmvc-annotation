package com.joyin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wd
 * @Classname MyFirstInterceptor
 * @Description TODO
 * @Date 2021-03-10 8:06
 * @Version V1.0
 */
//需要实现spring mvc  的接口    之前： <mvc:interceptors> </mvc:interceptors>
public class MyFirstInterceptor implements HandlerInterceptor {
    //目标方法运行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("目标方法之前....执行了preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("目标方之后....执行了postHandle");

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("响应到页面之后....执行了afterCompletion");
    }

}
