package com.surplus.task.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	protected int itemId;
	
	@Column(nullable = false)
	protected int buyerId;
	
	@Column(nullable = false)
	protected String name;


	@Column(nullable = false)
	protected int prId;

	@Column(nullable = false)
	protected int sellerId;	
	
	@Column(nullable = false)
	protected int buyPacketQty;

	@Column(nullable = false)
	protected double estimatedPrice;
	
	@Column
	protected LocalDate updatedOn;
	
	@CreatedDate
	@Column
	private LocalDate startDate;

	
	
}
