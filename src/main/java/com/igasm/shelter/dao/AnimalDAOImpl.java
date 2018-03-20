package com.igasm.shelter.dao;

import com.igasm.shelter.model.Animal;
import com.igasm.shelter.model.Species;

import java.util.ArrayList;
import java.util.List;

public class AnimalDAOImpl implements AnimalDao{

    List<Animal> animals;

    public AnimalDAOImpl() {
        animals = new ArrayList <>();

        Animal dog = new Animal(1, "Burek", Species.DOG);
        Animal cat = new Animal(2, "Perałka", Species.CAT);
        Animal horse = new Animal(3, "Błyskawica", Species.HORSE);

        animals.add(dog);
        animals.add(cat);
        animals.add(horse);

    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }
}
