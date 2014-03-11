package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result homePage(){
    	return ok(homePage.render("This is the homepage"));
    }
    
    public static Result viewAllCategories(){
    	return ok(categories.render("Here are all the categories"));
    }
    
    public static Result viewAllProducts(){
    	return ok(products.render("Here are all products"));
    }
    
    public static Result viewShoppingCart(){
    	return ok(shoppingCart.render("This is your shopping cart"));
    }
    
    public static Result checkout(){
    	return ok(checkout.render("You are checking out"));
    }
    
    public static Result searchProduct(String productName){
    	return ok(products.render("You are searching for: " + productName));
    }

}
