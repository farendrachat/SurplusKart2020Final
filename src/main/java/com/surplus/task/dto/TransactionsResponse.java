package com.surplus.task.dto;

import java.util.List;
import com.surplus.task.domain.Transaction;
import lombok.Data;

@Data
public class TransactionsResponse {
	
	private String status;	
	private String message;	
	List<Transaction> Transactions;
}
