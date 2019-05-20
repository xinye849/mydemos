package xin.yuan.service;



import xin.yuan.domain.Orders;

import java.util.List;

public interface OrdersService {


    List<Orders> findAll(int page, int size) throws Exception;
}
