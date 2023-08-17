package in.fssa.missnature.interfacesfile;

import java.util.Set;

import in.fssa.missnature.model.Category;
import in.fssa.missnature.model.User;

public interface CategoryInterface extends CategoryBase <Category>{

	public abstract Set<Category> listAllCategroyByCategoryId(int categoryId);
	
}
