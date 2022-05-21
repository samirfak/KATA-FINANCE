package kataFinance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Classe main de l'application
 * @author samirfak
 */

public class ValoCB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Instanciation de la map des Portefeuilles
		Portfolio ptfs = new Portfolio();
		//Instanciation de la map des clients
		Client clients = new Client();
		//Instanciation de la map du forex
		Forex forex = new Forex();
		//Instanciation de la map des produits avec leur quantité totale
		ProduitQteTotale pQT = new ProduitQteTotale();
		
		// Ouverture et lecture du fichier forex
		try(BufferedReader forexs = new BufferedReader(new FileReader("src/main/resources/Forex.csv"))) {
			String ligne;
			//tableau qui contiendra devise1, devise2, taux
			String[] infos = new String[3];
			
			for (int i = 0; (ligne = forexs.readLine()) != null; i++) {
				
				//Les informations utiles commencent à la 6ème ligne du fichier
				if (i > 4) {
					//Tableau qui permettra de connaître le type du taux car le format est par exemple "0,5"
					String[] verifDouble = ligne.split("\"");
					
					//si le taux est un double 
					if (verifDouble.length == 2) {//le taux est un réel
						//récupérer les 2 devises
						String[] paireDev = verifDouble[0].split(",");
						infos[0] = paireDev[0];
						infos[1] = paireDev[1];
						//remplacer la ',' du nombre réel par '.' 
						infos[2] = verifDouble[1].replace(",", ".");
						
					} else { //le taux est un entier
						//récupération de devise1, devise2, taux
						infos = ligne.split(",");
					}
					try {
						//instanciation de la paire de devises de la ligne courante
						PaireDevises p = new PaireDevises(infos[0], infos[1]);
						//Ajout de la paire de devises et du taux associé dans le forex
						forex.add(p, Double.parseDouble(infos[2]));
					} catch (Exception e) {
						System.out.println("Vérifier données: Erreur dans le fichier Forex.csv à la ligne " + (i+1) );
					}
				}				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ouverture et lecture du fichier Prices
		try(BufferedReader prices = new BufferedReader(new FileReader("src/main/resources/Prices.csv"))) {
			String ligne;
			String[] infos = new String[5];
			
			for (int i = 0; (ligne = prices.readLine()) != null; i++) {
				if (i > 3) {//Les informations utiles commencent à la 5ème ligne du fichier
					infos = ligne.split(",");
					
					try {
						//instanciation de l'underlying avec les infos récupérés sur la ligne courantes
						Underlying u = new Underlying(infos[2], Integer.parseInt(infos[4]), infos[3]);
						//instanciation du produit avec l'underlying
						Produit p = new Produit(infos[1], u);
						//Ajout du portefeuille et du produit associé la Map des portefeuilles
						ptfs.add(infos[0], p);		
					} catch (Exception e) {
						System.out.println("Vérifier données: Erreur dans le fichier Prices.csv à la ligne " + (i+1) );
					}
				}				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ouverture et lecture du fichier Product
		try(BufferedReader prices = new BufferedReader(new FileReader("src/main/resources/Product.csv"))) {
			String ligne;
			String[] infos = new String[3];
			
			for (int i = 0; (ligne = prices.readLine()) != null; i++) {
				if (i > 4) {//Les informations utiles commencent à la 6ème ligne du fichier
					infos = ligne.split(",");
					
					try {
						//récupérer dans la map des porttefeuilles le produit associé à l'id contenu dans la 1ere case du tableau
						Produit p = ptfs.getProduit(infos[0]);
						//instancer le ProduitQte avec le produit et sa quantité
						ProduitQte pQ = new ProduitQte(p, Integer.parseInt(infos[2]));
						//ajouter le client ainsi que le produitQte correspondant à la map des clients
						clients.add(infos[1], pQ);	
						//ajouter ou mettre à jour la map <idProduit, quantité totale>dg
						pQT.add(infos[0], Integer.parseInt(infos[2]));
					} catch (Exception e) {
						System.out.println("Vérifier données: Erreur dans le fichier Product.csv à la ligne " + (i+1) );
					}
				}				
			}
			//clients.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (PrintWriter ptfFile = new PrintWriter(new FileWriter("src/main/resultats/Reporting-portfolio.csv")); 
				PrintWriter clientFile = new PrintWriter(new FileWriter("src/main/resultats/Reporting-client.csv"))){
			ptfFile.println("PTF,price");
			for (Map.Entry<String, Produits> ptf : ptfs.getPortfolio().entrySet()) {
				String key = ptf.getKey();
				ptfFile.println( key + "," + ptfs.prix(key, forex, pQT));
			}
			
			clientFile.println("Client,capital");
			for (Map.Entry<String, ProduitsQtes>  client : clients.getClients().entrySet()) {
				String key = client.getKey();
				clientFile.println( key + "," + clients.calculer(key, forex));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ptfs.toString());
		System.out.println("PTF1: " + ptfs.prix("PTF1", forex, pQT));
		System.out.println("PTF2: " + ptfs.prix("PTF2", forex, pQT));
		
		System.out.println("C1: " + clients.calculer("C1", forex));
		System.out.println("C2: " + clients.calculer("C2", forex));
	}

}
