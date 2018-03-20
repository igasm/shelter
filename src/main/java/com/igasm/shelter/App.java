package com.igasm.shelter;

import com.igasm.shelter.controller.AnimalController;
import com.igasm.shelter.dao.AnimalDAOImpl;
import com.igasm.shelter.services.AnimalServiceImpl;

//TODO add persistence layer

public class App {

    public static void main(String[] args) {
        new AnimalController(new AnimalServiceImpl(new AnimalDAOImpl()));
    }

}
