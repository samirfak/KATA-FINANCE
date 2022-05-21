package kataFinance;

import java.util.HashMap;

/**
 * Classe représentant les Clients ainsi que les données associées
 * @author samirfak
 *
 */

public class Client {
	/* Map pour stocker les clients avec leur id et la liste des (produits, quantité) pour chaque client */
	private HashMap<String, ProduitsQtes> clients;
	
	/* Constructeur pour initialiser la Map des clients */
	public Client() {
		clients = new HashMap<>() ;
	}
	
	/**
	 * Retourne la map des clients
	 * @return
	 */
	public HashMap<String, ProduitsQtes> getClients() {
		return clients;
	}
	
	/**
	 * Ajoute un client à la Map des clients
	 * @param id identifiant du client
	 * @param produitQte le couple (produit, quantité) associé au client
	 */
	public void add(String id, ProduitQte produitQte) {
		//si le client existe déjà dans la map
		if (clients.containsKey(id)) {
			//on ajoute le ProduitQte(produit, quantité) à sa liste de ProduitsQtes
			clients.get(id).add(produitQte);
		} else {//sinon
			//création d'une nouvelle liste de ProduitsQtes
			ProduitsQtes pQ = new ProduitsQtes();
			//Ajout du produitQte à la liste
			pQ.add(produitQte);
			//Ajout du client et sa liste de ProduitsQtes à la map
			clients.put(id, pQ);
		}
	}
	
	/**
	 * Calcule le prix des produits pour un client
	 * @param idClient l'id du client pour lequel on veut calculer le prix des produits
	 * @param forex la liste des paires de devises ainsi que le taux de conversion associé
	 * @return le prix en nombre réel des produits pour idClient 
	 */
	public double calculer (String idClient, Forex forex) {
		double sum = 0;
		ProduitsQtes pQ = clients.get(idClient);
		for (ProduitQte p : pQ.getProduits()) {
			sum += p.getProduit().prixProduit(forex) * p.getQte();
		}
		return sum;	
	} 
}
