package xin.yuan.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author熊源新
 * @create2018/12/31
 * @since 1.0.0
 *
 *
 * Jpa工具类
 */
public class JPAUtil {
    //相当于sessinFactory
    private static EntityManagerFactory factory;
    static {
      factory = Persistence.createEntityManagerFactory("myJpaUnit");
    }
    //创建实体类管理器，相当于getCurrentSession
    public static EntityManager creatEntityManager(){
        //得到管理对象， 相当于得到session
        return factory.createEntityManager();
    }

}
