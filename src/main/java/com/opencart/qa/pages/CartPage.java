package com.opencart.qa.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	
	By qty = By.id("cart");
	
	public void addToCart() {
		System.out.println(qty);
		System.out.println("cart is updated....");
	}
	
	

}
