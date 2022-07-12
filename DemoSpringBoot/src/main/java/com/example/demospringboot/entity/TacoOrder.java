package com.example.demospringboot.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class TacoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date placedAt;

    private String deliveryName;

    private String deliveryStreet;

    private String deliveryCity;

    private String deliveryState;

    private String deliveryZip;

    private String ccNumber;

    private String ccExpiration;

    private String ccCvv;

    @OneToMany(mappedBy = "tacoOrder",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }

}
