package project.pokemoncs.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.pokemoncs.Models.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
}
