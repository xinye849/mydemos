package xin.yuan.dao.impl;



import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import xin.yuan.dao.CustomerDao;
import xin.yuan.entity.Customer;

import java.util.List;

/**
 * @authorknightx
 * @create2019/1/8
 * @since 1.0.0
 */
public class customerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    /*
      *HibernateDaoSupport这个类的setSessionFactory方法可以生成hibernateTemplate对象，所以，我们只要在spring中注入sessFactory就行了，所以，这两行代码就可以不要了

      private HibernateTemplate hibernateTemplate ;


    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }*/

    @Override
    public List<Customer> findAllCustomer() {

       List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer ");
        return list;
    }

    @Override


    public void saveCustomer(Customer customer) {

        getHibernateTemplate().save(customer);


    }

}
