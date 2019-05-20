package xin.yuan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author熊源新
 * @create2018/12/30
 * @since 1.0.0
 */
public class SysRole implements Serializable {
    private Long roleId;
    private String roleName;
    private String roleMemo;

//描述多对多映射关系：
    private Set<SysUser> users = new HashSet<SysUser>(0);
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }


    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleMemo='" + roleMemo + '\'' +
                '}';
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }
}
