import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eni.pbanque.CompteCourant;
import fr.eni.pbanque.InvalidSoldeException;
import fr.eni.pclient.Personne;

class CompteTest {

	CompteCourant compte1;
	Personne pers1;
	
	@BeforeAll
	public static void montageClasse() {
		System.out.println("Montage avec tous les tests");
	}
	
	@BeforeEach
	void init() {
		// creer un objet
		compte1 = new CompteCourant ("100566", 100 , LocalDate.of ( 2012 , 03 , 10), pers1 , 0 );
	}
	
	@Test
	void testCrediter() {
		// appeler la méthode à tester
		compte1.crediter(10);
		// comparer le résultat
		assertTrue(110 == compte1.getSoldeCompte());
	}
	
	@Test
	void testDebiter() {
		try {
			compte1.debiter(100);
		} catch (InvalidSoldeException e) {
			System.out.println(e.getMessage());

		}
		assertTrue(0 == compte1.getSoldeCompte());
	}
	

	

}
