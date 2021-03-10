package com.joyin.advice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wd
 * @Classname MyControllerAdvice
 * @Description 增强的 Controller 用来全局配置
    1.全局异常处理
    2.全局数据绑定
    3.全局数据预处理
 * @Date 2021-03-10 14:11
 * @Version V1.0
 */
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常处理
     * 可以定义多个方法，不同的方法处理不同的异常，例如专门处理空指针的方法、专门处理数组越界的方法...，
     * 也可以直接向上面代码一样，在一个方法中处理所有的异常信息。
     * @ExceptionHandler 注解用来指明异常的处理类型，即如果这里指定为 NullpointerException，
     * 则数组越界异常就不会进到这个方法中来。
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView customException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("error");
        return mv;
    }

    /**
     * 使用 @ModelAttribute 注解标记该方法的返回数据是一个全局数据，默认情况下，这个全局数据的 key 就是返回的变量名，value 就是方法返回值，
     * 当然开发者可以通过 @ModelAttribute 注解的 name 属性去重新指定 key。
     * 定义完成后，在任何一个Controller 的接口中，都可以获取到这里定义的数据：
     * @return
     */
    @ModelAttribute(name = "md")
    public Map<String,Object> bindData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }

    /**
     * 预处理前台请求参数
     * 1.比如说禁止掉某一个参数，这个也可以统一处理，OK，继续在ExceptionHandlerAdvice方法中添加方法
     * 这个表示将客户端传来的id参数忽略掉，但是注意接收的方式，这里通过对象来接收参数的时候才有效(通过对象接收这个参数的时候才会屏蔽掉id)，如果直接提取还是可以提取到的
     * 2.给接口中的变量取别名
     * @InitBinder("b")
     * public void b(WebDataBinder binder) {
     *     binder.setFieldDefaultPrefix("b.");
     * }
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @InitBinder("b")
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){
        //对日期的统一处理
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        //添加对数据的校验
        //binder.setValidator();
    }

}
