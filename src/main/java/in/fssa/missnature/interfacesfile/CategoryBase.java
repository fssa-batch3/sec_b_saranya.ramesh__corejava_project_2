package in.fssa.missnature.interfacesfile;

public interface CategoryBase <T>{

	public abstract void create(T category);
	public abstract void updateName(int id, String categoryName);

}
