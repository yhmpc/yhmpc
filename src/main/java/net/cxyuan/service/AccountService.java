package net.cxyuan.service;

import net.cxyuan.bean.Account;
import net.cxyuan.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;


    public Account getAccountById(String id) {
        return accountDao.findById(id).get();
    }

    public void save(Account account) {
        accountDao.save(account);
    }
}
