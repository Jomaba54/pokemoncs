package project.pokemoncs.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer level;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Byte isMale;
    @Column
    private Double height;
    @Column
    private Double weight;
    @Column
    private Double totalHP;
    @Column
    private Double currentHP;
    @Column
    private Double attack;
    @Column
    private Double specialAttack;
    @Column
    private Double defense;
    @Column
    private Double specialDefense;
    @Column
    private Double speed;
    @ManyToOne
    private Ability ability;
    @ManyToMany
    private List<Movement> movement;
    @ManyToMany
    private List<Type> type;


    public void setType(List<Type> type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    public void setIsMale(Byte isMale) {
        this.isMale = isMale;
    }
    public void setMovement(List<Movement> movement) {
        this.movement = movement;
    }
    public void setTotalHP(Double totalHP) {
        this.totalHP = totalHP;
    }
    public void setCurrentHP(Double currentHP) {
        this.currentHP = currentHP;
    }
    public void setAttack(Double attack) {
        this.attack = attack;
    }
    public void setDefense(Double defense) {
        this.defense = defense;
    }
    public void setSpecialAttack(Double specialAttack) {
        this.specialAttack = specialAttack;
    }
    public void setSpecialDefense(Double specialDefense) {
        this.specialDefense = specialDefense;
    }
    public void setSpeed(Double speed) {
        this.speed = speed;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public List<Type> getType() {
        return type;
    }
    public Ability getAbility() {
        return ability;
    }
    public Double getHeight() {
        return height;
    }
    public Byte getIsMale() {
        return isMale;
    }
    public Double getWeight() {
        return weight;
    }
    public List<Movement> getMovement() {
        return movement;
    }
    public Double getCurrentHP() {
        return currentHP;
    }
    public Double getTotalHP() {
        return totalHP;
    }
    public Double getAttack() {
        return attack;
    }
    public Double getDefense() {
        return defense;
    }
    public Double getSpecialAttack() {
        return specialAttack;
    }
    public Double getSpecialDefense() {
        return specialDefense;
    }
    public Double getSpeed() {
        return speed;
    }
    public Integer getLevel() {
        return level;
    }

    @ManyToOne(optional = false)
    private Trainer trainers;

    public Trainer getTrainers() {
        return trainers;
    }

    public void setTrainers(Trainer trainers) {
        this.trainers = trainers;
    }
}
