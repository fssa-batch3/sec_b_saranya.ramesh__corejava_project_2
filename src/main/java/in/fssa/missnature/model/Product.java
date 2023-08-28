package in.fssa.missnature.model;

public class Product {

	private int id;
	private String name;
	private String description;
	private int weight;
	private String ingredients;
	private String benefits;
	private String shelfLife;
	private String howToUse;
	private int price;
	private int categoryId;
	private String createdAt;
	private String modifiedAt;
	private QuantityUnit quantityUnit;
	private boolean isActive = true;

	
	public enum QuantityUnit{
		G, ML
	}
	
	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getHowToUse() {
		return howToUse;
	}
	public void setHowToUse(String howToUse) {
		this.howToUse = howToUse;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", weight="
				+ weight + ", ingredients=" + ingredients + ", benefits=" + benefits + ", shelfLife="
				+ shelfLife + ", howToUse=" + howToUse + ", price=" + price + ", categoryId=" + categoryId
				+ ",isActive=" + isActive +", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", quantityUnit=" + quantityUnit
				+ "]";
	}
}
