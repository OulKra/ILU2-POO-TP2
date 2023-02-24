package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal;
		if(!verifierIdentite(nomVendeur))
		{
			numeroEtal = -1;
		}
		else
		{
			Gaulois habitant = village.trouverHabitant(nomVendeur);
			numeroEtal = village.installerVendeur(habitant, produit, nbProduit);
		}
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		Gaulois habitant = village.trouverHabitant(nomVendeur);
		if(habitant == null)
			return false;
		return true;
	}
}
