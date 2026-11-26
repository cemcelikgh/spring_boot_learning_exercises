package com.cemcelik.dto;

import java.math.BigDecimal;

import com.cemcelik.enums.CurrencyType;
import com.cemcelik.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccount extends BaseEntity {

	private String accountNo;

	private String iban;

	private BigDecimal amount;

	private CurrencyType currencyType;

}
