package net.cxyuan;

import net.cxyuan.bean.Account;
import net.cxyuan.bean.YesNo;
import net.cxyuan.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private AccountService service;

    @Test
    public void contextLoads() {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setUsername("admin");
        account.setNickname("管理员");
        account.setPassword("root");
        account.setDescription("系统管理员");
        account.setEmail("yhmpc@qq.com");
        account.setIsDelete(YesNo.NO);
        service.save(account);
    }

}
