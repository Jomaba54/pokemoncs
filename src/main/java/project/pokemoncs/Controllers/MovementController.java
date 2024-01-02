package project.pokemoncs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.pokemoncs.Models.Movement;
import project.pokemoncs.Repo.MovementRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class MovementController {
    @Autowired
    private MovementRepo repository;

    @GetMapping(value = "/api/getAllMovements")
    public List<Movement> getAllMovements(){
        return repository.findAll();
    }
    @GetMapping(value = "/api/getMovement/{id}")
    public Optional<Movement> getMovement(@PathVariable Long id){
        return repository.findById(id);
    }
    @PostMapping(value = "/api/insertMovement")
    public void insertMovement(@RequestBody Movement movement){
        repository.save(movement);
    }
    @PostMapping(value = "/api/insertMovements")
    public void insertTrainers(@RequestBody List<Movement> movements){
        repository.saveAll(movements);
    }
    @PutMapping(value = "/api/updateMovement/{id}")
    public void updateMovement(@RequestParam Long id, @RequestBody Movement movement){
        Optional<Movement> movementUpdated = repository.findById(id);
        if (movementUpdated.isPresent()) {
            Movement aux = movementUpdated.get();

            aux.setAccuracy(movement.getAccuracy());
            aux.setCategory(movement.getCategory());
            aux.setEffect(movement.getEffect());
            aux.setName(movement.getName());
            aux.setPower(movement.getPower());
            aux.setType(movement.getType());
            aux.setPp(movement.getPp());

            repository.save(aux);
        }
    }
    @DeleteMapping(value = "/api/deleteMovement/{id}")
    public void deleteMovement(@PathVariable Long id){
        repository.deleteById(id);
    }
}
