package xin.yuan.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.message.ReusableMessage;
import org.apache.struts2.ServletActionContext;

/**
 * @authorknightx
 * @create2019/1/12
 * @since 1.0.0
 */
public class CheckInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        Object obj= ServletActionContext.getRequest().getSession().getAttribute("userinfo");
        if(obj==null){
            return "login";
        }
        return actionInvocation.invoke();


    }
}
