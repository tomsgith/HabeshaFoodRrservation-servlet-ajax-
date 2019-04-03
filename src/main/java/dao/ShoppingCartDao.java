package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import domain.CartProduct;
import domain.Product;



public class ShoppingCartDao {
	private ProductDao productDao = new ProductDao();
	private List<CartProduct> myCart = new ArrayList<>();

	public void addProduct(int productId) {
		// Check whether the product is existing in the current cart
		Optional<CartProduct> existProduct = myCart.stream().filter(p -> p.getProduct().getId() == productId).findFirst();
		if (!existProduct.isPresent()) {
			Product p = productDao.getProductById(productId);
			myCart.add(new CartProduct(p, p.getPrice(), 1));
		} else {
			myCart = myCart.stream().map(p -> {
				if (p.getProduct().getId() == productId) {
					p.setQty(p.getQty() + 1);
				}
				return p;
			}).collect(Collectors.toList());
		}

	}

	public void removeProduct(int productId) {
		myCart = myCart.stream().filter(p -> p.getProduct().getId() != productId).collect(Collectors.toList());
	}

	public void updateQty(int productId, int qty) {
		myCart = myCart.stream().map(p -> {
			if (p.getProduct().getId() == productId) {
				p.setQty(qty);
			}
			return p;
		}).collect(Collectors.toList());
	}

	public List<CartProduct> getMyCart() {
		return myCart;
	}
	public int getNumberOfProducts(){
		return myCart.stream().mapToInt(q->q.getQty()).sum();
	}

}
