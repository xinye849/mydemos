package xin.yuan;

import com.opensymphony.xwork2.Action;

/**
 * @authorknightx
 * @create2019/1/7
 * @since 1.0.0
 */

public class HelloStruts2 implements Action
{
    @Override
    public String execute() throws Exception {
        System.out.println("你好struts2");
        return SUCCESS;
    }
}
