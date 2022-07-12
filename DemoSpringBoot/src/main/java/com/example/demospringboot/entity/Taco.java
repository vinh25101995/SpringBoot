package com.example.demospringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date createdAt = new Date();

    private String name;

    @OneToMany(mappedBy = "taco")
    private List<IngredientRef> ingredients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "taco_order")
    private TacoOrder tacoOrder;

    private int tacoOrderKey;
}
