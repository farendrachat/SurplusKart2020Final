package com.surplus.task.dto;

import com.surplus.task.utils.EnumNextMilestone;

import lombok.Data;

@Data
public class TransactionChangeRequest {
	protected int transId;
	protected EnumNextMilestone nextMilestone;
	protected String userName;
	protected boolean isProductApprovedByBuyer;
	
}
