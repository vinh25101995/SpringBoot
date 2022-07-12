package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Taco;
import com.example.demospringboot.repository.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/design",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class TacoOrderController {
    private TacoRepository tacoRepository;

    public TacoOrderController(TacoRepository tacoRepository){
        this.tacoRepository = tacoRepository;
    }

    @GetMapping
    public Iterable<Taco> getTaco(){
        PageRequest pageRequest = PageRequest.of(0,12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(pageRequest).getContent();
    }
}
