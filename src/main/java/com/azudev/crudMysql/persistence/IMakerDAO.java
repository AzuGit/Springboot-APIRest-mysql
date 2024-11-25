package com.azudev.crudMysql.persistence;

import com.azudev.crudMysql.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    void save(Maker maker);

    void delete(Long id);


}
