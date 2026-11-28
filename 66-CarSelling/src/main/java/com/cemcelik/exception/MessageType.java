package com.cemcelik.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1004", "Kayıt bulunamadı."),
	TOKEN_IS_EXPIRED("1005", "Token'ın süresi bitmiştir."),
	USERNAME_NOT_FOUND("1006", "Username bulunamadı."),
	USERNAME_OR_PASSWORD_INVALID("1007", "Kullanıcı adı veya şifre hatalı."),
	REFRESH_TOKEN_NOT_FOUND("1008", "Refresh Token bulunamadı."),
	REFRESH_TOKEN_IS_EXPIRED("1009", "Refresh Token'ın süresi bitmiştir."),
	CURRENSY_RATES_IS_OCCURED("1010", "Döviz kuru alınamadı."),
	CUSTOMER_AMOUNT_IS_NOT_ENOUGHT("1011", "Müşterinin parası yeterli değildir."),
	CAR_STATUS_IS_ALREADY_SOLD("1012", "Araba daha önce satılmıştır."),
	GENERAL_EXCEPTION("9999", "Umumî bir hata oluştu.");

	private String code;

	private String message;

	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
