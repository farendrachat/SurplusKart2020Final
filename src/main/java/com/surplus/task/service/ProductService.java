package com.surplus.task.service;

import java.util.List;

import com.surplus.task.domain.Product;

public interface ProductService {
	
	public List<Product> list();
	public Product getProduct(int prId);
	public Iterable<Product> getProductByIdentity(String prIdentity);
	public Iterable<Product> getProductByCategory(String prCategory);
	public List<Product> getProductBySellerId(int sellerId);
	public List<Product> getProductByBuyerId(int buyerId);
	public Product save (Product product);
	public boolean deleteProduct(int prId);

}
