package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.ProductModel;
import play.*;
import play.mvc.*;
import views.html.*;

public class ProductControl extends Controller {
	
	public static Result viewOneProduct(int id) {
		ProductModel newProduct = Ebean.find(ProductModel.class, id);
		
		if(newProduct == null){
			return notFound("Product not found");
		}
		
		return ok(showoneproduct.render(newProduct));
	}

	public static Result viewAllProducts() {
    	List<ProductModel> foundProducts = Ebean.find(ProductModel.class).findList();

		return ok(viewallproducts.render(foundProducts));
	}

	public static Result searchProduct(String productName) {
		
		String realProductName = productName.replace("_", " ");
		
		List<ProductModel> foundProducts = Ebean.find(ProductModel.class).where().eq("name", realProductName).findList();
		
		if(foundProducts.isEmpty()){
			return notFound("Product not found");
		}
		
		return ok(searchresults.render(foundProducts));
	}
	
	public static Result viewProductsOfCategory(String category){
		List<ProductModel> foundProducts = Ebean.find(ProductModel.class).where().eq("category", category).findList();
		
		if(foundProducts.isEmpty()){
			return notFound("No products found in this category");
		}
		
		return ok(viewproductsofcategory.render(foundProducts, category));
	}
	
	public static Result populateDB(){
		ProductModel newProduct = new ProductModel.Builder("Mylo Xyloto").rrp(149).id(1).build();
		ProductModel newProduct2 = new ProductModel.Builder("A rush of blood to the head").rrp(200).id(2).build();
		
		Ebean.save(newProduct);
		Ebean.save(newProduct2);
		
		return ok(populatedb.render("Products saved to database"));
		
	}

}
