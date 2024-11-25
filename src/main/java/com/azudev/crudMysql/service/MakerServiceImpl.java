package com.azudev.crudMysql.service;

import com.azudev.crudMysql.entities.Maker;
import com.azudev.crudMysql.persistence.IMakerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService{

    @Autowired
    private IMakerDAO makerDAO;


    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void delete(Long id) {
        makerDAO.delete(id);
    }
}
