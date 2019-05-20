package xin.yuan.service;

import xin.yuan.domain.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> findAll() throws Exception;
    void savePorduct(Product product) throws Exception;
}
