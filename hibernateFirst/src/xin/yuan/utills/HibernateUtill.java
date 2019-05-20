package xin.yuan.utills;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author熊源新
 * @create2018/12/28
 * @since 1.0.0
 */
public class HibernateUtill {

    private static SessionFactory factory;
    static {
        try {


        Configuration cfg = new Configuration();
        cfg.configure();//加载主配置文件，默认从类路径下找名为hibernate.cfg.xml文件
         factory = cfg.buildSessionFactory();//得到工厂类对象
        }catch (ExceptionInInitializerError e){
            throw new ExceptionInInitializerError("初始化失败，检查配置文件");
        }
    }

    public static Session openSession(){
        //每次调用openSession方法都会产生一个新的session对象，
        return factory.openSession();
    }

    public static Session getCurrentSession(){

        /**
        *此方法可以保证在一个线程中只有一个session，
        * 但是，使用该方法的前提是必须在主配置文件中对session与线程进行了绑定
        */
        return factory.getCurrentSession();
    }


}
