package com.surplus.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.Product;



public interface ProductRepository extends JpaRepository<Product,Integer>
{
	public Iterable<Product> findProductByCategory(String category);
	public Iterable<Product> findProductByIdentity(String identity);
	public Optional<Product> findProductByPrId(int prId);
	public List<Product> findProductBySellerId(int sellerId);
	public List<Product> findProductByBuyerId(int buyerId);
}
