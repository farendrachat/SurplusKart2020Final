package com.surplus.task.service;

import java.util.List;

import com.surplus.task.domain.CartItem;

public interface CartService {
	
	public List<CartItem> list();
	public List<CartItem> getCartBySellerId(int sellerId);
	public List<CartItem> getCartByBuyerId(int buyerId);
	public CartItem save (CartItem cart);
	public boolean deleteCart(int itemId);

}
