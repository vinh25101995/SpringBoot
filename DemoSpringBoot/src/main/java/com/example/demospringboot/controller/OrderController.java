package com.example.demospringboot.controller;

import com.example.demospringboot.dto.TacoDto;
import com.example.demospringboot.dto.TacoOrderDto;
import com.example.demospringboot.entity.TacoOrder;
import com.example.demospringboot.repository.TacoOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private TacoOrderRepository tacoOrderRepository;

    private ModelMapper mapper;

    public OrderController(TacoOrderRepository tacoOrderRepository, ModelMapper mapper){
        this.tacoOrderRepository = tacoOrderRepository;
        this.mapper = mapper;
    }

    @GetMapping("/current")
    public String orderForm(@ModelAttribute("taco") TacoDto taco, Model model, HttpSession session){
        TacoOrderDto tacoOrder = new TacoOrderDto();
        session.setAttribute("taco",taco);
        model.addAttribute("tacoOrderDto", tacoOrder);
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute TacoOrderDto tacoOrder, Errors errors, SessionStatus sessionStatus,HttpSession session) {
        TacoDto taco = (TacoDto) session.getAttribute("taco");
        if(errors.hasErrors()){
            return "orderForm";
        }
        tacoOrder.addTaco(taco);
        tacoOrder.setPlacedAt(new Date());
        TacoOrder tacoOrder1 = mapper.map(tacoOrder, TacoOrder.class);
        int size = tacoOrder1.getTacos().size();
        for(int i = 0; i < size;i++){
            tacoOrder1.getTacos().get(i).setTacoOrder(tacoOrder1);
        }
        tacoOrderRepository.save(tacoOrder1);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
