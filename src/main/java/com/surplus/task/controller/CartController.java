package com.surplus.task.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surplus.task.domain.CartItem;
import com.surplus.task.dto.CartResponse;
import com.surplus.task.dto.Response;
import com.surplus.task.service.CartService;
import com.surplus.task.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/cart")
@Api(value = "Surplus Kart", description = "Operations pertaining to cart in Application")
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

//	@Autowired
//	ProductController(ProductService cartService,ImageService imageService)
//	{
//		this.cartService = cartService;
//		this.imageService = imageService;
//	}

	@ApiOperation(value = "View a list of available carts", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@GetMapping(value = "/cartItems", produces = MediaType.APPLICATION_JSON_VALUE)
	public CartResponse getAllCartItems() {
		logger.info("Get all Cart request received");
		CartResponse response = new CartResponse();
		response.setMessage(Constants.SUCCESS);
		response.setStatus(Constants.SUCCESS);
		response.setCartItems(cartService.list());
		logger.info("getAllCartItems completed with details : " + response.getCartItems());
		return response;
	}

	@ApiOperation(value = "Get cart for seller id", response = CartItem.class)
	@GetMapping("/getCartForSeller/{sellerId}")
	public CartResponse getCartForSeller(@PathVariable int sellerId) {
		List<CartItem> lstCart = cartService.getCartBySellerId(sellerId);
		CartResponse response = new CartResponse();
		if (lstCart != null && lstCart.size() > 0) {
			response.setMessage(Constants.SUCCESS);
			response.setStatus(Constants.SUCCESS);
			response.setCartItems(lstCart);
		} else {
			response.setMessage(Constants.CART_ITEMS_NOT_FOUND);
			response.setStatus(Constants.FAILURE);
		}
		return response;
	}

	@ApiOperation(value = "Get cart for buyer id", response = CartItem.class)
	@GetMapping("/getCartForBuyer/{buyerId}")
	public CartResponse getCartForBuyer(@PathVariable int buyerId) {
		List<CartItem> lstCart = cartService.getCartByBuyerId(buyerId);
		CartResponse response = new CartResponse();
		if (lstCart != null && lstCart.size() > 0) {
			response.setMessage(Constants.SUCCESS);
			response.setStatus(Constants.SUCCESS);
			response.setCartItems(lstCart);
		} else {
			response.setMessage(Constants.CART_ITEMS_NOT_FOUND);
			response.setStatus(Constants.FAILURE);
		}
		return response;
	}

	@ApiOperation(value = "Save", response = Boolean.class)
	@CrossOrigin
	@PostMapping(path = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartResponse addToCart(@RequestBody CartItem cartItem) {
		logger.info("Add new Cart request received with Cart details : " + cartItem);
		CartResponse response = new CartResponse();
		CartItem addedCart = cartService.save(cartItem);
		response.setMessage(Constants.CARTITEM_ADDED_SUCCSESSFULLY );
		response.setStatus(Constants.SUCCESS);
		response.setCartItems(Arrays.asList(addedCart));
		logger.info("Add new Cart request completed with Cart details : " + addedCart);
		return response;
	}

	@DeleteMapping(value = "/deleteCart/{prId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Response deleteCart(@PathVariable int itemId) {
		logger.info("Delete Cart request received with id : " + itemId);
		Response response = new Response();
		boolean isDeleted = cartService.deleteCart(itemId);
		response.setMessage(Constants.CARTITEM_DELETED_SUCCSESSFULLY);
		response.setStatus(Constants.SUCCESS);
		logger.info("Delete Cart request completed with id : " + itemId);
		return response;
	}

}
