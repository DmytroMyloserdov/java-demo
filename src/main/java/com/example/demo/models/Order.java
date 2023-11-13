package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {
    private Long id;
    private Date createDate;
    private double price;
    private String customerName;
}
