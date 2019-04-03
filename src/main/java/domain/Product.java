package domain;

public class Product {
	private Integer id;
	private String name;
	private String image;
	private String description;
	private String shortDescription;
	private double price;
	private int categoryId;

	public Product() {
		super();
	}

	public Product(Integer id, String name, String image, String shortDescription, String description, double price,
		       int categoryId) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.shortDescription = shortDescription;
		this.price = price;
		this.categoryId = categoryId;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
