package com.example.demospringboot.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class IngredientRefDto {
    private Long id;

    private final String ingredient;
}
