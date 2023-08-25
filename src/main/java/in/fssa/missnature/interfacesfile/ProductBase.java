package in.fssa.missnature.interfacesfile;

import in.fssa.missnature.exception.PersistanceException;

public interface ProductBase <T> {

	public abstract void create(T product)throws PersistanceException;
	public abstract void updatePrice(int id, int price)throws PersistanceException;
	public abstract void deleteProduct(int id)throws PersistanceException;
	public abstract void updateProduct(T product)throws PersistanceException;
	
}
