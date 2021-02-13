package com.surplus.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.CartItem;



public interface CartRepository extends JpaRepository<CartItem,Integer>
{	
	public Optional<CartItem> findCartByItemId(int identity);
	public Optional<CartItem> findCartByPrId(int prId);
	public List<CartItem> findCartBySellerId(int sellerId);
	public List<CartItem> findCartByBuyerId(int buyerId);
}
