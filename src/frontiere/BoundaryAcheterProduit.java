package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) 
	{
		System.out.println("Bonjour " + nomAcheteur + ", quel produit voulez-vous acheter ?\n");

		String produit = scan.next();
		
		String[] nomsVendeur = controlAcheterProduit.getListVendeur(nomAcheteur);
		
		if(nomsVendeur == null)
		{
			System.out.println("Désolé, personne ne vend ce produit au marché");
		}
		else
		{
			System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
			for (int i = 0; i < nomsVendeur.length; i++) 
			{
				System.out.println(Integer.toString(i+1) + " - " + nomsVendeur[i]);
			}
			
			int id = Clavier.entrerEntier("");
			
			String question = nomAcheteur + " se déplace jusqu'à l'étal\r\n" + 
					"du vendeur " + nomsVendeur[id] + "\r\n" + 
					"- Bonjour " + nomAcheteur + "\r\n" +
					"Combien de fleurs voulez-vous\r\n" + 
					"acheter ?\r\n";
			
			int quantite = Clavier.entrerEntier(question);
			
			int etat = controlAcheterProduit.acheterProduit(nomsVendeur[id], quantite);
			
			
		}

	}
}
