package in.fssa.missnature.validator;


import in.fssa.missnature.exception.ValidationException;
import in.fssa.missnature.model.Orders.Status;
import in.fssa.missnature.util.StringUtil;

public class OrderValidator {

	 public void validateAddress(String userAddress)throws ValidationException{
	    	
	    	StringUtil.rejectIfInvalidString(userAddress, "userAddress");	
	 }
	 public void validateProductName(String prodName)throws ValidationException{
		 
		 StringUtil.rejectIfInvalidString(prodName, "prodName");
	 }
	 public void validateProductPrice(int price)throws ValidationException{
		 
		 if(price < 0) {
			 throw new ValidationException("price should be greater than zero");
		 } 
	 }
	 public void validateQuantity(int quantity)throws ValidationException{
		 
		 if(quantity < 0) {
			 throw new ValidationException("quantity should be greater than zero");
		 }
	 }
	
}
