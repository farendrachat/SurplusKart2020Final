package com.surplus.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.Product;



public interface ProductRepository extends JpaRepository<Product,Long>
{
	public Product findByPrId(int prId);
	public Iterable<Product> findProductByCategory(String category);
	public Iterable<Product> findProductByIdentity(String identity);
}
