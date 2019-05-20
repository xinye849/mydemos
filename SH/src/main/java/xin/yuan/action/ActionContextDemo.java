package xin.yuan.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import xin.yuan.domain.Customer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @authorknightx
 * @create2019/1/11
 * @since 1.0.0
 */
public class ActionContextDemo extends ActionSupport {
    public String domo1(){

        //获取actionContext对象：Struts2自己定义的一个域对象
        ActionContext context = ActionContext.getContext();//从当前线程上取得的context对象；
        context.put("context1","context2");//actioncontext对象也是一个域对象，可以往里存东西；
        //通过actionContext对象获得application对象
        Map<String,Object> application = context.getApplication();
        //往里存东西
        application.put("application","application");
        //通过原始方式获得application
        ServletContext applicationattr = ServletActionContext.getServletContext();
        applicationattr.setAttribute("applicationattr","applicationattr");
        //通过ActionContext获得session对象
        Map<String,Object> session3 = context.getSession();
        session3.put("session1","session2");
        //通过原始方式获得session对象
        HttpSession sessionattr4 = ServletActionContext.getRequest().getSession();
        sessionattr4.setAttribute("sessionattr5","sessionattr6");
        //通过ActionContext对象获得request对象,跟上面两种取得对象有点不同
        Map<String,Object> request2 = (Map)context.get("request");
        request2.put("request1","request");
        //通过原始凡是获得request对象：
        HttpServletRequest requestattr = ServletActionContext.getRequest();
        requestattr.setAttribute("requestattr","requestattr");
//通过ActionContext得到valuestack对象：
        //ValueStack valueStack = context.getValueStack();
        //往valuestack中压入一个customer对象：
        //Customer customer = new Customer();
        //customer.setCustName("xiong");
        //customer.setCustPhone("125365");

        //Customer customer2 = new Customer();
        //customer.setCustName("yuan");
        //customer.setCustPhone("12522365");

        //valueStack.push(customer);
        //valueStack.push(customer2);
        System.out.println("i am action");
        return SUCCESS;
    }

}
