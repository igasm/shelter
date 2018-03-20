package com.igasm.shelter.controller;

import com.google.gson.Gson;
import com.igasm.shelter.JsonTransformer;
import com.igasm.shelter.services.AnimalService;

import static spark.Spark.get;

public class AnimalController {

    public AnimalController(final AnimalService animalService) {

        get("/animals",
                (req, res) -> animalService.getAll(),
                new JsonTransformer(new Gson())
        );
    }
}
