package com.dvivasva.gateway.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String id;
    private double amount;
    private String numberPhoneOrigin;
    private String numberPhoneDestination;
    private Date date;

}
