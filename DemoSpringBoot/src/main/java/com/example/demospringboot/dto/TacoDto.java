package com.example.demospringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoDto {
    private long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min=1, message = "You must be have 1 character")

    private String name;

    private List<IngredientRefDto> ingredients;
}
