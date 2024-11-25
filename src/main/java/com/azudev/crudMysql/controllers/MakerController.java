package com.azudev.crudMysql.controllers;

import com.azudev.crudMysql.controllers.DTO.MakerDTO;
import com.azudev.crudMysql.entities.Maker;
import com.azudev.crudMysql.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productsList(maker.getProductsList())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        List<MakerDTO> makerList = makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productsList(maker.getProductsList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerList);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {
        if (makerDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        makerService.save(Maker.builder().name(makerDTO.getName()).build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatemaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Register updated");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMaker(@PathVariable Long id) {
        if (id!=null){
            makerService.delete(id);
            return ResponseEntity.ok("Maker deleted");
        }

        return ResponseEntity.badRequest().build();
    }
}
