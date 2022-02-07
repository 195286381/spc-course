package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务类的常见基本功的编码.
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功", result);
        } else {
            return new CommonResult<>(200, "插入失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        System.out.println("1234");
        Payment payment = paymentService.getPaymentById(id);
        int age = 1222221120 / 2;
        System.out.println(age);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功:" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        log.info("service: " + services);

        for (String serviceName : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
            System.out.println("serviceName = " + serviceName);
            for (ServiceInstance serviceInstance : instances) {
                System.out.println("ServiceId:" + serviceInstance.getServiceId());
                System.out.println("InstanceId:" + serviceInstance.getInstanceId());
                System.out.println("Host:" + serviceInstance.getHost());
                System.out.println("Port:" + serviceInstance.getPort());
            }
        }

        return services;
    }

}
