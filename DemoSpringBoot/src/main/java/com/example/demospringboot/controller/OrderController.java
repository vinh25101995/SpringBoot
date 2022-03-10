package com.example.demospringboot.controller;

import com.example.demospringboot.dto.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute TacoOrder tacoOrder,  Errors errors) {
        log.info("Order submitted: " + tacoOrder);
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted: " + tacoOrder);
        return "redirect:/";
    }
}
