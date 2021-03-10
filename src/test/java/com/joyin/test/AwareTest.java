package com.joyin.test;

import com.joyin.config.MyMVCConfig;
import com.joyin.config.TaskExecutorConfig;
import com.joyin.service.AwareTestServcie;
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
public class AwareTest {

    @Autowired
    private AwareTestServcie awareTestServcie;

    @Test
    public void awareTest() {
        awareTestServcie.output();
    }

}
