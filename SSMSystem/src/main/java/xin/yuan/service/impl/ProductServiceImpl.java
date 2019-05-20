package xin.yuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.yuan.dao.ProductDao;
import xin.yuan.domain.Product;
import xin.yuan.service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @authorknightx
 * @create2019/5/3
 * @since 1.0.0
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void savePorduct(Product product) throws Exception {


        productDao.saveProduct(product);
    }
}
