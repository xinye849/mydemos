package xin.yuan;

import com.opensymphony.xwork2.Action;

/**
 * @authorknightx
 * @create2019/1/7
 * @since 1.0.0
 */
public class TestAction implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("hello TestAction的execute执行了");
        return SUCCESS;
    }
}
