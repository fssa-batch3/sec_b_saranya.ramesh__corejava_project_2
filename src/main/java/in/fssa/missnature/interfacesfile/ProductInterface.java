package in.fssa.missnature.interfacesfile;

import java.util.Set;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.model.Product;

public interface ProductInterface extends ProductBase<Product>{

	public abstract Set<Product> listAllProducts() throws PersistanceException;
	public abstract Set<Product> listallProductsByCategoryId(int category_id)throws PersistanceException;
	public abstract Product findProductDetailsByProductId(int productId)throws PersistanceException;

}
