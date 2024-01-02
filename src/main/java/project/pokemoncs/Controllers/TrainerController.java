package project.pokemoncs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.pokemoncs.Models.Trainer;
import project.pokemoncs.Repo.TrainerRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {
    @Autowired
    private TrainerRepo repository;

    @GetMapping(value = "/api/getAllTrainers")
    public List<Trainer> getAllTrainers(){
        return repository.findAll();
    }
    @GetMapping(value = "/api/getTrainer/{id}")
    public Optional<Trainer> getTrainer(@PathVariable Long id){
        return repository.findById(id);
    }
    @PostMapping(value = "/api/insertTrainer")
    public void insertTrainer(@RequestBody Trainer trainer){
        repository.save(trainer);
    }
    @PostMapping(value = "/api/insertTrainers")
    public void insertTrainers(@RequestBody List<Trainer> trainers){
        repository.saveAll(trainers);
    }
    @PutMapping(value = "/api/updateTrainer/{id}")
    public void updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer){
        Optional<Trainer> trainerUpdated = repository.findById(id);
        if (trainerUpdated.isPresent()) {
            Trainer aux = trainerUpdated.get();

            aux.setName(trainer.getName());
            aux.setPokemon(trainer.getPokemon());

            repository.save(aux);
        }
    }
    @DeleteMapping(value = "/api/deleteTrainer/{id}")
    public void deleteTrainer(@PathVariable Long id){
        repository.deleteById(id);
    }
}
