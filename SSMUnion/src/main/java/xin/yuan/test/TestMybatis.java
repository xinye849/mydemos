package xin.yuan.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xin.yuan.dao.AccountDao;
import xin.yuan.domain.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @authorknightx
 * @create2019/4/26
 * @since 1.0.0
 */
public class TestMybatis {
    /**
    *@method:
    *@return:
    *@since: 1.0.0
    *@Author:knightx
    *@Date:2019/4/26
     * 测试查询
    */
    @Test
    public void run1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        //由于是接口开发，所以要拿到sqlsession的代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> all = accountDao.findAll();
        for (Account account : all){
            System.out.println(account);
        }
    }
/**
*@method:
*@return:
*@since: 1.0.0
*@Author:knightx
*@Date:2019/4/26
 * 测试保存
*/

    @Test
    public void run2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        //由于是接口开发，所以要拿到sqlsession的代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account a = new Account();
        a.setName("张三");
        a.setMoney(2222d);

        accountDao.saveAccount(a);
        sqlSession.commit();
        System.out.println("保存成功");

    }
}
