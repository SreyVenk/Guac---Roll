package com.csc340.crud_api_jpa_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Get all animals
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/habitat/{habitat}")
    public List<Animal> getAnimalsByHabitat(@PathVariable String habitat) {
        return animalService.getAnimalsByHabitat(habitat);
    }
    // Get an animal by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
        Animal animal = animalService.getAnimalById(id);
        if (animal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animal);
    }

    // Add a new animal
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // Update an existing animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal animalDetails) {
        Animal updatedAnimal = animalService.updateAnimal(id, animalDetails);
        if (updatedAnimal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAnimal);
    }

    // Delete an existing animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    // Get all animals of a given species
    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // Get animals whose name contains a string
    @GetMapping("/search")
    public List<Animal> getAnimalsByName(@RequestParam String name) {
        return animalService.getAnimalsByName(name);
    }
}
