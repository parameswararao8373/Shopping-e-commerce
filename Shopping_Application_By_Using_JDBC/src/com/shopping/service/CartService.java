package com.shopping.service;

import com.shopping.dao.CartDAO;
import com.shopping.dto.CartDetails;

public class CartService {

	CartDAO cartDAO=new CartDAO();
	
	public void addCartDetails(CartDetails cartDetails) {
		if (cartDAO.insertCartDetails(cartDetails)) {
			System.out.println("Product Added To The Cart Successfully....");
		}
		else {
			System.out.println("Server error 500");
		}
	}
	public CartDetails showCartDetails(int id)
	{
		return cartDAO.selectCartDetails(id);
	}
}
