package xin.yuan.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import xin.yuan.domain.Customer;
import xin.yuan.service.CustomerService;
import xin.yuan.service.impl.CustomerServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.List;

/**
 * @authorknightx
 * @create2019/1/8
 * @since 1.0.0
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private  HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private HttpSession session = null;
    private ServletContext application = null;



    private CustomerService service = new CustomerServiceImpl();
    Customer customer = new Customer();

//查询所有
    public String findAllCustomer(){

       List<Customer> customerList =  service.findAllCustomer();
       //request对象不再由Tomcat提供，而是由Struts2用装饰这模式进行了增强


         request = ServletActionContext.getRequest();
        request.setAttribute("customerList",customerList);


        return SUCCESS;
    }


    //新增一个对象

    public  String insertCustomer(){


       service.insertCustomer(customer);

        return SUCCESS;
    }

    @Override
    public Customer getModel() {
        return customer;
    }




















/**
//域对象的获取
    public String demo1(){
        //这三个对象由Tomcat提供
        response = ServletActionContext.getResponse();
        session = request.getSession();
        application = ServletActionContext.getServletContext();

        return null;
    }
 */
}
