package com.scaler.productservicejuly.inheritancetypes.tableperclass;

import com.scaler.productservicejuly.inheritancetypes.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentors")
public class Mentor extends User {
    private String company;
}
