package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		Gaulois habitant = village.trouverHabitant(nomVendeur);
		if(habitant == null)
			return false;
		return true;
	}
}
