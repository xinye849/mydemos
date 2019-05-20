package xin.yuan.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import xin.yuan.entity.Customer;
import xin.yuan.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @authorknightx
 * @create2019/1/8
 * @since 1.0.0
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    Customer customer = new Customer();
    private CustomerService customerService ;
//spring会调用此set方法帮我们拿到customerService，
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
//在action的构造子中拿容器解决了一个应用中只有一个容器的问题，但是，这种方式的每一个action中都要拿一次容易，有点不方便，
// 所以，跟spring整合。struts2-spring-plugin这个包帮我们把拿容器的活给干了，导入这个包，整合完成
   /* public CustomerAction(){

        ServletContext application = ServletActionContext.getServletContext();
        //spring的web监听器为我们创建spring容器且把容器放入了application域中，但域中容器的名字太长了，所以，web包下有一个方法可以快速取得容器，

        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
        CustomerService cs = (CustomerService) ac.getBean("customerService");
        this.setCustomerService(cs);
    }*/

    //查询所有
    public String findAllCustomer(){

       List<Customer> customerList =  customerService.findAllCustomer();



          HttpServletRequest request ;

         request = ServletActionContext.getRequest();
        request.setAttribute("customerList",customerList);


        return SUCCESS;
    }


    //新增一个对象
    public String addCustomer(){

        customerService.saveCustomer(customer);

        return SUCCESS;
    }

    @Override
    public Customer getModel() {
        return customer;
    }





















}
