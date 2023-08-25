package in.fssa.missnature.interfacesfile;

import java.util.Set;

import in.fssa.missnature.exception.PersistanceException;

public interface UserBase <T>{

	public abstract void create(T object) throws PersistanceException;
	public abstract void updatePassword(int id, String newPassword)throws PersistanceException;
	public abstract void updateName(int id, String newName)throws PersistanceException;
	public abstract void delete(int userId)throws PersistanceException;

}
