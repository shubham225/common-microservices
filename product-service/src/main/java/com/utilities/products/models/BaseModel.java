package com.utilities.products.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date createdOn;
    private Date modifiedOn;

    public BaseModel() {
        this.createdOn = new Date();
    }
}
