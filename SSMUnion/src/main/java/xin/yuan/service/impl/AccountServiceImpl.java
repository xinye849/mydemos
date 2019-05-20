package xin.yuan.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.dao.AccountDao;
import xin.yuan.domain.Account;
import xin.yuan.service.AccountService;

import java.util.List;

/**
 * @authorknightx
 * @create2019/4/25
 * @since 1.0.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        List<Account> all = accountDao.findAll();
        System.out.println("业务层：全部找到了");
        return all;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
        System.out.println("业务层：保存了");

    }
}
