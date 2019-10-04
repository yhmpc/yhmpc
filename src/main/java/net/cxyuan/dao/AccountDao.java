package net.cxyuan.dao;

import net.cxyuan.bean.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, String> {
}
