package com.scaler.productservicejuly.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass

public class BaseModel {
@Id //Primary Key
@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private Long id;
    private Date createdAt;
    private Date updatedAt;

}
