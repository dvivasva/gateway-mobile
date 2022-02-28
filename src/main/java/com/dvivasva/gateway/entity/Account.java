package com.dvivasva.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private String id;
	private String number;
	private double availableBalance;
	private Date dateCreation;

}
