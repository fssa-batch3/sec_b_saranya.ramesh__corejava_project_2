package in.fssa.missnature.model;

public class Product {

	private int id;
	private String name;
	private String description;
	private String product_weight;
	private String ingredients;
	private String benefits;
	private String shelf_life;
	private String how_to_use;
	private int price;
	private int category_id;
	private String created_at;
	private String modified_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(String product_weight) {
		this.product_weight = product_weight;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public String getShelf_life() {
		return shelf_life;
	}
	public void setShelf_life(String shelf_life) {
		this.shelf_life = shelf_life;
	}
	public String getHow_to_use() {
		return how_to_use;
	}
	public void setHow_to_use(String how_to_use) {
		this.how_to_use = how_to_use;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getModified_at() {
		return modified_at;
	}
	public void setModified_at(String modified_at) {
		this.modified_at = modified_at;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", product_weight="
				+ product_weight + ", ingredients=" + ingredients + ", benefits=" + benefits + ", shelf_life="
				+ shelf_life + ", price=" + price + ", category_id=" + category_id + ", created_at=" + created_at
				+ ", modified_at=" + modified_at + "]";
	}
}
