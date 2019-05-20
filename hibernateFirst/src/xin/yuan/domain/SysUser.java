package xin.yuan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author熊源新
 * @create2018/12/30
 * @since 1.0.0
 */
public class SysUser implements Serializable {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userState;

    //多对多关系映射的描述
    private Set<SysRole> roles = new HashSet<SysRole>(0);


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userState='" + userState + '\'' +
                '}';
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
