package in.fssa.missnature.interfacesfile;

import in.fssa.missnature.exception.PersistanceException;
//import java.util.Set;
import in.fssa.missnature.interfacesfile.*;
import in.fssa.missnature.model.User;

public interface UserInterface extends UserBase<User>{
	public abstract int findUserIdByEmail(String email)throws PersistanceException;
}
