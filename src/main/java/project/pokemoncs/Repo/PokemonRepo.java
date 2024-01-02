package project.pokemoncs.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.pokemoncs.Models.Pokemon;

public interface PokemonRepo extends JpaRepository<Pokemon, Long> {
}