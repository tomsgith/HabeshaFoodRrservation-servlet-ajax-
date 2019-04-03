package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import domain.Product;


public class ProductDao {

	private Map<Integer, Product> productsDb = new HashMap<>();
	{
		//cat 1
		productsDb.put(1, new Product(1, "House Special", "bebAynetu.jpg","The best of the House!!","  Engera,Lentils,carrots ,potatoes,onions,kale,shiro,beats,broccoli,", 15.99, 1));
		productsDb.put(2, new Product(2, "Kintibtab", "kintibtab.jpg","Best combination of veggies and meat","meat,lentils, salad,cabbage, chicken, kale, enjera ", 17.99, 1));
		productsDb.put(3, new Product(3, "Alicha Special", "specialAlicha.jpg","Best of the Veggies","silsi, enjera, potatoes alicha, meat, carrot, cabbage, lentils made in three different ways, meat, tbsi, pepper ", 15.99, 1));
		productsDb.put(4, new Product(4, "Derho ", "derho.jpg","Lover's recipe for chicken"," chicken made in a hot souse, tibsi(meat), spinach, salad and lentils", 17.99, 1));
		productsDb.put(5, new Product(5, "Ades and Tibsi ", "adesTibs.jpg","House made Tibse, with Enjera."," enjera, lentils, meat, tomatoes, pepper, onion, rosemarry, .", 13.99, 1));
		productsDb.put(6, new Product(6, "Kitfo", "kitfo.jpg","Traditional Kitfo with Mushroom!","The BEST combination of meat fried lightly on butter, tibsi, mushroom tibsi, kale, cheese served on enjera.", 17.99, 1));

		//cat 2
		productsDb.put(7, new Product(7, "House Special", "bebAynetu.jpg","The best of the House!!","  Engera,Lentils,carrots ,potatoes,onions,kale,shiro,beats,broccoli,", 10.99, 2));
		productsDb.put(8, new Product(8, "Kintibtab", "kintibtab.jpg","Best combination of veggies and meat","meat,lentils, salad,cabbage, chicken, kale, enjera ", 11.99, 2));
		productsDb.put(9, new Product(9, "Alicha Special", "specialAlicha.jpg","Best of the Veggies","silsi, enjera, potatoes alicha, meat, carrot, cabbage, lentils made in three different ways, meat, tbsi, pepper ", 11.99, 2));
		productsDb.put(10, new Product(10, "Derho ", "derho.jpg","Lover's recipe for chicken"," chicken made in a hot souse, tibsi(meat), spinach, salad and lentils", 12.99, 2));
		productsDb.put(11, new Product(11, "Ades and Tibsi ", "adesTibs.jpg","House made Tibse, with Enjera."," enjera, lentils, meat, tomatoes, pepper, onion, rosemarry, .", 9.99, 2));
		productsDb.put(12, new Product(12, "Kitfo", "kitfo.jpg","Traditional Kitfo with Mushroom!","The BEST combination of meat fried lightly on butter, tibsi, mushroom tibsi, kale, cheese served on enjera.", 12.99, 2));

	}
	
	public List<Product> getProductByCategoryId(int categoryId) {
		return productsDb.entrySet().stream()
				.filter(p -> p.getValue().getCategoryId() == categoryId)
				.map(p -> p.getValue()).collect(Collectors.toList());
	}

	public Product getProductById(int id) {
		return productsDb.get(id);
	}
}
