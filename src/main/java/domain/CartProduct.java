package domain;

import java.text.DecimalFormat;

public class CartProduct {
	private Product product;
	private double price;
	private int qty;
	
	public CartProduct(Product product, double price, int qty) {
		this.product = product;
		this.price = price;
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
