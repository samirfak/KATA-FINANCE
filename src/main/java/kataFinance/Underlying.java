package kataFinance;

public class Underlying {
	//prix de l'underlying
	private String id;
	private int price;
	private String currency;

	public Underlying(String id, int price, String currency) {
		this.id = id;
		this.price = price;
		this.currency = currency;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	
}
