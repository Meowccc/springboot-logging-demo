package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author meow
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestReq {

    @NotEmpty(message = "name can not be empty")
    private String name;

    @Max(value = 100, message = "age can not be greater than 100")
    @Min(value = 0, message = "age can not be less than 0")
    private int age;
}
