package com.azudev.crudMysql.repositories;

import com.azudev.crudMysql.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {
}
