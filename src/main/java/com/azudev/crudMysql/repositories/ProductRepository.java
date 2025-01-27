package com.azudev.crudMysql.repositories;

import com.azudev.crudMysql.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
//    Query methods
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

//    Query anotation
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 and ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
