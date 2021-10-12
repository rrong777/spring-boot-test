package com.wuqr.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    /**
     * 同步处理订单
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/syncOrder")
    public String syncOrder() throws InterruptedException {
        log.info("主线程开始");
        // 休眠1秒，假装在做一个下单的处理。
        Thread.sleep(1000);
        log.info("主线程返回");
        return "success";
    }

    @GetMapping("/asyncOrder")
    public Callable<String> asyncOrder() throws InterruptedException {
        log.info("主线程开始");
        // 这个Callable就是在Spring管理里面的线程，单开一个线程，去做业务逻辑的处理。
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                // 休眠1秒，假装在做一个下单的处理。
                Thread.sleep(1000);
                log.info("副线程返回");
                return "success";
            }
        };
        log.info("主线程返回");
        return result;
    }
}
