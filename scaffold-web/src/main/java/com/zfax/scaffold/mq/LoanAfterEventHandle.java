package com.zfax.scaffold.mq;


import com.alibaba.fastjson.JSON;
import com.zfax.core.exception.BusinessException;
import com.zfax.event.entity.approval.EndFlowEvent;
import com.zfax.event.entity.approval.LoanAfterEvent;
import com.zyxr.event.entity.ExampleEvent;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class LoanAfterEventHandle {


    /**
     * 监控事件中心MQ，EndFlowEvent事件
     */
    @EventListener(classes = LoanAfterEvent.class)
    public void endFlowEventHandler(LoanAfterEvent event) {
        log.info("endFlowEventHandler----{}", JSON.toJSONString(event));
    }

    @EventListener(classes = EndFlowEvent.class)
    public void endFlowEvent(EndFlowEvent event) throws Exception {
        Random random = new Random();
        log.info("EndFlowEvent1----{}", JSON.toJSONString(event));
        Thread.sleep(10000 + random.nextInt(20000));
        log.info("EndFlowEvent2----{}", JSON.toJSONString(event));
    }

    @EventListener(classes = ExampleEvent.class)
    public void endFlowEvent(ExampleEvent event) throws Exception {
        Random random = new Random();
        log.info("ExampleEvent1----{}", JSON.toJSONString(event));
        Thread.sleep(5000 + random.nextInt(10000));
        log.info("ExampleEvent2----{}", JSON.toJSONString(event));
    }

}
