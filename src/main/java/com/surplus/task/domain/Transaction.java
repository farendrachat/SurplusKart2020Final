package com.surplus.task.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import com.surplus.task.utils.EnumNextMilestone;
import com.surplus.task.utils.EnumTransactionStatus;

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
	
	protected String updatedBy;
	
	@CreatedDate
	@Column
	private LocalDate startDate;
	
//	@Column(columnDefinition = "boolean default false")
//	protected boolean paymentDoneByBuyer;
	
	@Column
	protected LocalDate dtPaymentDoneByBuyer;

	
//	@Column(columnDefinition = "boolean default false")
//	protected boolean buyerMoneyReceivedByAdmin;
	
	@Column
	protected LocalDate dtBuyerMoneyReceivedByAdmin;
	
//	@Column(columnDefinition = "boolean default false")
//	protected boolean productDispatchedBySeller;
	
	@Column
	protected LocalDate dtProductDispatchedBySeller;

//	@Column(columnDefinition = "boolean default false")
//	protected boolean productReceivedByBuyer;
	
	@Column
	protected LocalDate dtProductReceivedByBuyer;
	
	@Column(columnDefinition = "boolean default false")
	protected boolean productApprovedByBuyer;
	
	@Column
	protected LocalDate dtProductApprovedByBuyer;
	
//	@Column(columnDefinition = "boolean default false")
//	protected boolean moneySentToSellerByAdmin;
	
	@Column
	protected LocalDate dtMoneySentToSellerByAdmin;	

//	@Column(columnDefinition = "boolean default false")
//	protected boolean moneyReachedToSeller;
	
	@Column
	protected LocalDate dtMoneyReachedToSeller;	
	
	@Column
	protected LocalDate dtTransactionCompleted;	

	@Enumerated(EnumType.STRING)
	protected EnumTransactionStatus transactionStatus  ;
	
	@Enumerated(EnumType.STRING)
	protected EnumNextMilestone nextMilestone  ;	
}
