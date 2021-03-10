package com.joyin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wd
 * @Classname AsyncTaskService
 * @Description TODO
 * @Date 2021-03-10 16:01
 * @Version V1.0
 *
 * 如下方式会使@Async失效
 * 一、异步方法使用static修饰
 * 二、异步类没有使用@Component注解（或其他注解）导致spring无法扫描到异步类
 * 三、异步方法不能与异步方法在同一个类中
 * 四、类中需要使用@Autowired或@Resource等注解自动注入，不能自己手动new对象
 * 五、如果使用SpringBoot框架必须在启动类中增加@EnableAsync注解
 * 六、在Async 方法上标注@Transactional是没用的。 在Async 方法调用的方法上标注@Transactional 有效。
 * 七、调用被@Async标记的方法的调用者不能和被调用的方法在同一类中不然不会起作用！！！！！！！
 * 八、使用@Async时要求是不能有返回值的不然会报错的 因为异步要求是不关心结果的
 */
@Service
public class AsyncTaskService {
    Logger log = LoggerFactory.getLogger(AsyncTaskService.class);

    @Async("taskExecutor")
    public void executeAsyncTask() {
        log.info("任务1开始....");
        System.out.println("异步任务1,Thread.currentThread().getName():"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("任务1结束....");
    }

    @Async("taskExecutor")
    public void executeAsyncTask2() {
        log.info("任务2开始....");
        System.out.println("异步任务2,Thread.currentThread().getName():"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("任务2结束....");
    }
}
