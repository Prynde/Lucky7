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
		String ANSI_RESET = "\u001B[0m";
		String ANSI_REDBG = "\u001B[41m";
		String ANSI_WHITE = "\033[1;37m";
		
		// Kysytään millä summalla halutaan pelata
		System.out.println("Syötä rahaa, yksi pelikierros maksaa 1€");
		rahat = in.nextInt();
		inputclean = in.nextLine(); // Siivotaan syötteestä rivinvaihto ettei looppi pyörähdä alussa kahdesti
		
		while (uusipeli == true) {
			rahat--;
			kierros++;
			System.out.println("Kierros " + kierros);
			
			// Arvotaan numerot
			numerot[0] = rand.nextInt(9) + 1;
			numerot[1] = rand.nextInt(9) + 1;
			numerot[2] = rand.nextInt(9) + 1;
			// Tarkastetaan voitot ja tulostetaan tulos, voittavat numerot näytetään punaisina
			System.out.println("===============");
			System.out.print("|| ");
			if (numerot[0] == 7) {
				System.out.print(ANSI_REDBG + ANSI_WHITE + numerot[0] + ANSI_RESET);
				voittoja++;
			} else {
				System.out.print(numerot[0]);
			}
			System.out.print(" | ");
			if (numerot[1] == 7) {
				System.out.print(ANSI_REDBG + ANSI_WHITE + numerot[1] + ANSI_RESET);
				voittoja++;
			} else {
				System.out.print(numerot[1]);
			}
			System.out.print(" | ");
			if (numerot[2] == 7) {
				System.out.print(ANSI_REDBG + ANSI_WHITE + numerot[2] + ANSI_RESET);
				voittoja++;
			} else {
				System.out.print(numerot[2]);
			}
			System.out.println(" ||");
			System.out.println("===============");
						
			
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