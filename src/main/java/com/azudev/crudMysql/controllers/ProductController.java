package com.azudev.crudMysql.controllers;


import com.azudev.crudMysql.controllers.DTO.MakerDTO;
import com.azudev.crudMysql.controllers.DTO.ProductDTO;
import com.azudev.crudMysql.entities.Maker;
import com.azudev.crudMysql.entities.Product;
import com.azudev.crudMysql.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productDTO);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("findall")
    public ResponseEntity<?> findAll() {
        List<ProductDTO> products = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .price(product.getPrice())
                        .name(product.getName())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {

        if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null){
            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
                .price(productDTO.getPrice())
                .name(productDTO.getName())
                .maker(productDTO.getMaker())
                .build();

        productService.save(product);
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());
            productService.save(product);
            return ResponseEntity.ok("product updated");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        if (id!= null){
            productService.delete(id);
            return ResponseEntity.ok("Product has been deleted");
        }

        return ResponseEntity.badRequest().build();
    }
}
