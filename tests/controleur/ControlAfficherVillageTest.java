package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {

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
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Le Constructeur ne renvoie pas null");
	}

	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		assertEquals(0, controlAfficherVillage.donnerNomsVillageois().length);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterGaulois("Panoramix", 10);

		String[] noms = {"Bonemine", "Panoramix"};
		assertEquals(2, controlAfficherVillage.donnerNomsVillageois().length);
		assertArrayEquals(noms, controlAfficherVillage.donnerNomsVillageois());

	}

	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("Le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}

	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}
