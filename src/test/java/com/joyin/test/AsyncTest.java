package com.joyin.test;

/**
 * @author wd
 * @Classname AsyncTest
 * @Description TODO
 * @Date 2021-03-10 16:02
 * @Version V1.0
 */

import com.joyin.config.MyMVCConfig;
import com.joyin.config.TaskExecutorConfig;
import com.joyin.service.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 注意：MyMVCConfig的@EnableWebMvc 要注释掉
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMVCConfig.class, TaskExecutorConfig.class})
public class AsyncTest {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void asyncTest() {
        asyncTaskService.executeAsyncTask();
        asyncTaskService.executeAsyncTask2();
        System.out.println("主线程结束："+Thread.currentThread().getName());
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
