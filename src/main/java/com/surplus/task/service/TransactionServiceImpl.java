package com.surplus.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.surplus.task.domain.Product;
import com.surplus.task.domain.Transaction;
import com.surplus.task.dto.TransactionsResponse;
import com.surplus.task.repository.ProductRepository;
import com.surplus.task.repository.TransactionRepository;



@Service
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionRepository transactionRepository; 
	private ProductRepository productRepository;
	
	TransactionServiceImpl(TransactionRepository transactionRepository,ProductRepository productRepository){
		this.transactionRepository = transactionRepository;		
		this.productRepository = productRepository;
	}

	@Override
	public List<Transaction> listAllTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public boolean save(Transaction transaction) {
		boolean isQuantityUpdated = false;
		try{
		if(this.transactionRepository.save(transaction)!=null);	
		{
			isQuantityUpdated = reduceQuantity(transaction);
			
		}
		}catch(Exception ex)
		{
			System.out.println("exception in TransactionServiceImpl is :"+ex.getMessage());
		}		
		return isQuantityUpdated;
	}
	
	public boolean reduceQuantity(Transaction transaction)
	{
		
		Optional<Product> product = productRepository.findProductByPrId(transaction.getPrId());
		if(product.isPresent())
		{
			if((product.get().getAvailablePackets()-transaction.getBuyPacketQty()) >= 0 ) {
			product.get().setAvailablePackets(product.get().getAvailablePackets()-transaction.getBuyPacketQty());}
			else {
				return false;
			}
		}
		
		productRepository.save(product.get());		
		return true;
	}
	public boolean deleteTransaction(int transId){
		Optional<Transaction> transaction = null;
		boolean isDelete = true;
		try{
		transaction = this.transactionRepository.findById(transId);
		if(transaction.isPresent()){
		this.transactionRepository.delete(transaction.get());}		
		}catch(Exception ex)
		{
			isDelete = false;
			System.out.println("exception in TransactionServiceImpl is :"+ex);
		}
		return isDelete;
	}

	@Override
	public Transaction getTransaction(int transId) {
		Optional<Transaction> transaction = transactionRepository.findById(transId);
		return transaction.get();
	}

	@Override
	public Iterable<Transaction> getTransactionByProductId(int productId) {
		Iterable<Transaction> transactions = transactionRepository.findByPrId(productId);
		return transactions;
	}

	@Override
	public List<Transaction> getTransactionsByBuyerId(int buyerId) {		
		return transactionRepository.findByBuyerId(buyerId);
	}

	@Override
	public List<Transaction> getTransactionsBySellerId(int sellerId) {
		return transactionRepository.findBySellerId(sellerId);
	}
}
