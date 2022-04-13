package io.seata.sample.controller;

import io.seata.sample.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/reduce", produces = "application/json")
    public String debit(@RequestParam String userId, @RequestParam int money) {
        System.out.println("【账户请求】start... userId:" + userId + " money:" + money);
        int result = accountService.reduce(userId, money);
        System.out.println("【账户请求】end... userId:" + userId + " money:" + money + " result:" + result);
        return "扣减结果" + String.valueOf(result);
    }
}
