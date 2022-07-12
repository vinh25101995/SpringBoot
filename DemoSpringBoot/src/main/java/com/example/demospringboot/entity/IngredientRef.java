package com.example.demospringboot.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class IngredientRef {

    @Id
    private Long id;

    private String ingredient;

    @ManyToOne
    @JoinColumn(name="taco")
    private Taco taco;

}