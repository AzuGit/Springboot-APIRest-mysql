package com.azudev.crudMysql.controllers.DTO;

import com.azudev.crudMysql.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakerDTO {

    private Long id;
    private String name;
    private List<Product> productsList = new ArrayList<>();
}
