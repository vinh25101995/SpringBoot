package com.example.demospringboot.dto;

import com.example.demospringboot.dto.Taco;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private Date placedAt;

    String name = "deliveryName";
    @NotBlank(message = "Delivery Name can't be empty")
    private String deliveryName;

    @NotBlank(message = "Delivery Street can't be empty")
    private String deliveryStreet;

    @NotBlank(message = "Time can't be blank")
    private String deliveryTime;

    @NotBlank(message = "City can't be blank")
    private String deliveryCity;

    @NotBlank(message = "State can't be blank")
    private String deliveryState;

    @NotBlank(message = "Zip can't be blank")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a credit card number")
    private String ccNumber;

    @NotBlank(message = "ccExpiration can't be blank")
    private String ccExpiration;

    @NotBlank(message = "ccCVV can't be blank")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
