package kataFinance;

/**
 * Classe représentant un produit
 * @author samirfak
 */

public class Produit {
	/* Underlyings du produit */
	private Underlyings underlyings;
	/* Identifiant du produit*/
	private String id;
	
	/**
	 * Constructeur pour un produit
	 * @param id identifiant produit
	 * @param underlying un underlying du produit 
	 */
	public Produit(String id, Underlying underlying) {
		this.id = id;
		this.underlyings = new Underlyings();
		if (underlying != null) {
			underlyings.add(underlying);
		}
	}
	
	/**
	 * Constructeur pour un produit
	 * @param id identifiant produit
	 * @param underlyings liste d'underlyings du produit
	 */
	public Produit(String id, Underlyings underlyings) {
		this.id = id;
		this.underlyings = underlyings;
	}
	
	/**
	 * Ajoute un underlying à un produit
	 * @param underlying underlying à ajouter
	 */
	public void add(Underlying underlying) {		
		 this.underlyings.add(underlying);
	}
	
	/**
	 * Modifie la liste d'underlyings du produit
	 * @param u nouvelle liste d'underlyings
	 */
	public void setUnderlyings(Underlyings u) {
		this.underlyings = u;
	}
	
	/**
	 * Calcule le prix d'un produit via sa liste d'underlyings
	 * @param forex map pour la conversion
	 * @return prix du produit
	 */
	public double prixProduit(Forex forex) {
		return underlyings.prix(forex);
	}
	
	/**
	 * Retourne l'id du produit
	 * @return
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Retourne la liste d'underlyings du produit
	 * @return
	 */
	public Underlyings getUnderlyings() {
		return this.underlyings;
	}
	
	/**
	 * Renvoie une description du produit sous forme de String
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		res.append(id + ": \n" + underlyings.toString());
		return res.toString();
	}

}
