package com.cwww.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author cWww
 * @Title
 * @Description
 * @date: 2018/7/2  14:25
 */
@Component("testEventListener")
public class TestEventListener implements ApplicationListener<TestEvent> {

    @Override
    @Async
    public void onApplicationEvent(TestEvent testEvent) {
        try {
            //静静的沉睡3秒钟
            Thread.sleep(3000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(testEvent.onEvent());
    }

}