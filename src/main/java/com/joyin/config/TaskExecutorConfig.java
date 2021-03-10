package com.joyin.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

/**
 * @author wd
 * @Classname TaskExecutorConfig
 * @Description 开启异步任务支持
 * @Date 2021-03-10 16:00
 * @Version V1.0
 */

@Configuration
@EnableAsync//开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {
    //返回一个线程池
    @Bean("taskExecutor") // bean的名称，默认为首字母小写的方法名
    public Executor getAsyncExecutor() {
        //创建并配置线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
