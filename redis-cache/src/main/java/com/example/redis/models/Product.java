package com.example.redis.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private String description;
    private double price;
}
