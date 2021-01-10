package com.surplus.task.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surplus.task.domain.Product;
import com.surplus.task.domain.Transaction;
import com.surplus.task.dto.ProductResponse;
import com.surplus.task.service.TransactionService;
import com.surplus.task.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:9000/")
@RequestMapping("/api/transaction")
@Api(value="Surplus Kart", description="Operations pertaining to transactions for various deals in the Application") 
public class TransactionController {
	
	private TransactionService transactionService;
	
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
	@GetMapping(value={"","/"})
	public Iterable<Transaction> listTransaction()
	{
		Iterable<Transaction> listTransaction = transactionService.list();
		return listTransaction;
	}
	
	@ApiOperation(value = "Buy transaction.Transaction initiated with the Buy process.", response = Boolean.class)
	@CrossOrigin
	@PostMapping("/buy")
	public ProductResponse buyTransaction(@RequestBody Product product)
	{	
		//logger.info("Buy transaction request received with Product details : "+product);
		ProductResponse response=new ProductResponse();
		Transaction transaction = new Transaction();
		transaction.setBuyerId(product.getBuyerId());
		transaction.setSellerId(product.getSellerId());
		//transaction.setQuantity(product.getb );
		
		//Product buyProduct=transactionService.save(product);
		response.setMessage(Constants.PRODUCT_ADDED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		//response.setProduct(addedProduct);
		//logger.info("Add new Product request completed with Product details : "+addedProduct);
		return response;
		
	}
	
	@ApiOperation(value = "Save", response = Boolean.class)
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
	}
	
	@ApiOperation(value = "Delete Transaction by transaction id", response = Boolean.class)
	@CrossOrigin
	@DeleteMapping("/delete")
	public boolean deleteTransaction(@RequestParam(value="transactionId",required=true) int transactionId)
	{		
		return transactionService.deleteTransaction(transactionId);
	}

}
