package com.surplus.task.dto;

import com.surplus.task.utils.EnumTransactionStatus;

import lombok.Data;

@Data
public class TransactionChangeRequest {
	protected int transId;
	protected EnumTransactionStatus transStatus;
	protected String userName;
	protected boolean isProductApprovedByBuyer;
	
}
