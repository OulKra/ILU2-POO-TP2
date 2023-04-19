package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

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
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Le constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche()
	{
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		assertEquals(0, controlAfficherMarche.donnerInfosMarche().length);
		
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "Fraise", 10);
		assertEquals(3, controlAfficherMarche.donnerInfosMarche().length);
		assertEquals("Bonemine", controlAfficherMarche.donnerInfosMarche()[0]);
		assertEquals("10", controlAfficherMarche.donnerInfosMarche()[1]);
		assertEquals("Fraise", controlAfficherMarche.donnerInfosMarche()[2]);

	}

}
