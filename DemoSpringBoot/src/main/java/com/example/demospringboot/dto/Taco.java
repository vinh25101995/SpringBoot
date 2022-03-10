package com.example.demospringboot.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private long id;

    private Date createAt;

    @NotNull
    @Size(min=1, message = "You must be have 1 character")
    private String name;

    @NotNull
    @Size(min=1, message = "You must choose at least 1")
    private List<Ingredient> ingredients;
}
