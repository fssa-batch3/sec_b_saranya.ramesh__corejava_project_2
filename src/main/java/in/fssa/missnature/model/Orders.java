package in.fssa.missnature.model;

public class Orders {
	
    private int id;
    private int userId;
    private int productId;
    private String address;
    private int price;
	private int quantity;
    private String productName;
    private Status status;
 
    // Getter and setter methods for all fields
    
    public enum Status{
		DELIVERED, CANCELED, ON_THE_WAY, WAITING_LIST
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
    // Add getters and setters for any additional fields
}
