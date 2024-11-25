package com.azudev.crudMysql.service;

import com.azudev.crudMysql.entities.Product;
import com.azudev.crudMysql.persistence.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDAO productDAO;


    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {
        return productDAO.findByPriceInRange(min, max);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void delete(Long id) {
        productDAO.delete(id);
    }
}
