package com.surplus.task.dto;

import lombok.Data;

@Data
public class TransactionRequest {
	protected int prId;
	protected int sellerId;
	protected int buyerId;
	protected int buyPacketQty;
	protected double estimatedPrice;
	
}
