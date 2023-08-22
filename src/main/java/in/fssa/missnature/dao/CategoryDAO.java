package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import in.fssa.missnature.interfacesfile.CategoryInterface;
import in.fssa.missnature.model.Category;
import in.fssa.missnature.util.ConnectionUtil;

public class CategoryDAO implements CategoryInterface{

	/**
	 * Creates a new category in the database.
	 *
	 * @param category The Category object containing the information for the new category.
	 * @throws RuntimeException if there's an issue with database connectivity or SQL execution.
	 */
	@Override
	public void create(Category category) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "INSERT INTO category (name) values(?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getName());
			
			ps.executeUpdate();
			
			System.out.println("Category created Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	/**
	 * Updates the name of a category in the database based on its ID.
	 *
	 * @param id The ID of the category to be updated.
	 * @param categoryName The new name to be assigned to the category.
	 * @throws RuntimeException if there's an issue with database connectivity, SQL execution, or if no rows were affected.
	 */
	@Override
	public void updateName(int id, String categoryName) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE category set name = ? WHERE id = ? AND is_active = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, categoryName);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("category name updated successfully");
			}
		} catch (SQLException e) {
			throw new RuntimeException();	
		}
	}



}
