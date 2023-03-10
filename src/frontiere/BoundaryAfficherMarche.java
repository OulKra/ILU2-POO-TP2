package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) 
	{
		String[] donnees = controlAfficherMarche.donnerInfosMarche();
		if(donnees.length == 0)
			System.out.println("Le marché est vide, revenez plus tard.");
		else
		{
			System.out.println("Vous trouverez au marché :");
			for (int i = 0; i < donnees.length-2; i++) 
			{
				System.out.println("- " + donnees[i] + " qui vend " + donnees[i+1] + " " + donnees[i+2]);
			}
		}
	}
}
