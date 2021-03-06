package com.surplus.task.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.surplus.task.domain.Product;
import com.surplus.task.domain.Transaction;
import com.surplus.task.domain.User;
import com.surplus.task.dto.ProductResponse;
import com.surplus.task.dto.TransactionChangeRequest;
import com.surplus.task.dto.TransactionRequest;
import com.surplus.task.dto.TransactionResponse;
import com.surplus.task.dto.TransactionsResponse;
import com.surplus.task.service.TransactionService;
import com.surplus.task.utils.Constants;
import com.surplus.task.utils.EnumTransactionStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/transaction")
@Api(value="Surplus Kart", description="Operations pertaining to transactions for various deals in the Application") 
public class TransactionController {
	
	private TransactionService transactionService;
	ModelMapper modelMapper = new ModelMapper();
	
	TransactionController(TransactionService transactionService)
	{
		this.transactionService = transactionService;
	}
	
	@ApiOperation(value = "Get transaction from transId", response = Transaction.class)
	@GetMapping("/getTransaction/{transId}")
	public Transaction getTransaction(@PathVariable int transId)
	{
		Transaction transaction = transactionService.getTransaction(transId) ;
		return transaction;
	}
	
	@ApiOperation(value = "Get list of transaction by product id listed datewise asc", response = Transaction.class)
	@GetMapping("/getTransaction/{productId}")
	public Iterable<Transaction> getTransactionByProductId(@PathVariable int productId)
	{
		Iterable<Transaction> listTransaction = transactionService.getTransactionByProductId(productId);
		return listTransaction;
	}
	
	@ApiOperation(value = "View a list of all available Transaction", response = Iterable.class)
	@GetMapping(value={"/getAllTransactions"})
	public TransactionsResponse getAllTransaction()
	{
		TransactionsResponse transactionsResponse = new TransactionsResponse();
		List<Transaction> lstTransactions = null;
		lstTransactions = transactionService.listAllTransactions();
		if(lstTransactions != null && lstTransactions.size()>0)
		{
		transactionsResponse.setMessage(Constants.SUCCESS);
		transactionsResponse.setStatus(Constants.SUCCESS);
		transactionsResponse.setTransactions(lstTransactions);
		}
		else
		{
			transactionsResponse.setMessage(Constants.TRANSACTION_NOT_FOUND);
			transactionsResponse.setStatus(Constants.FAILURE);			
		}
		return transactionsResponse;
	}
	
