package in.fssa.missnature;

import java.util.Set;

import org.junit.jupiter.api.Test;

import in.fssa.missnature.model.Product;
import in.fssa.missnature.service.ProductService;

public class GetAllProducts {

	@Test
	 void getAllProductsByCategoryId() {
	    ProductService productService = new ProductService();
	    Set<Product> products;
	    try {
	        products = productService.findProductDetailByCategoryId(1);
	        System.out.println(products);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Test
	 void getProductDetailsByProductId() {
		
		 ProductService productService = new ProductService();
		 
		 try {
			 Product product = productService.FindProductDetailsByProductId(1);
			 System.out.println(product);
			 
		 }catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	
	@Test
	 void getAll(){
		ProductService productService = new ProductService();
		Set<Product> AllProducts;
		try {
			AllProducts = productService.listAllProduct();
			System.out.print(AllProducts);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
