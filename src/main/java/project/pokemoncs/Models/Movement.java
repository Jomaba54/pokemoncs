package project.pokemoncs.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Float power;
    @Column
    private Float accuracy;
    @Column
    private Integer pp;
    @Column
    private String effect;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Type> type;


    public void setName(String name) {
        this.name = name;
    }
    public void setType(List<Type> type) {
        this.type = type;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }
    public void setPower(Float power) {
        this.power = power;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }
    public void setPp(Integer pp) {
        this.pp = pp;
    }


    public String getName() {
        return name;
    }
    public List<Type> getType() {
        return type;
    }
    public Category getCategory() {
        return category;
    }
    public Float getAccuracy() {
        return accuracy;
    }
    public Float getPower() {
        return power;
    }
    public Integer getPp() {
        return pp;
    }
    public String getEffect() {
        return effect;
    }
}
