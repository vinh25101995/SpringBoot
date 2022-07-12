package com.example.demospringboot.converter;
import java.util.HashMap;
import java.util.Map;

import com.example.demospringboot.dto.IngredientDto;
import com.example.demospringboot.dto.IngredientDto.Type;
import com.example.demospringboot.dto.IngredientRefDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class IngredientByIdConverter implements Converter<String, IngredientRefDto> {
    @Override
    public IngredientRefDto convert(String id) {
        return new IngredientRefDto(id);
    }
}