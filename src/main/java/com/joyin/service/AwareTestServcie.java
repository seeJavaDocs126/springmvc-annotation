package com.joyin.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * @author wd
 * @Classname AwareTestServcie
 * @Description 测试Aware接口使用
 * @Date 2021-03-10 15:10
 * @Version V1.0
 */
@Service("awareTestServcie")
@PropertySource(value = "aware.properties", encoding = "UTF-8")
public class AwareTestServcie implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, EnvironmentAware {
    private String beanName;
    private ResourceLoader loader;
    private Environment environment;
    private BeanFactory beanFactory;

    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void output() {
        System.out.println("Bean的名称为：" + beanName);
        Resource resource = loader.getResource("aware.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(environment.getProperty("aware.test"));
        System.out.println(beanFactory);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //获取Bean的生成工厂
        this.beanFactory = beanFactory;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
