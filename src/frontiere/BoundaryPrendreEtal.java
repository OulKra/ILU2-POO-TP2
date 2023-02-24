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
		
		boolean numEtal = controlPrendreEtal.resteEtals();
		System.out.println(numEtal);
		if(numEtal)
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
		else
		{
			System.out.println("Il n'y a plus d'�tal de libre, d�sol� !");
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
