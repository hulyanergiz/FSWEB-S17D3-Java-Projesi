package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Kangaroo {
    private Integer id;
    private String name;
    private Double height;
    private Double weight;
    private String gender;
    private Boolean isAgressive;
}
