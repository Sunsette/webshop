package models;

import java.util.List;

public class OrderModel
{
	private int orderId = 0;
	private UserModel user;
	private List<ProductModel> products;
	private int quantityOfProducts;
	private int totalCost;
	private int profit;
	private String date;

	public OrderModel(int orderId, UserModel user, List<ProductModel> products, int quantityOfProducts, int totalCost, int profit, String date)
	{
		this.orderId = orderId;
		this.user = user;
		this.products = products;
		this.quantityOfProducts = quantityOfProducts;
		this.totalCost = totalCost;
		this.profit = profit;
		this.date = date;
	}

	public OrderModel(UserModel user, List<ProductModel> products, int quantityOfProducts, int totalCost, int profit, String date)
	{
		this.user = user;
		this.products = products;
		this.quantityOfProducts = quantityOfProducts;
		this.totalCost = totalCost;
		this.profit = profit;
		this.date = date;
	}
	
	public OrderModel(UserModel user, List<ProductModel> products){
		this.user = user;
		this.products = products;
	}

	public OrderModel(int orderId, OrderModel other)
	{
		this(orderId, other.user, other.products, other.quantityOfProducts, other.totalCost, other.profit, other.date);
	}

	public int getOrderId()
	{
		return orderId;
	}

	public UserModel getUser()
	{
		return user;
	}

	public int getQuantityOfProducts()
	{
		return quantityOfProducts;
	}

	public int getTotalCost()
	{
		return totalCost;
	}

	public int getProfit()
	{
		return profit;
	}

	public String getDate()
	{
		return date;
	}

	public List<ProductModel> getProducts()
	{
		return products;
	}

	@Override
	public String toString()
	{

		return String
				.format("Order Id: %s, User: %s, Products: %s, Quantity: %s, Total Cost: %s, Profit: %s, Date: %s",
					orderId, user, products, quantityOfProducts, totalCost, profit, date);
	}

}

