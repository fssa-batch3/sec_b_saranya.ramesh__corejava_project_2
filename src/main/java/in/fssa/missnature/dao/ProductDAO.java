package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import in.fssa.missnature.exception.PersistanceException;
import in.fssa.missnature.interfacesfile.ProductInterface;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.util.ConnectionUtil;

public class ProductDAO implements ProductInterface {

	/**
	 * Creates a new product in the database.
	 *
	 * @param product The Product object containing the information for the new product.
	 * @throws PersistanceException 
	 * @throws PersistanceException if there's an issue with database connectivity or SQL execution.
	 */
	
	public void create(Product product) throws PersistanceException {
		
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO products (name,categoryId, description, weight,quantityUnit, price, ingredients, benefits, howToUse, shelfLife) VALUES (?,?,?,?,?,?,?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,product.getName());
			ps.setInt(2, product.getCategoryId());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getWeight());
			ps.setString(5, product.getQuantityUnit().toString());
			ps.setInt(6, product.getPrice());
			ps.setString(7, product.getIngredients());
			ps.setString(8, product.getBenefits());
			ps.setString(9, product.getHowToUse());
			ps.setString(10, product.getShelfLife());
			
			ps.executeUpdate();
			
			System.out.println("Product created Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	/**
	 * Updates the details of a product in the database.
	 *
	 * @param product The Product object containing the updated information for the product.
	 * @throws PersistanceException if there's an issue with database connectivity, SQL execution, or if the update fails.
	 */
	@Override
	public void updateProduct(Product product)throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
		String query = "UPDATE products SET name = ?, categoryId = ?, description = ?, "
		       + "weight = ?,quantityUnit =?, ingredients = ?, benefits = ?, "
		       + "howToUse = ?, shelfLife = ? WHERE id = ?";
		conn = ConnectionUtil.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setInt(2, product.getCategoryId());
		ps.setString(3, product.getDescription());
		ps.setInt(4, product.getWeight());
		ps.setString(5, product.getQuantityUnit().toString());
		ps.setString(6, product.getIngredients());
		ps.setString(7, product.getBenefits());
		ps.setString(8, product.getHowToUse());
		ps.setString(9, product.getShelfLife());
		ps.setInt(10, product.getId());
		
		
		int rowsAffected = ps.executeUpdate();
		
		if (rowsAffected > 0) {
		System.out.println("Product updated successfully");
		} else {
		System.out.println("product updation fails");
		}
		
		} catch (SQLException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		throw new PersistanceException("Error updating product");
		}
		finally {
		ConnectionUtil.close(conn, ps);
		}
}
	/**
	 * Updates the price of a product in the database based on its ID.
	 *
	 * @param id The ID of the product whose price is to be updated.
	 * @param price The new price to be assigned to the product.
	 * @throws PersistanceException if there's an issue with database connectivity, SQL execution, or if the update fails.
	 */
	@Override
	public void updatePrice(int id, int price) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE products SET price = ? WHERE id = ? AND isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, price);
			ps.setInt(2, id);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Price updated successfully");
			}else {
				System.out.println("price updation fails");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistanceException(e.getMessage());	
		}
		finally {
			ConnectionUtil.close(conn, ps);
			}
	}

	/**
	 * Deletes a product from the database based on its ID.
	 *
	 * @param id The ID of the product to be deleted.
	 * @throws PersistanceException if there's an issue with database connectivity, SQL execution, or if the deletion fails.
	 */
	@Override
	public void deleteProduct(int id) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE products SET isActive = 0 WHERE id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Product deleted Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	
	/**
	 * Retrieves a set of all products from the database.
	 *
	 * @return A set containing all products retrieved from the database.
	 * @throws PersistanceException if there's an issue with database connectivity, SQL execution, or result retrieval.
	 */
	@Override
	public Set<Product> listAllProducts() throws PersistanceException{

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Set<Product> allProducts = new HashSet<>(); 
		
		try {
			String query = "SELECT name, categoryId, description, weight, quantityUnit, price, ingredients, benefits, howToUse, shelfLife, createdAt, modifiedAt FROM products WHERE isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setBenefits(rs.getString("benefits"));
				product.setDescription(rs.getString("description"));
				product.setHowToUse(rs.getString("howToUse"));
				product.setIngredients(rs.getString("ingredients"));
				product.setPrice(rs.getInt("price"));
				product.setShelfLife(rs.getString("shelfLife"));
				product.setWeight(rs.getInt("weight"));
				product.setCreatedAt(rs.getString("createdAt"));
				product.setModifiedAt(rs.getString("modifiedAt"));
				product.setQuantityUnit(Product.QuantityUnit.valueOf(rs.getString("quantityUnit")));
				
				allProducts.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		return allProducts;
	}

	@Override
	public Set<Product> listallProductsByCategoryId(int categoryId) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Set<Product> listOfProductsByCategoryId = new HashSet<>(); 
		
		try {
			String query = "SELECT name, categoryId, description, weight, quantityUnit, price, ingredients, benefits, howToUse, shelfLife, createdAt, modifiedAt FROM products WHERE categoryId = ? AND isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1,categoryId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategoryId(categoryId);
				product.setBenefits(rs.getString("benefits"));
				product.setDescription(rs.getString("description"));
				product.setHowToUse(rs.getString("howToUse"));
				product.setIngredients(rs.getString("ingredients"));
				product.setPrice(rs.getInt("price"));
				product.setShelfLife(rs.getString("shelfLife"));
				product.setWeight(rs.getInt("weight"));
				product.setCreatedAt(rs.getString("createdAt"));
				product.setModifiedAt(rs.getString("modifiedAt"));
				product.setQuantityUnit(Product.QuantityUnit.valueOf(rs.getString("quantityUnit")));
				
				listOfProductsByCategoryId.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		return listOfProductsByCategoryId;
		
	}

	/**
	 * Retrieves product details based on the given product ID.
	 *
	 * @param productId The ID of the product whose details are to be retrieved.
	 * @return The Product object containing the details of the product.
	 * @throws PersistanceException if there's an issue with database connectivity, SQL execution, or result retrieval.
	 */
	@Override
	public Product findProductDetailsByProductId(int productId) throws PersistanceException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			String query = "SELECT name, categoryId, description, weight, quantityUnit, price, ingredients, benefits, howToUse, shelfLife, createdAt, modifiedAt FROM products WHERE id = ? AND isActive = 1";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1,productId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				product.setId(productId);
				product.setName(rs.getString("name"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setBenefits(rs.getString("benefits"));
				product.setDescription(rs.getString("description"));
				product.setHowToUse(rs.getString("howToUse"));
				product.setIngredients(rs.getString("ingredients"));
				product.setPrice(rs.getInt("price"));
				product.setShelfLife(rs.getString("shelfLife"));
				product.setWeight(rs.getInt("weight"));
				product.setCreatedAt(rs.getString("createdAt"));
				product.setModifiedAt(rs.getString("modifiedAt"));
				product.setQuantityUnit(Product.QuantityUnit.valueOf(rs.getString("quantityUnit")));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return product;
		}
}
