package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
		
		if(controlPrendreEtal.verifierIdentite(nomVendeur))
		{
			boolean numEtal = controlPrendreEtal.resteEtals();
			
			if(numEtal)
			{
				installerVendeur(nomVendeur);
			}
			else
			{
				System.out.println("Il n'y a plus d'étal de libre, désolé !");
			}
		}
		else
		{
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici");
		}
		
		
	}

	private void installerVendeur(String nomVendeur) 
	{
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignement\n");
		System.out.println("Quel produit souhaitez-vous vendre ?\n");
		
		Scanner scan = new Scanner(System.in);
		String produit = scan.nextLine();
		
		int quantite = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro N°" + numeroEtal);
	}
}
