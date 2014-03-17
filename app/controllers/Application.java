package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.CategoryModel;
import models.ProductModel;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
    
    public static Result homePage(){
    	return ok(homePage.render("This is the homepage"));
    }
    
    public static Result viewAllCategories(){
		List<CategoryModel> foundCategories = Ebean.find(CategoryModel.class).findList();
		
		if(foundCategories.isEmpty()){
			return notFound("No categories have been added yet");
		}
		
    	return ok(categories.render(foundCategories));
    }
    
    public static Result viewShoppingCart(){
    	return ok(shoppingCart.render("This is your shopping cart"));
    }
    
    public static Result checkout(){
    	return ok(checkout.render("You are checking out"));
    }
    
    public static Result createUser(){
    	return ok(createuser.render("Here you can create a new user"));
    }

}
