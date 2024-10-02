package com.example.redis.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@RedisHash("Product")
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private String description;
    private double price;
}
