package xin.yuan.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.yuan.entity.Customer;
import xin.yuan.service.CustomerService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})

public class customerDaoImplTest {
@Autowired
    private CustomerService cs ;

    @Test
    public void findAllCustomer() {

//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//               CustomerService cs =(CustomerService) ac.getBean("customerService");
//               cs.findAllCustomer();
        List<Customer> list = cs.findAllCustomer();
        for (Customer c : list){

            System.out.println(c);
        }
    }

    @Test
    public void saveCustomer() {




        Customer c = new Customer();

        c.setCustName("熊新");
        c.setCustSource("sfd");
        c.setCustLevel("dfdf");
        c.setCustIndustry("dfds");
        c.setCustAddress("fjldj");
        c.setCustPhone("1234589");
          cs.saveCustomer(c);

    }
}