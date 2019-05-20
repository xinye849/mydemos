package xin.yuan.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author熊源新
 * @create2018/12/30
 * @since 1.0.0
 *
 * many-to-many的jpa注解映射实现
 */
@Entity
@Table(name="sys_user")
public class SysUser implements Serializable {
    @Id
    @GenericGenerator(name="native",strategy = "native")
    @GeneratedValue(generator ="native")//使用hibernate的自增长
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_state")
    private String userState;

    //多对多关系映射的描述
    @ManyToMany(targetEntity = SysRole.class ,cascade =CascadeType.PERSIST )
    //多对多中，由任意一方建立一张中间表，并为中间表创建全部的外键，所以，另一方没事做了，可以不用理了
    @JoinTable(name = "user_role_tb",
            joinColumns ={@JoinColumn(name = "user_id_tb",referencedColumnName = "user_id")}//当前实体在中间表的外键
            ,inverseJoinColumns = {@JoinColumn(name = "role_id_tb",referencedColumnName = "role_id")})//另一张表在中间表中的外键
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
