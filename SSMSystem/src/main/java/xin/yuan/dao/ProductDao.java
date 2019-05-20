package xin.yuan.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xin.yuan.domain.Product;

import java.util.List;

public interface ProductDao {
    //查询所有的产品信息
    @Select("select * from product")
    public abstract List<Product> findAll() throws Exception;
@Insert("insert into product(productNum,productName,cityName,depatureTime,productPrice,productDesc,productStatus)" +
        " values(#{productNum},#{productName},#{cityName},#{depatureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void saveProduct(Product product) throws Exception;
}
