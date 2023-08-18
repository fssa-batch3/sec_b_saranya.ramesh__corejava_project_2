package in.fssa.missnature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import in.fssa.missnature.interfacesfile.ProductInterface;
import in.fssa.missnature.model.Product;
import in.fssa.missnature.util.ConnectionUtil;

public class ProductDAO implements ProductInterface {

	/**
	 * Creates a new product in the database.
	 *
	 * @param product The Product object containing the information for the new product.
	 * @throws RuntimeException if there's an issue with database connectivity or SQL execution.
	 */
	@Override
	public void create(Product product) {
		
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO products (name,category_id, description, product_weight,quantity_unit, price, ingredients, benefits, how_to_use, shelf_life) VALUES (?,?,?,?,?,?,?,?,?,?)";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,product.getName());
			ps.setInt(2, product.getCategory_id());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getProduct_weight());
			ps.setString(5, product.getQuantity_unit().toString());
			ps.setInt(6, product.getPrice());
			ps.setString(7, product.getIngredients());
			ps.setString(8, product.getBenefits());
			ps.setString(9, product.getHow_to_use());
			ps.setString(10, product.getShelf_life());
			
			ps.executeUpdate();
			
			System.out.println("Product created Successfully");
			
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
	 * Updates the details of a product in the database.
	 *
	 * @param product The Product object containing the updated information for the product.
	 * @throws RuntimeException if there's an issue with database connectivity, SQL execution, or if the update fails.
	 */
	@Override
	public void updateProduct(Product product ) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
		String query = "UPDATE products SET name = ?, category_id = ?, description = ?, "
		       + "product_weight = ?,quantity_unit =?, ingredients = ?, benefits = ?, "
		       + "how_to_use = ?, shelf_life = ? WHERE id = ?";
		conn = ConnectionUtil.getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setInt(2, product.getCategory_id());
		ps.setString(3, product.getDescription());
		ps.setInt(4, product.getProduct_weight());
		ps.setString(5, product.getQuantity_unit().toString());
		ps.setString(6, product.getIngredients());
		ps.setString(7, product.getBenefits());
		ps.setString(8, product.getHow_to_use());
		ps.setString(9, product.getShelf_life());
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
		throw new RuntimeException("Error updating product");
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
	 * @throws RuntimeException if there's an issue with database connectivity, SQL execution, or if the update fails.
	 */
	@Override
	public void updatePrice(int id, int price) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE products set price = ? WHERE id = ?";
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
			throw new RuntimeException(e);	
		}
	}

	/**
	 * Deletes a product from the database based on its ID.
	 *
	 * @param id The ID of the product to be deleted.
	 * @throws RuntimeException if there's an issue with database connectivity, SQL execution, or if the deletion fails.
	 */
	@Override
	public void deleteProduct(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "DELETE FROM products WHERE id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Product deleted Successfully");
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
	}
	
	/**
	 * Retrieves a set of all products from the database.
	 *
	 * @return A set containing all products retrieved from the database.
	 * @throws RuntimeException if there's an issue with database connectivity, SQL execution, or result retrieval.
	 */
	@Override
	public Set<Product> listAllProducts() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Set<Product> allProducts = new HashSet<>(); 
		
		try {
			String query = "SELECT * FROM products";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setBenefits(rs.getString("benefits"));
				product.setDescription(rs.getString("description"));
				product.setHow_to_use(rs.getString("how_to_use"));
				product.setIngredients(rs.getString("ingredients"));
				product.setPrice(rs.getInt("price"));
				product.setShelf_life(rs.getString("shelf_life"));
				product.setProduct_weight(rs.getInt("product_weight"));
				product.setQuantity_unit(Product.QuantityUnit.valueOf(rs.getString("quantity_unit")));
				
				allProducts.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		finally {
			ConnectionUtil.close(conn, ps);
		}
		return allProducts;
	}

	@Override
	public Set<Product> listallProductsByCategoryId(int category_id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Set<Product> listOfProductsByCategoryId = new HashSet<>(); 
		
		try {
			String query = "SELECT * FROM products WHERE category_id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1,category_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setBenefits(rs.getString("benefits"));
				product.setDescription(rs.getString("description"));
				product.setHow_to_use(rs.getString("how_to_use"));
				product.setIngredients(rs.getString("ingredients"));
				product.setPrice(rs.getInt("price"));
				product.setShelf_life(rs.getString("shelf_life"));
				product.setProduct_weight(rs.getInt("Product_weight"));
				product.setQuantity_unit(Product.QuantityUnit.valueOf(rs.getString("quantity_unit")));
				
				listOfProductsByCategoryId.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
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
	 * @throws RuntimeException if there's an issue with database connectivity, SQL execution, or result retrieval.
	 */
	@Override
	public Product findProductDetailsByProductId(int productId) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			String query = "SELECT * FROM products WHERE id = ?";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1,productId);
			rs = ps.executeQuery();
			
		
			
			if(rs.next()) {
				product = new Product();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setIngredients(rs.getString("ingredients"));
				product.setBenefits(rs.getString("benefits"));
				product.setHow_to_use(rs.getString("how_to_use"));
				product.setShelf_life(rs.getString("shelf_life"));
				product.setPrice(rs.getInt("price"));
				product.setProduct_weight(rs.getInt("Product_weight"));
				product.setQuantity_unit(Product.QuantityUnit.valueOf(rs.getString("quantity_unit")));
				product.setCategory_id(rs.getInt("category_id"));
				
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		finally {
			ConnectionUtil.close(conn, ps, rs);
		}
		return product;
		}

	
}
