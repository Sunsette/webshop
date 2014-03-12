package controllers;

import java.util.ArrayList;
import java.util.List;

import models.ProductModel;
import play.*;
import play.mvc.*;
import views.html.*;

public class ProductControl  extends Controller{
	public static Result viewOneProduct(int id){
		models.ProductModel newProduct = getProductFromDB(id);
		return ok(showoneproduct.render(newProduct));
	}

	private static ProductModel getProductFromDB(int id) {
		if( id == 1){
					return new models.ProductModel(1, "Mylo Xyloto", 200);
		}
		if(id == 2){
			return new models.ProductModel(1, "A rush of blood to the head", 200);
		}
		
		return null;
	}
	
    public static Result viewAllProducts(){
    	List<ProductModel> foundProducts = new ArrayList<>();
    	foundProducts.add(new models.ProductModel(1, "Mylo Xyloto", 200));
    	foundProducts.add( new models.ProductModel(2, "A rush of blood to the head", 200));
    	
    	return ok(viewallproducts.render(foundProducts));
    }
    
    public static Result searchProduct(String productName){    	
    	return ok(searchresults.render("You are searching for: " + productName));
    }

}
