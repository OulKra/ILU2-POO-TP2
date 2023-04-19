package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	
	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	
	public Etal isVendeur(String nomVendeur)
	{
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public String[] donneesEtals(String nomVendeur) {
		String[] donneesEtal = null;
		Etal vendeur = isVendeur(nomVendeur); 
		if(vendeur != null)
		{

			donneesEtal = new String[5];
			if(vendeur.isEtalOccupe())
				donneesEtal[0] = "Vrai";
			else
				donneesEtal[0] = "Faux";
			donneesEtal[1] = nomVendeur;
			donneesEtal[2] = vendeur.getProduit();
			donneesEtal[3] = String.valueOf(vendeur.getQuantiteInit());
			donneesEtal[4] = String.valueOf(vendeur.getQuantiteInit() - vendeur.getQuantite());
			
		}
		
		return donneesEtal;
	}

}
