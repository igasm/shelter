package com.igasm.shelter.services;

import com.igasm.shelter.dao.AnimalDao;
import com.igasm.shelter.model.Animal;

import java.util.List;

public class AnimalServiceImpl implements AnimalService{

    private AnimalDao animalDao;

    public AnimalServiceImpl(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }
}
