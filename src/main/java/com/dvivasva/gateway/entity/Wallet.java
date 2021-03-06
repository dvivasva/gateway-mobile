package com.dvivasva.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    private String id;
    private String numberCard;
    private String numberPhone;
    private String imei;
    private String document;
    private String email;
    private int status; // used for blocking

}
