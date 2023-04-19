package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void initialisation()
	{
		System.out.println("Initialisation des tests...");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Bonemine", "fraise", 10);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"), "L'étal n'est pas trouvée");
	}

}
