package com.example.demospringboot.dto;

import com.example.demospringboot.entity.Taco;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Data
public class TacoOrderDto {
    private long id;

    private Date placedAt;

    @NotBlank(message = "Delivery Name can't be empty")
    private String deliveryName;

    @NotBlank(message = "Delivery Street can't be empty")
    private String deliveryStreet;

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
    private String ccCvv;

    private List<TacoDto> tacos = new ArrayList<>();

    public void addTaco(TacoDto taco){
        int size = tacos.size();
        this.tacos.add(taco);
    }
}
