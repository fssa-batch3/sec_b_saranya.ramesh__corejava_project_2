package in.fssa.missnature.interfacesfile;

import java.util.Set;

import in.fssa.missnature.model.Product;

public interface ProductInterface extends ProductBase<Product>{

	public abstract Set<Product> listAllProducts();
	public abstract Set<Product> listallProductsByCategoryId(int category_id);
	public abstract Product findProductDetailsByProductId(int productId);
	
	
}
