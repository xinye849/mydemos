package xin.yuan.service.impl;


import xin.yuan.dao.CustomerDao;
import xin.yuan.dao.impl.customerDaoImpl;
import xin.yuan.entity.Customer;
import xin.yuan.service.CustomerService;

import java.util.List;

/**
 * @authorknightx
 * @create2019/1/8
 * @since 1.0.0
 *事物在业务层控制
 * 业务层实现类
 */
public class CustomerServiceImpl implements CustomerService {
/**
*@method:
*@return:
*@since: 1.0.0
*@Author:knightx
*@Date:2019/1/8
 * 查询所有客户
 *
*/
    private CustomerDao customerDao ;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> findAllCustomer() {


    return customerDao.findAllCustomer();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }







}
