package com.azudev.crudMysql.service;

import com.azudev.crudMysql.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByPriceInRange(BigDecimal min, BigDecimal max);

    void save(Product product);

    void delete(Long id);
}
