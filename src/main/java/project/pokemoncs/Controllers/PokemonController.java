package project.pokemoncs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.pokemoncs.Models.Pokemon;
import project.pokemoncs.Repo.PokemonRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController {
    @Autowired
    private PokemonRepo repository;

    @GetMapping(value = "/api/getAllPokemons")
    public List<Pokemon> getAllPokemons(){
        return repository.findAll();
    }
    @GetMapping(value = "/api/getPokemon/{id}")
    public Optional<Pokemon> getPokemon(@PathVariable Long id){
        return repository.findById(id);
    }
    @PostMapping(value = "/api/insertPokemon")
    public void insertPokemon(@RequestBody Pokemon pokemon){
        repository.save(pokemon);
    }
    @PostMapping(value = "/api/insertPokemons")
    public void insertTrainers(@RequestBody List<Pokemon> pokemons){
        repository.saveAll(pokemons);
    }
    @PutMapping(value = "/api/updatePokemon/{id}")
    public void updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon){
        Optional<Pokemon> pokemonUpdated = repository.findById(id);
        if (pokemonUpdated.isPresent()) {
            Pokemon aux = pokemonUpdated.get();

            aux.setName(pokemon.getName());
            aux.setType(pokemon.getType());
            aux.setDescription(pokemon.getDescription());
            aux.setAbility(pokemon.getAbility());
            aux.setHeight(pokemon.getHeight());
            aux.setIsMale(pokemon.getIsMale());
            aux.setWeight(pokemon.getWeight());
            aux.setMovement(pokemon.getMovement());
            aux.setTotalHP(pokemon.getTotalHP());
            aux.setCurrentHP(pokemon.getCurrentHP());
            aux.setAttack(pokemon.getAttack());
            aux.setSpecialAttack(pokemon.getSpecialAttack());
            aux.setDefense(pokemon.getDefense());
            aux.setSpecialDefense(pokemon.getSpecialDefense());
            aux.setSpeed(pokemon.getSpeed());
            aux.setLevel(pokemon.getLevel());

            repository.save(aux);
        }
    }
    @DeleteMapping(value = "/api/deletePokemon/{id}")
    public void deletePokemon(@PathVariable Long id){
        repository.deleteById(id);
    }

}
