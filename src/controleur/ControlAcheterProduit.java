package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	Gaulois[] listVendeur;
	public String[] getListVendeur(String produit)
	{
		listVendeur = village.rechercherVendeursProduit(produit);	
		String[] nomsVendeur = null;
		
		int taille = listVendeur.length;
		
		if(taille > 0)
		{
			nomsVendeur = new String[taille];
			for (int i = 0; i < taille; i++) {
				nomsVendeur[i] = listVendeur[i].getNom();
			}
		}
		
		return nomsVendeur;
	}
	
	public int acheterProduit(String nomVendeur, int quantite)
	{
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		int etatRetour = -1;
	
		
		
		
		
		return etatRetour;
	}
}
