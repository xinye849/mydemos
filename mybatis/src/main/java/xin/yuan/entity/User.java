package xin.yuan.entity;

import java.io.Serializable;

/**
 * @authorknightx
 * @create2019/3/4
 * @since 1.0.0
 */
public class User implements Serializable {
    private int myId;

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    private String name;
    private String sex;
    private int money;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                ", id="+ myId +
                '}';
    }
}
