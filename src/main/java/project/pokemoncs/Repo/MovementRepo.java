package project.pokemoncs.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.pokemoncs.Models.Movement;
public interface MovementRepo extends JpaRepository<Movement, Long> {
}
