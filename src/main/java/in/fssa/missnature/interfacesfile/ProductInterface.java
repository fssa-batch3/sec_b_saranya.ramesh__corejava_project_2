package in.fssa.missnature.interfacesfile;

import java.util.Set;

import in.fssa.missnature.model.Product;

public interface ProductInterface extends ProductBase<Product>{

	public abstract Set<Product> listAllProducts();
	public abstract Set<Product> listallProductsByCategoryId(int category_id);
	public abstract Product findProductDetailsByProductId(int productId);
	public abstract void updateProduct(int productId, String name, int categoryId, String description, String productWeight,
			int price, String ingredients, String benefits, String howToUse, String shelfLife);
	
}
