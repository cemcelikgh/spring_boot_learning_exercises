package com.cemcelik.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "ditrict")
	private String district;
	
	@Column(name = "neighborhood")
	private String neightborhood;
	
	@Column(name = "street")
	private String street;

}
