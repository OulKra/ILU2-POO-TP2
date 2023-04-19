package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(controlLibererEtal.isVendeur(nomVendeur) == null)
		{
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else
		{
			String[] donneesEtal = controlLibererEtal.donneesEtals(nomVendeur);
			if(donneesEtal[0] == "Vrai")
			{
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2]);
				System.out.println("Au revoir " + donneesEtal[1] + ",1 passez une bonne journée");
			}
		}
	}

}