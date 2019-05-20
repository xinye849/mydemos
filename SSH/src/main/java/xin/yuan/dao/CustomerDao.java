package xin.yuan.dao;



import xin.yuan.entity.Customer;

import java.util.List;

/**
*@method:
*@return:
*@since: 1.0.0
*@Author:knightx
*@Date:2019/1/8
 * 持久层接口
*/


public interface CustomerDao {
//查询所有客户
     List<Customer> findAllCustomer();

     //保存客户
     void saveCustomer(Customer customer);
}
