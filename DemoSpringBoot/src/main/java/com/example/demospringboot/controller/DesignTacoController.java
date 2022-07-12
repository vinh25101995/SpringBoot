package com.example.demospringboot.controller;

import com.example.demospringboot.dto.IngredientDto;
import com.example.demospringboot.dto.IngredientDto.Type;
import com.example.demospringboot.dto.TacoDto;
import com.example.demospringboot.entity.Ingredient;
import com.example.demospringboot.entity.Taco;
import com.example.demospringboot.repository.IngredientRepositoryImpl;
import com.example.demospringboot.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignTacoController {
    private IngredientRepositoryImpl jdbcIngredientRepository;
    private TacoRepository tacoRepository;

    private ModelMapper mapper;

    @Autowired
    public DesignTacoController(IngredientRepositoryImpl jdbcIngredientRepository, TacoRepository tacoRepository, ModelMapper mapper){
        this.jdbcIngredientRepository = jdbcIngredientRepository;
        this.tacoRepository = tacoRepository;
        this.mapper = mapper;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<IngredientDto> ingredients = StreamSupport.stream(jdbcIngredientRepository.findAll().spliterator(),false).map(ingredient -> mapper.map(ingredient, IngredientDto.class)).collect(Collectors.toList());
        Type[] types = IngredientDto.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model){
        model.addAttribute("tacoDto",new TacoDto());
        return ("design");
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String processTaco(@Valid @ModelAttribute TacoDto taco, Errors errors, RedirectAttributes redirectAttributes){
        if(errors.hasErrors()){
            log.info("Has error");
        }
        taco.setCreatedAt(new Date());
        redirectAttributes.addFlashAttribute("taco",taco);
        return ("redirect:/orders/current");
    }

    private Iterable<IngredientDto> filterByType(List<IngredientDto> ingredients,Type type) {
            return StreamSupport.stream(ingredients.spliterator(),false).filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList());
    }
    }
