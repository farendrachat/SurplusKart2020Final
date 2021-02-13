package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.CartItem;

import lombok.Data;

@Data
public class CartResponse {
	
	private String status;	
	private String message;	
	List<CartItem> cartItems;
}
