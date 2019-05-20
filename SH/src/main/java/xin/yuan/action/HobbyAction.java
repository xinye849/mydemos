package xin.yuan.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import xin.yuan.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @authorknightx
 * @create2019/1/9
 * @since 1.0.0
 * 表单数据的获取方式
 */
public class HobbyAction extends ActionSupport implements ModelDriven<User> {



    /**把这个注释打开就是完整的第一种方式
     *
     *private HttpServletRequest request = null;

     // 1.最蠢的获取表单数据方法，没实际作用，
     public String subHobby1(){
     request = ServletActionContext.getRequest();
     String name = request.getParameter("name");
     String age = request.getParameter("age");
     String birth = request.getParameter("birth");
     String[] hobby =  request.getParameterValues("hobby");
     System.out.println("姓名："+ name + "年龄："+age+"生日:"+birth +"爱好"+hobby[0]+hobby[1]+hobby[2]);

     return SUCCESS;
     }
     */




/**
*这个是第二种方式，把这个注释打开就是完整的第二种方式
*@return:
*@since: 1.0.0
*@Author:knightx
*@Date:2019/1/10



    private  String name;
    private Integer age;
    private Date birth;
    private String hobby;

// 2.把表单数据直接封装到动作类中，可以不用拿到request对象，Struts2直接帮你封装到bean（不是真正的实体类，顶多算半个）对象中，
// 但是，bean属性的set/get方法后面的名字必须与表单数据的名字一样（bean属性名可以不一样），否则，封装失败。
    //使用场景：分页查询。

    public String subHobby2(){

        System.out.println("姓名=="+name+"年龄===="+age+"生日====="+birth+"爱好=="+hobby);
        return SUCCESS;
    }
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

    */



/**
*@method:
*@return:
*@since: 1.0.0
*@Author:knightx
*@Date:2019/1/10


// 3.为表单数据建立实体类，把表单数据封装到实体类中，并在acting类中包含实体类对象并为其添加set/get方法
// 在这里我建立名为User的实体类，实体类对应的表单必须用OGNL表达式来写，
// ognl表达式就是在表单的name属性前面加上实体类对象，
// 为什么是加实体类对象就行了呢，因为Struts2帮我们省去了set/get前缀，
// 本来是user.setName之类的，现在只需在表单这样写：user.name就可以了
//此种方法还可以用来同时封装多个表单数据，这个时候的user必须是集合类对象。
例：List<User> users = null;此时，表单的ognl要写成数组形式如users[0].name;


 private User user = null;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String subHobby3(){

        System.out.println(user);

        return SUCCESS;
    }

*/


// 4.这种方式最实用，既不像第二种方式那样污染action类，也不像第三种方式那样让我们看不懂表单，
// 这种方式必须实现modeldriven接口，并且实例化实体类，不需要为实体对象添加set/get方法，
// 必须实现接口方法，且此方法的返回值必须是实例化了的实体类对象。
 User user = new User();//实例化实体类
@Override
public User getModel() {//必须实现的接口方法且返回值为实体类
    return user;
}
public String subHobby4(){
    System.out.println(user);

    return SUCCESS;
}
}
