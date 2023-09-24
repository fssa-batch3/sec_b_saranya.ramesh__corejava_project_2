package in.fssa.missnature.model;

import java.time.LocalDateTime;

public class Orders {
	
    private int id;
    private int userId;
    private int productId;
    private String address;
    private int price;
	private int quantity;
    private String productName;
    private Status status;
    private String userName;
    private int productWeight;
    private QuantityUnit quantityUnit;
	private String productImage;
	private String date;
	private boolean isActive;
        
    // Getter and setter methods for all fields
    
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String formattedTime) {
		this.date = formattedTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}

	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
    
    public enum Status{
		DELIVERED, CANCELED, ON_THE_WAY, WAITING_LIST
	}
    public enum QuantityUnit{
		G, ML
	}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getPrice() {
 		return price;
 	}

 	public void setPrice(int price) {
 		this.price = price;
 	}

 	public int getQuantity() {
 		return quantity;
 	}

 	public void setQuantity(int quantity) {
 		this.quantity = quantity;
 	}

 	public String getProductName() {
 		return productName;
 	}

 	public void setProductName(String productName) {
 		this.productName = productName;
 	}
 	
 	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
    // Add getters and setters for any additional fields
}
