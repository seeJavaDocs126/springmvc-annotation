package com.joyin.test;

import com.joyin.config.MyMVCConfig;
import com.joyin.config.ScheduledConfig;
import com.joyin.service.ScheduledTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 注意：MyMVCConfig的@EnableWebMvc 要注释掉
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMVCConfig.class, ScheduledConfig.class})
public class ScheduleTest {

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @Test
    public void scheduledTest() {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
