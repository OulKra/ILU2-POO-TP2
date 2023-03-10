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
		System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.\n");
		
		if(controlPrendreEtal.verifierIdentite(nomVendeur))
		{
			boolean numEtal = controlPrendreEtal.resteEtals();
			
			if(numEtal)
			{
				installerVendeur(nomVendeur);
			}
			else
			{
				System.out.println("Il n'y a plus d'�tal de libre, d�sol� !");
			}
		}
		else
		{
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici");
		}
		
		
	}

	private void installerVendeur(String nomVendeur) 
	{
		System.out.println("C'est parfait, il me reste un �tal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignement\n");
		System.out.println("Quel produit souhaitez-vous vendre ?\n");
		
		Scanner scan = new Scanner(System.in);
		String produit = scan.nextLine();
		
		int quantite = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal num�ro N�" + numeroEtal);
	}
}
