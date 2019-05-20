package xin.yuan.domain;

import java.util.Date;

/**
 * @authorknightx
 * @create2019/1/10
 * @since 1.0.0
 * 这个是表单数据封装的第三种方式，这个是表单数据的实体类
 */
public class User {

    private  String name;
    private Integer age;
    private Date birth;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
