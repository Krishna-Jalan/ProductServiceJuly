package com.scaler.productservicejuly.inheritancetypes.singletable;

import com.scaler.productservicejuly.inheritancetypes.singletable.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private String subject;
}
