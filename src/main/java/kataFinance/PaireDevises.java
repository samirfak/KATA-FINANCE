package kataFinance;

/**
 * Classe représentant une paire de devises
 * @author samirfak
 */
public class PaireDevises {
	//Déclaration 1ère devise et 2ème devise
	String dev1, dev2;
	
	/**
	 * Constructeur pour initialiser les devises
	 * @param dev1 la 1ère devise
	 * @param dev2 la 2ème devise
	 */
	public PaireDevises(String dev1, String dev2) {
		this.dev1 = dev1;
		this.dev2 = dev2;
	}
	
	/**
	 * Retourne la position d'une devise
	 * @param dev la devise
	 * @return 0 si la devise est la première de la paire
	 * 		   1 si la devise est la deuxième de la paire
	 * 		   -1 si la devise n'est pas dans la paire
	 */
	public int index (String dev) {
		if (dev.equals(dev1)) {
			return 0;
		} else if (dev.equals(dev2)) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * Retourne la 1ère devise de la paire
	 * @return dev1
	 */
	public String getDev1() {
		return dev1;
	}
	
	/**
	 * Retourne la 2ème devise de la paire
	 * @return dev2
	 */
	public String getDev2() {
		return dev2;
	}
	
	/**
	 * Retourne l'égalité entre 2 paires de devises
	 * @param p la 2ème paire de devises
	 * @return true si les 2 paires ont la même 1ere devise et la même 2eme devise
	 * 		   false si les 2 paires n'ont pas la même 1ere devise ou la même 2eme devise
	 */
	@Override
	public boolean equals(Object p) {
		return this.dev1.equals(((PaireDevises) p).getDev1()) && this.dev2.equals(((PaireDevises) p).getDev2());
	}
}
