package com.surplus.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.Product;



public interface ProductRepository extends JpaRepository<Product,Integer>
{
	//public Product findByPrId(int prId);
	public Iterable<Product> findProductByCategory(String category);
	public Iterable<Product> findProductByIdentity(String identity);
	public Optional<Product> findProductByPrId(int prId);
}
