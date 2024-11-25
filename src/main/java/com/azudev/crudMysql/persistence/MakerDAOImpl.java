package com.azudev.crudMysql.persistence;

import com.azudev.crudMysql.entities.Maker;
import com.azudev.crudMysql.repositories.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void delete(Long id) {
        makerRepository.deleteById(id);
    }
}
