package io.seata.sample.controller;

import io.seata.sample.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/create", produces = "application/json")
    public Boolean create(@RequestParam String userId,
                          @RequestParam String commodityCode,
                          @RequestParam Integer count) {

        System.out.println("【订单请求】start... userId:" + userId + " commodityCode:" + commodityCode + " count:" + count);
        orderService.create(userId, commodityCode, count);
        System.out.println("【订单请求】end...");
        return true;
    }

}
