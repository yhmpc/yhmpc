package net.cxyuan.controller;

import net.cxyuan.bean.Account;
import net.cxyuan.bean.Result;
import net.cxyuan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("{id}")
    public Result getAccountById(@PathVariable String id) {
        Account account = accountService.getAccountById(id);
        return new Result(true, 20000, "查询成功", account);
    }

}
