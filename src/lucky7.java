import java.io.*;
import java.util.*;

public class lucky7 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);

		// Alustetaan kaikki tarvittavat muuttujat
		int rahat = 0;
		int voittoja = 0;
		int[] voitot = {3, 5, 7};
		int[] numerot = new int[3];
		boolean uusipeli = true;
		int kierros = 0;
		String uusikierros;
		String inputclean;
		
		// Kysytään millä summalla halutaan pelata
		System.out.println("Syötä rahaa, yksi pelikierros maksaa 1€");
		rahat = in.nextInt();
		inputclean = in.nextLine(); // Siivotaan syötteestä rivinvaihto ettei looppi pyörähdä alussa kahdesti
		
		while (uusipeli == true) {
			rahat--;
			kierros++;
			System.out.println("Kierros " + kierros);
			
			// Arvotaan numerot
			numerot[0] = rand.nextInt(10) + 1;
			numerot[1] = rand.nextInt(10) + 1;
			numerot[2] = rand.nextInt(10) + 1;
			System.out.println("===============");
			System.out.println("|| " + numerot[0] + " | " + numerot[1] + " | " + numerot[2] + " ||");
			System.out.println("===============");
			
			// Tarkastetaan voitot
			for ( int i = 0; i < 3; i++) {
				if (numerot[i] == 7) {
					voittoja++;
				}
			}
			if (voittoja != 0) {
				System.out.println("Voitit " + voitot[(voittoja - 1)] + " €!");
				rahat = rahat + voitot[(voittoja - 1)];
				voittoja = 0;
			} else {
				System.out.println("Hävisit!");
			}
			// Tarkastetaan onko rahaa vielä jäljellä ja jos on, kysytään pelataanko vielä
			if (rahat >= 1) {
				System.out.println("Jäljellä: " + rahat + "€");
				System.out.println("Haluatko pelata uudelleen? Jos haluat pelata, paina Enter. Jos et halua pelata, kirjoita e ja paina Enter.");
				uusikierros = in.nextLine();
				if (uusikierros.equals("e")) {
					uusipeli = false;
					System.out.println("Sinulle jäi " + rahat + "€");
				}
			} else  {
				System.out.println("Rahat loppuivat.");
				uusipeli = false;
			}
		}
	}
}