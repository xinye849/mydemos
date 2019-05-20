package xin.yuan;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @authorknightx
 * @create2019/1/7
 * @since 1.0.0
 */
public class UserAction extends ActionSupport {
    public String addUser(){
        System.out.println("增加用户成功");
        return SUCCESS;
    }

    public String deleteUser(){
        System.out.println("删除用户成功");
        return SUCCESS;
    }

    public String updateUser(){
        System.out.println("更新用户成功");
        return SUCCESS;
    }

    public String findUser(){
        System.out.println("查找用户成功");
        return SUCCESS;
    }



}


