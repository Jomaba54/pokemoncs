package project.pokemoncs.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany
    private List<Pokemon> pokemon;


    public void setName(String name) {
        this.name = name;
    }
    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }


    public String getName() {
        return name;
    }
    public List<Pokemon> getPokemon() {
        return pokemon;
    }
}