	@ApiOperation(value = "Buy transaction.Transaction initiated with the Buy process.", response = Boolean.class)
	@CrossOrigin
	@PostMapping("/buy")
	public TransactionResponse buyTransaction(@RequestBody TransactionRequest transactionRequest)
	{
		boolean isTransSuccessful;
		Transaction transaction = modelMapper.map(transactionRequest, Transaction.class);
		transaction.setTransactionStatus(EnumTransactionStatus.PAYMENT_DONE_BY_BUYER);
		transaction.setDtPaymentDoneByBuyer(LocalDate.now());
		TransactionResponse response=new TransactionResponse();		
		isTransSuccessful=transactionService.save(transaction);
		if(isTransSuccessful)
		{
		response.setMessage(Constants.TRANSACTION_ADDED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		}
		else {
			response.setMessage(Constants.TRANSACTION_ADD_FAILED  );
			response.setStatus(Constants.FAILURE);			
		}
		return response;
		
	}
	
/*	@ApiOperation(value = "Save", response = Boolean.class)
	@CrossOrigin
	@PostMapping(path="/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse saveProduct(@RequestBody Product product)
	{		
		//logger.info("Add new Product request received with Product details : "+product);
		ProductResponse response=new ProductResponse();
		//Product addedProduct=productService.save(product);
		response.setMessage(Constants.PRODUCT_ADDED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		//response.setProduct(addedProduct);
		//logger.info("Add new Product request completed with Product details : "+addedProduct);
		return response;
	}*/
	
	@ApiOperation(value = "Delete Transaction by transaction id", response = Boolean.class)
	@CrossOrigin
	@DeleteMapping("/delete")
	public boolean deleteTransaction(@RequestParam(value="transactionId",required=true) int transactionId)
	{		
		return transactionService.deleteTransaction(transactionId);
	}
	
	@ApiOperation(value = "Get list of transaction for user id listed datewise asc", response = Transaction.class)
	@GetMapping("/getBuyerTransactions/{buyerId}")
	public TransactionsResponse getTransactionByBuyerId(@PathVariable int buyerId)
	{
		TransactionsResponse transactionsResponse = new TransactionsResponse();
		List<Transaction> lstTransactions = null;
		lstTransactions = transactionService.getTransactionsByBuyerId(buyerId);
		if(lstTransactions != null && lstTransactions.size()>0)
		{
		transactionsResponse.setMessage(Constants.SUCCESS);
		transactionsResponse.setStatus(Constants.SUCCESS);
		transactionsResponse.setTransactions(lstTransactions);
		}
		else
		{
			transactionsResponse.setMessage(Constants.TRANSACTION_NOT_FOUND);
			transactionsResponse.setStatus(Constants.FAILURE);			
		}
		return transactionsResponse;
	}
	
	@ApiOperation(value = "Get list of transaction for user id listed datewise asc", response = Transaction.class)
	@GetMapping("/getSellerTransactions/{sellerId}")
	public TransactionsResponse getTransactionBySellerId(@PathVariable int sellerId)
	{
		TransactionsResponse transactionsResponse = new TransactionsResponse();
		List<Transaction> lstTransactions = null;
		lstTransactions = transactionService.getTransactionsBySellerId(sellerId);
		if(lstTransactions != null && lstTransactions.size()>0)
		{
		transactionsResponse.setMessage(Constants.SUCCESS);
		transactionsResponse.setStatus(Constants.SUCCESS);
		transactionsResponse.setTransactions(lstTransactions);
		}
		else
		{
			transactionsResponse.setMessage(Constants.TRANSACTION_NOT_FOUND);
			transactionsResponse.setStatus(Constants.FAILURE);			
		}
		return transactionsResponse;
	}
	
	
	
	@ApiOperation(value = "The transaction status is updated to the next status and update date will be current date", response = Boolean.class)
	@CrossOrigin
	@PostMapping("/changeTransactionStatus")
	public TransactionResponse changeTransactionStatus(@RequestBody TransactionChangeRequest transactionChangeRequest)
	{
		boolean isStatusChanged;
		Transaction transaction = transactionService.getTransaction(transactionChangeRequest.getTransId());
		//transaction.setTransactionStatus(transactionChangeRequest.getTransStatus());
		transaction.setUpdatedOn(LocalDate.now());
		transaction.setUpdatedBy(transactionChangeRequest.getUserName());
		//transaction.setProductApprovedByBuyer(transactionChangeRequest.isProductApprovedByBuyer());
		switch(transactionChangeRequest.getTransStatus())
		{
		case PAYMENT_DONE_BY_BUYER : 
			transaction.setTransactionStatus(EnumTransactionStatus.MONEY_RESERVED_BY_ADMIN);
			transaction.setDtBuyerMoneyReceivedByAdmin(LocalDate.now());
			break;
		case MONEY_RESERVED_BY_ADMIN :
			transaction.setTransactionStatus(EnumTransactionStatus.MATERIAL_DISPATCHED_BY_SELLER);
			transaction.setDtProductDispatchedBySeller(LocalDate.now());
		    break;
		case MATERIAL_DISPATCHED_BY_SELLER :
			transaction.setTransactionStatus(EnumTransactionStatus.MATERIAL_REACHED_BUYER);
			transaction.setDtProductReceivedByBuyer(LocalDate.now());
			break;
		case MATERIAL_REACHED_BUYER :
			transaction.setTransactionStatus(EnumTransactionStatus.MATERIAL_APPROVED_BY_BUYER);
			transaction.setDtProductApprovedByBuyer(LocalDate.now());
			break;
		case MATERIAL_APPROVED_BY_BUYER :
			transaction.setTransactionStatus(EnumTransactionStatus.MONEY_TRANSFERRED_TO_SELLER);
			transaction.setProductApprovedByBuyer(transactionChangeRequest.isProductApprovedByBuyer());
			transaction.setDtMoneySentToSellerByAdmin(LocalDate.now());
			break;
		case MONEY_TRANSFERRED_TO_SELLER :
			transaction.setTransactionStatus(EnumTransactionStatus.MONEY_REACHED_TO_SELLER);
			transaction.setDtMoneyReachedToSeller(LocalDate.now());
			break;
		case MONEY_REACHED_TO_SELLER :
			transaction.setTransactionStatus(EnumTransactionStatus.TRANSACTION_COMPLETED);
			transaction.setDtTransactionCompleted(LocalDate.now());
			break;
		default:
			break;		
		}
		
		TransactionResponse response=new TransactionResponse();		
		isStatusChanged=transactionService.save(transaction);
		if(isStatusChanged)
		{
		response.setMessage(Constants.TRANSACTION_UPDATED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		}
		else {
			response.setMessage(Constants.TRANSACTION_UPDATE_FAILED);
			response.setStatus(Constants.FAILURE);			
		}
		return response;
		
	}

}
