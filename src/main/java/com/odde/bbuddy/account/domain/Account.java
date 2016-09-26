package com.odde.bbuddy.account.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    private String name;
    private int balance;

}
