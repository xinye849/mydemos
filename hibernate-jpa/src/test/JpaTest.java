package test;

import org.hibernate.Transaction;
import org.junit.Test;
import xin.yuan.domain.Customer;
import xin.yuan.domain.LinkMan;
import xin.yuan.domain.SysRole;
import xin.yuan.domain.SysUser;
import xin.yuan.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * @author熊源新
 * @create2018/12/31
 * @since 1.0.0
 *
 *           JPA的crud操作
 */


public class JpaTest {
    //保存操作
    @Test
    public void testSave(){
        Customer c = new Customer();
        c.setCustName("jpa2");
        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       em.persist(c);//保存，相当于save（）；

       tx.commit();
    }

    //更新操作
    @Test
    public void testUpdate(){

        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer c = em.find(Customer.class,1L);
        c.setCustAddress("横坑");
        c.setCustPhone("125361546");
        em.merge(c);//融合，就是相当于update
        tx.commit();
    }

//查询一个
    @Test
    public void testFind(){

        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer c = em.find(Customer.class,1L);//相当于hibernate的get方法
        Customer c2 = em.getReference(Customer.class,2L);//相当于load方法（延迟加载）
        System.out.println(c);
        tx.commit();
    }


//删除操作
    @Test
    public void testDelete(){

        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer c = em.find(Customer.class,2L);
        em.remove(c);


        tx.commit();
    }


    /**
    *@method:
    *@return:
    *@since: 1.0.0
     * *----查询所有-----
            *用到的是jpal
     * jpal跟hql很相似，都要先的到query对象
     * 但是，jpal不能省略select
     * 跟hql一样不能使用*
     * 都是from 实体类 ，实体类必须加别名，然后把别名加到select 之后
     *
    *@Author:熊源新
    *@Date:2018/12/31
    */
@Test
    public void testFindAll(){

        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select c from Customer c ");//可以运行，但是会报错，很奇怪
        List<Customer> list = query.getResultList();
        for (Customer cust :list){
            System.out.println(cust);
        }



        tx.commit();
    }



    //jpaL中带条件查询所有
    @Test
    public void testFindAllWhere(){

        EntityManager em = JPAUtil.creatEntityManager();//拿到实体管理器也就是本土的session对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //占位符从1开始
        Query query = em.createQuery("select c from Customer c where custName=:name");
        query.setParameter("name","jpa1");
        //占位符的第二种形式
            //Query query2 = em.createQuery("select c from Customer c where custName=?1");
           // query2.setParameter(1,"jpa1");
        List<Customer> list = query.getResultList();
        for (Customer cust :list){
            System.out.println(cust);
        }



        tx.commit();
    }


    //----------------------------jpaL多表操作
    @Test
    //保存操作
    public void moreToOen(){
    Customer c = new Customer();
    LinkMan l = new LinkMan();
    c.setCustName("jpa customer3");
    l.setLkmName("jpa linkman3");
    //建立客户和联系人的双向关联
   c.getLinkmans().add(l);
    l.setCustomer(c);
    EntityManager em = JPAUtil.creatEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    //建立了双向关联之后进行保存到数据库
    em.persist(c);
    em.persist(l);
    tx.commit();


    }

    //更新

    @Test
    public void updateM(){
    LinkMan linkMan = new LinkMan();
    linkMan.setLkmName("jpa更新到3客户");
    EntityManager em = JPAUtil.creatEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Customer c3 = em.find(Customer.class,3L);
    c3.getLinkmans().add(linkMan);
       linkMan.setCustomer(c3);
   // em.merge(linkMan);
    tx.commit();



}

    //---------------------查询
    //查指定对象的话，可以不用SQL语句，当遇到的是查询一类东西的时候，还是要用到查询多个的hql/jpal语句
    @Test
    public void FindMore(){

    EntityManager em = JPAUtil.creatEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Customer c1 = em.find(Customer.class,4L);
        Set list = c1.getLinkmans();
        for (Object o:list){
            System.out.println(o);

        }



    }




    //------------------------------jpa的多对多操作
//级联保存
    @Test
    public void saveMToM(){
        SysUser u1= new SysUser();
        SysUser u2 = new SysUser();
        u1.setUserName("jpa u1");
        u2.setUserName("jpa u2");

        SysRole r1= new SysRole();
        SysRole r2= new SysRole();
        SysRole r3= new SysRole();
        r1.setRoleName( "jpa r1");
        r2.setRoleName( "jpa r2");
        r3.setRoleName( "jpa r3");

        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        u2.getRoles().add(r2);
        u2.getRoles().add(r3);

        r1.getUsers().add(u1);
        r2.getUsers().add(u1);
        r2.getUsers().add(u2);
        r3.getUsers().add(u2);

        EntityManager em = JPAUtil.creatEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u1);
        tx.commit();

    }



//删除
@Test
    public void deleteMToM(){

    EntityManager em = JPAUtil.creatEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    SysUser c2 = em.find(SysUser.class,2L);
    System.out.println(c2);
    em.remove(c2);
    tx.commit();
    }


}
