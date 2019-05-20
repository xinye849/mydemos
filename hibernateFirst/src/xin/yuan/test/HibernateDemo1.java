package xin.yuan.test;

import com.sun.javafx.scene.traversal.Hueristic2D;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import xin.yuan.domain.Customer;
import xin.yuan.domain.LinkMan;
import xin.yuan.domain.SysRole;
import xin.yuan.domain.SysUser;
import xin.yuan.utills.HibernateUtill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static xin.yuan.utills.HibernateUtill.openSession;

/**
 * @author熊源新
 * @create2018/12/28
 * @since 1.0.0
 */
public class HibernateDemo1 {
    //保存操作
    @Test
    public void testSave() {
        Customer c = new Customer();
        c.setCustName("新");
        c.setCustSource("sfd");
        c.setCustLevel("dfdf");
        c.setCustIndustry("dfds");
        c.setCustAddress("fjldj");
        c.setCustPhone("1234589");

        Session session = HibernateUtill.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();


    }
//删除操作
    @Test
    public void testDelett() {
        Session session = HibernateUtill.openSession();
        Transaction tx = session.beginTransaction();
        Customer c = session.get(Customer.class, 2L);
        session.delete(c);
        tx.commit();
        session.close();

    }
//更新操作
    @Test
    public void testUpdate() {

        Session session = HibernateUtill.openSession();
        Transaction tx = session.beginTransaction();
        Customer c = session.get(Customer.class, 1L);
        c.setCustAddress("横坑");
        session.update(c);
        tx.commit();
        session.close();
    }
//查询一个，也可用load，load为延迟加载，什么时候用，什么时候查询
    @Test
    public void testGet() {
        Session session = HibernateUtill.openSession();
        Transaction tx = session.beginTransaction();
        Customer c = session.get(Customer.class, 1L);
        tx.commit();
        System.out.println(c);
    }

//验证c3p0是否生效
    @Test
    public void testC3P0() {
        Session session = HibernateUtill.openSession();
        session.doWork(new Work() {//使用jdbc这个原始连接

            @Override
            public void execute(Connection con) throws SQLException {
                System.out.println(con.getClass().getName());
            }
        });
    }


    @Test
    //验证session是否与thread绑定成功
    public void currentSession() {
        Session session1 = HibernateUtill.getCurrentSession();
        Session session2 = HibernateUtill.getCurrentSession();
        System.out.println(session1 == session2);


    }

    @Test
    public void currerntSession2() {
        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Customer c = session.get(Customer.class, 1L);
        c.setCustName("currentS");
        session.update(c);
        tx.commit();
    }


    //HQL的查询
    @Test
    public void hibernateHqlBasic() {
        //基本hql查询
        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Customer ");
        List<Customer> list = query.list();
        for (Customer c : list) {
            System.out.println(c);
        }

    }


    //带条件的hql查询
    @Test
    //带条件的hql查询：
    public void testSqlWhere() {
        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //占位符不再从0开始，而是从1开始
        //Query query = session.createQuery("from Customer where custName=?1 and custId=?2");
        //更先进的方法：用冒号代替占位符，冒号后面的名字可随便取。
        Query query = session.createQuery("from Customer where custName=:name and custId=:id");
        query.setParameter("name", "xin");
        query.setParameter("id", 3L);
        List<Customer> list = query.list();
        for (Customer c : list) {
            System.out.println(c);
        }

    }


    @Test
    //分页查询，必须在主配置文件中配置方言，因为分页用到的是limit，
    public void testSqlLimit() {
        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Customer ");
        //相当于limit里的offset，
        query.setFirstResult(2);
        //相当于limit里的length
        query.setMaxResults(2);
        List<Customer> list = query.list();
        for (Customer c : list) {
            System.out.println(c);


        }

    }


    @Test
    //投影查询
    public void hibernateHqlTouYing() {

        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select new xin.yuan.domain.Customer(custId,custName) from Customer ");
        List<Customer> list = query.list();
        for (Customer c : list) {
            System.out.println(c);
        }

    }


    //这里我在数据库中是没有建立tb_linkman表的，
    // 也没有建立两张表之间的关系，
    // 但是，由于我在主配置文件中配了
    // <property name="hibernate.hbm2ddl.auto">update</property>这个，
    //如果数据库的表跟我的配置文件不同，会自动更新数据库中的表，所以，这
    // 里我直接生成session对象，就可以建表了。
    @Test
    public void testOneToMany(){

        Session session = HibernateUtill.getCurrentSession();

    }


//-------------------------多表查询-----------------------
@Test
    public void testSaveOneToMany(){
        Customer customer = new Customer();
        customer.setCustName("一方2");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("多方2");
        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);

        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        session.save(linkMan);
        tx.commit();


    }
    @Test
    //级联操作，必须在set映射中配置cascade才可用
    public void testSaveOneToManyJiLian(){
     LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("多方3级联操作3");

        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer c = session.get(Customer.class,2L);
        c.getLinkMans().add(linkMan);
        linkMan.setCustomer(c);
        session.save(c);//虽然c没有要save的必要，但是因为这里有级联的存在，与之对应的linkman也会执行同样的save操作，从而实现linkman保存到数据库中
        tx.commit();


    }

@Test
    public void testDeleteOneToManyJiLian(){


        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer c = session.get(Customer.class,1L);


        session.delete(c);
        tx.commit();


    }


    //多对多的保存操作
    @Test
    public void saveMoreToMore(){
        SysUser u1 =new SysUser();
        u1.setUserName("用户1");
        SysUser u2 = new SysUser();
        u2.setUserName("用户2");

        SysRole r1 = new SysRole();
        r1.setRoleName("角色1");
        SysRole r2 = new SysRole();
        r2.setRoleName("角色2");
        SysRole r3 = new SysRole();
        r3.setRoleName("角色3");
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        u2.getRoles().add(r2);
        u2.getRoles().add(r3);

        Session session = HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(u1);
        tx.commit();







    }





    //多对多删除操作
    @Test
    public void deleteM(){
        Session session =HibernateUtill.getCurrentSession();
        Transaction tx = session.beginTransaction();
        SysUser u2 = session.get(SysUser.class,3L);
        session.delete(u2);
        tx.commit();

    }
}
