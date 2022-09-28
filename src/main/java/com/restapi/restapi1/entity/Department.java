package com.restapi.restapi1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    @NotBlank(message = "Please add Department Name")
//    @Length(max = 12, min=3)
//    @Email
//    @Positive
//    @PositiveOrZero
//    @Future
//    @Past
//    @FutureOrPresent
//    @Size(max = 12 , min=3)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
