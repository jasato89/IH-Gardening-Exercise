package com.ironhack.gardening.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotEmpty(message = "Name must be not empty")
    @NotNull
    private String name;
    @Digits(integer = 4, fraction = 0)
    @NotNull
    private int quantity;
    @NotNull
    @Digits(integer = 10, fraction = 0)
    private int departmentId;
}
