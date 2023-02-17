package com.shopeasy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopeasy.dto.OrderDTO;
import com.shopeasy.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Double totalPrice;
	private Integer numberOfProduct;
	
//  Bidirectional mapping with customer class which will have customerId foreign key 
	 @JsonIgnore
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="customerId")
	 private Customer customer;
	
	 @Embedded
	 @ElementCollection
	 private List<ProductDTO> products = new ArrayList<>();
}
