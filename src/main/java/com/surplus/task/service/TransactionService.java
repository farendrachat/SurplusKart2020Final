package com.surplus.task.service;

import java.util.List;

import com.surplus.task.domain.Transaction;
import com.surplus.task.dto.TransactionsResponse;

public interface TransactionService {
	
	public Iterable<Transaction> list();
	public Transaction getTransaction(int trId);
	public boolean save (Transaction transaction);
	public boolean deleteTransaction(int transId);
	public Iterable<Transaction> getTransactionByProductId(int productId);
	public List<Transaction> getTransactionsByBuyerId(int buyerId);
	public List<Transaction> getTransactionsBySellerId(int sellerId);

}
