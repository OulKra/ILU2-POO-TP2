package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		System.out.println(nomVisiteur + " " + controlEmmenager.isHabitant(nomVisiteur));
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenu villageois" + nomVisiteur);
					String question2 = "Quelle est votre force ?";
					int force = Clavier.entrerEntier(question2);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}
	
	private void emmenagerDruide(String nomVisiteur) 
	{
		System.out.println("Bienvenu druide " + nomVisiteur);
		String question2 = "Quelle est votre force ?";
		int force = Clavier.entrerEntier(question2);
		
		int effetPotionMin;
		int effetPotionMax;
		
		do
		{
			String question3 = "Quelle est la force de votre potion la plus faible que vous produisiez ?";
			effetPotionMin = Clavier.entrerEntier(question3);
			
			String question4 = "Quelle est la force de votre potion la plus forte que vous produisiez ?";
			effetPotionMax = Clavier.entrerEntier(question4);
			if(effetPotionMin > effetPotionMax)
			{
				System.out.println("Attention Duide, vous vous êtes trompé entre le minimum et le maximum");
			}
		} while(effetPotionMin > effetPotionMax);
		
		System.out.println("Le druide " + nomVisiteur + " : « Bonjour, je\r\n" + 
				"suis le druide " + nomVisiteur + " et ma\r\n" + 
				"potion peut aller d'une force "+effetPotionMin+" à \r\n" + 
				effetPotionMax+".»");
		controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
