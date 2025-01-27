package com.azudev.crudMysql.controllers.DTO;

import com.azudev.crudMysql.entities.Maker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {


    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
