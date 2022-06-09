package com.ironhack.gardening.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityDTO {

    @Digits(integer = 4, fraction = 0)
    @Min(0)
    private int quantity;
}
