package com.xqf.myruoyi.entity;

import lombok.Data;

@Data
public class Customer {
    private String customerCode;
    private String customerName;
    private Integer appleCountSum=0;
    private Integer orangeCountSum=0;
    private Integer fruitSum=0;
}
