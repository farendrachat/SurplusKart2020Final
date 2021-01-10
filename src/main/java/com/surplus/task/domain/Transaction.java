package com.surplus.task.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Transaction {

	@Id
	@Column(nullable = false)
	protected int transId;


	@Column(nullable = false)
	protected int productId;

	@Column(nullable = false)
	protected int sellerId;

	@Column(nullable = false)
	protected int buyerId;

	protected double quantity;

	protected double totalPrice;
	
	@Temporal(TemporalType.DATE)
	protected Date updatedOn;

	@Column(nullable = false)
	protected boolean buyerMoneyReceived;
	
	//@Temporal(TemporalType.DATE)
	protected String dtBuyerMoneyReceived;

	@Column(nullable = false)
	protected boolean buyerProdReceived;
	
	//@Temporal(TemporalType.DATE)
	protected String dtBuyerProdReceived;

	@Column(nullable = false)
	protected boolean sellerMoneyReached;
	
	//@Temporal(TemporalType.DATE)
	protected String dtSellerMoneyReached;

	@Column(nullable = false)
	protected boolean completeStatus;
	
	//@Temporal(TemporalType.DATE)
	protected String dtCompleteStatus;

	@Column(nullable = false)
	protected boolean completedBy;

	@Column(nullable = false)
	protected String milestone;	
}
