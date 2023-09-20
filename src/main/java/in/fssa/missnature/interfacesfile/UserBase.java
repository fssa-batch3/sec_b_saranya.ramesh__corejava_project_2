package in.fssa.missnature.interfacesfile;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.model.User;

public interface UserBase <T>{

	public abstract void create(T object) throws PersistanceException;
	public abstract void updatePassword(int id, String newPassword)throws PersistanceException;
	public abstract void updateName(int id, String newName)throws PersistanceException;
	public abstract void updateUser(T object) throws PersistanceException;
	public abstract void delete(String email)throws PersistanceException;
	public abstract User findUserByEmail(String email)throws PersistanceException;
}
