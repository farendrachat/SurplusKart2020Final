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
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	protected int transId;


	@Column(nullable = false)
	protected int prId;

	@Column(nullable = false)
	protected int sellerId;

	@Column(nullable = false)
	protected int buyerId;

	protected int buyPacketQty;

	protected double estimatedPrice;
	
	@Column
	protected LocalDate updatedOn;
	
	@CreatedDate
	@Column
	private LocalDate startDate;

	
	@Column(columnDefinition = "boolean default false")
	protected boolean buyerMoneyReceived;
	
	@Column
	protected LocalDate dtBuyerMoneyReceived;

	@Column(columnDefinition = "boolean default false")
	protected boolean buyerProdReceived;
	
	@Column
	protected LocalDate dtBuyerProdReceived;

	@Column(columnDefinition = "boolean default false")
	protected boolean sellerMoneyReached;
	
	@Column
	protected LocalDate dtSellerMoneyReached;

	@Column(columnDefinition = "boolean default false")
	protected boolean completeStatus;
	
	@Column
	protected LocalDate dtCompleteStatus;

	@Column
	protected int completedBy;

	@Column(columnDefinition = "varchar(255) default 'IN PROGRESS'")
	protected String milestone;	
}
