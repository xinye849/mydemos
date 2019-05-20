package xin.yuan.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xin.yuan.service.AccountService;

/**
 * @authorknightx
 * @create2019/4/25
 * @since 1.0.0
 */
public class SpringTest {
    @Test
    public void runSpring(){
        ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }
}
