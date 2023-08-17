package in.fssa.missnature.interfacesfile;

import java.util.Set;

public interface UserBase <T>{

	public abstract void create(T object);
	public abstract void updatePassword(int id, String newPassword);
	public abstract void updateName(int id, String newName);
	public abstract void delete(int userId);

}
