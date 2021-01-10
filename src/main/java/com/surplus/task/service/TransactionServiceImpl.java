package com.surplus.task.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.surplus.task.domain.Product;
import com.surplus.task.domain.Transaction;
import com.surplus.task.repository.ProductRepository;
import com.surplus.task.repository.TransactionRepository;



@Service
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionRepository transactionRepository; 
	private ProductRepository productRepository;
	
	TransactionServiceImpl(TransactionRepository transactionRepository){
		this.transactionRepository = transactionRepository;		
	}

	@Override
	public Iterable<Transaction> list() {
		return transactionRepository.findAll();
	}

	@Override
	public boolean save(Transaction transaction) {
		boolean isSaved = false;
		boolean isQuantityUpdated = false;
		try{
		this.transactionRepository.save(transaction);		
		}catch(Exception ex)
		{
			isSaved = false;
			System.out.println("exception in TransactionServiceImpl is :"+ex.getMessage());
		}
		
		if(isSaved)
		{
			isQuantityUpdated = reduceQuantity(transaction);
		}
		
		
		return isQuantityUpdated;
	}
	
	public boolean reduceQuantity(Transaction transaction)
	{
		
		Optional<Product> product = productRepository.findById(transaction.getProductId());
		if(product.isPresent())
		{
			product.get().setAvailableQty(product.get().getAvailableQty()-transaction.getQuantity());
		}
		
		productRepository.save(product.get());		
		return true;
	}
	public boolean deleteTransaction(int transId){
		Transaction transaction = null;
		boolean isDelete = true;
		try{
		transaction = this.transactionRepository.findByTransId(transId);
		 this.transactionRepository.delete(transaction);
		}catch(Exception ex)
		{
			isDelete = false;
			System.out.println("exception in TransactionServiceImpl is :"+ex);
		}
		return isDelete;
	}

	@Override
	public Transaction getTransaction(int transId) {
		Transaction transaction = transactionRepository.findByTransId(transId);
		return transaction;
	}

	@Override
	public Iterable<Transaction> getTransactionByProductId(int productId) {
		Iterable<Transaction> transactions = transactionRepository.findByProductId(productId);
		return transactions;
	}
}
