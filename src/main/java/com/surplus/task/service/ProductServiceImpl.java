package com.surplus.task.service;

import org.springframework.stereotype.Service;

import com.surplus.task.domain.Product;
import com.surplus.task.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private ProductRepository productRepository; 
	
	ProductServiceImpl(ProductRepository productRepository){
		this.productRepository = productRepository;		
	}


	public List<Product> list() {
		return productRepository.findAll();
	}
	
	public Product getProduct(int prId) {
		Optional<Product> product = this.productRepository.findById(prId);
		return product.get() ;
	}
	
	/*
	 * If prId is passed then its an update else its a save with new Id
	 */
	public Product save(Product product) {
		logger.info("Executing add method with Product details : " + product);
		//List<Product> products = productRepo.findByNameIgnoreCase(product.getName());
//		if (products.size() > 0) {
//			logger.warn("Product already exist with name : " + product.getName());
//			throw new ProductAlreadyExistException(Constants.PRODUCT_ALREADY_EXIST);
//
//		} else {			
			Product prSaved = productRepository.save(product);
			logger.info("Product added successfully with details : "+product);
			return prSaved; 
		
	}	
	@Override
	public boolean deleteProduct(int prId){
		Optional<Product> product = null;
		boolean isDeleted = true;
		try{
		product = this.productRepository.findById(prId);
		 this.productRepository.delete(product.get());
		}catch(Exception ex)
		{
			isDeleted = false;
			System.out.println("exception in ProductServiceImpl is :"+ex);
		}
		return isDeleted;
	}

	@Override
	public Iterable<Product> getProductByIdentity(String prIdentity) {
		Iterable<Product> listProd = productRepository.findProductByIdentity(prIdentity);
		return listProd;
	}

	@Override
	public Iterable<Product> getProductByCategory(String prCategory) {
		Iterable<Product> listProd = productRepository.findProductByCategory(prCategory);
		return listProd;
	}


	@Override
	public List<Product> getProductBySellerId(int sellerId) {
		return productRepository.findProductBySellerId(sellerId);
	}


	@Override
	public List<Product> getProductByBuyerId(int buyerId) {
		return productRepository.findProductByBuyerId(buyerId);
	}


}
