package kataFinance;

import java.util.ArrayList;

public class Produit {
	private ArrayList<Underlying> underlyings;
	private String id;
	
	public Produit(String id, Underlying underlying) {
		this.id = id;
		this.underlyings = new ArrayList<>();
		if (underlying != null) {
			underlyings.add(underlying);
		}
	}
	
	public boolean add(Underlying underlying) {		
		return this.underlyings.add(underlying);
	}
	
	public void setUnderlyings(ArrayList<Underlying> u) {
		this.underlyings = u;
	}
	
	public double prixProduit(Forex forex) {
		double sum = 0;
		for (Underlying u : underlyings) {
			sum += u.getPrice() * forex.taux(u.getCurrency());
		}
		return sum;
	}
	
	public String getId() {
		return this.id;
	}
	
	public ArrayList<Underlying> getUnderlyings() {
		return this.underlyings;
	}

}
