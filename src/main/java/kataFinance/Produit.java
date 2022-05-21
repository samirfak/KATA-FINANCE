package kataFinance;

/**
 * 
 * @author samirfak
 *
 */

public class Produit {
	private /*ArrayList<Underlying>*/ Underlyings underlyings;
	private String id;
	
	/**
	 * 
	 * @param id
	 * @param underlying
	 */
	public Produit(String id, Underlying underlying) {
		this.id = id;
		this.underlyings = new Underlyings();/* ArrayList<>()*/;
		if (underlying != null) {
			underlyings.add(underlying);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param underlyings
	 */
	public Produit(String id, Underlyings underlyings) {
		this.id = id;
		this.underlyings = underlyings;
	}
	
	/**
	 * 
	 * @param underlying
	 */
	public void add(Underlying underlying) {		
		 this.underlyings.add(underlying);
	}
	
	/**
	 * 
	 * @param u
	 */
	public void setUnderlyings(/*ArrayList<Underlying>*/ Underlyings u) {
		this.underlyings = u;
	}
	
	/**
	 * 
	 * @param forex
	 * @return
	 */
	public double prixProduit(Forex forex) {
		/*double sum = 0;
		for (Underlying u : underlyings) {
			sum += u.getPrice() * forex.taux(u.getCurrency());
		}*/
		return underlyings.prix(forex);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @return
	 */
	public Underlyings getUnderlyings() {
		return this.underlyings;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		res.append(id + ": \n" + underlyings.toString());
		return res.toString();
	}

}
