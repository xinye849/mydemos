package xin.yuan.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @authorknightx
 * @create2019/1/12
 * @since 1.0.0
 */
public class LoginAction extends ActionSupport {

    public String demo1(){

       System.out.println("this is demo1");
        return SUCCESS;
    }

    public String demo2(){

        System.out.println("this is demo2");
        return SUCCESS;
    }

    public String demo3(){

        System.out.println("this is demo3");
        return SUCCESS;
    }

    public String userLogin(){

       ActionContext context =  ActionContext.getContext();
       Map<String,Object> session = context.getSession();
       session.put("userinfo","");

        return SUCCESS;
    }
}
