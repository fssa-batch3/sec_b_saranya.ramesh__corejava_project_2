package in.fssa.missnature.interfacesfile;

import in.fssa.missnature.exception.PersistanceException;

public interface CategoryBase <T>{

	public abstract void create(T category)throws PersistanceException;
	public abstract void updateName(int id, String categoryName)throws PersistanceException;

}
