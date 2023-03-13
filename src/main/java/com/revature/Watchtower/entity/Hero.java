package com.revature.Watchtower.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    @Column(name = "Secret_Identity")
    private String civName;
    @Column(name = "species")
    private String species;
    @Column(name = "has_power")
    private boolean hasPower;
    private String power;
    private String imgLink;


    public Hero(String alias, String civName, String species, boolean hasPower, String power, String imgLink){
        this.alias = alias;
        this.civName = civName;
        this.species = species;
        this.hasPower = hasPower;
        this.power = power;
        this.imgLink = imgLink;
    }


}
