package xin.yuan.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



/**
 * @authorknightx
 * @create2019/1/12
 * @since 1.0.0
 * 自定义拦截器
 */
public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

       System.out.println("Myinterceptor：你访问action之前被拦截了");//访问action时会执行这些代码（invoke之前的）
         String invoke = actionInvocation.invoke();//拦截器的放行，可以去访问action和jsp了
        System.out.println("Myinterceptor：你访问action之后拦截了");//访问完资源了，要出去了（页面内容被放入缓冲区，浏览器还看不到显示内容）
        return invoke;//出去了（页面有显示了）
    }
}
