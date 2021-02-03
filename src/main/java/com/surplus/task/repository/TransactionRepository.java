package com.surplus.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.surplus.task.domain.Transaction;
import com.surplus.task.dto.TransactionsResponse;

public interface TransactionRepository extends CrudRepository<Transaction,Integer>
{
	//public Transaction findByTransId(int transId);

	public Iterable<Transaction> findByPrId(int prId);
	public List<Transaction> findByBuyerId(int buyerId);
	public List<Transaction> findBySellerId(int sellerId);

}
