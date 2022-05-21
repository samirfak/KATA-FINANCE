package kataFinance;

/**
 * Classe représentant un underlying
 * @author samirfak
 */

public class Underlying {
	/* id de l'underlying */
	private String id;
	/* prix de l'underlying */
	private int price;
	/* devise de l'underlying */
	private String currency;
	
	/**
	 * Constructeur pour initialiser un underlying
	 * @param id
	 * @param price
	 * @param currency
	 */
	public Underlying(String id, int price, String currency) {
		this.id = id;
		this.price = price;
		this.currency = currency;
	}
	
	/**
	 * Retoune l'id de l'underlying
	 * @return id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Retoune le prix de l'underlying
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Retoune la devise de l'underlying
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Retourne une description de l'underlying
	 * @return
	 */
	@Override
	public String toString() {
		return id + ": " + price + " " + currency + "\n";
	}
	
}
