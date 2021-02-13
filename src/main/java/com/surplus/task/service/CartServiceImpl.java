package com.surplus.task.service;

import org.springframework.stereotype.Service;

import com.surplus.task.domain.CartItem;
import com.surplus.task.repository.CartRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class CartServiceImpl implements CartService {
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	private CartRepository cartRepository; 
	
	CartServiceImpl(CartRepository cartRepository){
		this.cartRepository = cartRepository;		
	}


	public List<CartItem> list() {
		return cartRepository.findAll();
	}
	
//	public Cart getCart(int prId) {
//		Optional<Cart> product = this.cartRepository.findById(prId);
//		return product.get() ;
//	}
	
	
	public CartItem save(CartItem cartItem) {
		logger.info("Executing add method with Cart details : " + cartItem);
			CartItem cart = cartRepository.save(cartItem);
			logger.info("Cart added successfully with details : "+cartItem);
			return cart; 
		
	}	
	@Override
	public boolean deleteCart(int itemId){
		Optional<CartItem> cartItem = null;
		boolean isDeleted = true;
		try{
		cartItem = this.cartRepository.findById(itemId);
		 this.cartRepository.delete(cartItem.get());
		}catch(Exception ex)
		{
			isDeleted = false;
			System.out.println("exception in CartServiceImpl is :"+ex);
		}
		return isDeleted;
	}

	@Override
	public List<CartItem> getCartBySellerId(int sellerId) {
		return cartRepository.findCartBySellerId(sellerId);
	}


	@Override
	public List<CartItem> getCartByBuyerId(int buyerId) {
		return cartRepository.findCartByBuyerId(buyerId);
	}


}
