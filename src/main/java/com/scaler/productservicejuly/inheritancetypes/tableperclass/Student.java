package com.scaler.productservicejuly.inheritancetypes.tableperclass;

import com.scaler.productservicejuly.inheritancetypes.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_students")
public class Student extends User {
private String batch;
}
