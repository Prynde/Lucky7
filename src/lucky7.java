import java.io.*;
import java.util.*;
public class lucky7 {

	public static void main(String[] args) {
		Random rand = new Random();
		int rahat = 5;
		int voittoja = 0;
		int[] voitot = {3, 5, 7};
		int[] numerot = new int[3];
		while (rahat >= 1) {
			rahat--;
			numerot[0] = rand.nextInt(10) + 1;
			numerot[1] = rand.nextInt(10) + 1;
			numerot[2] = rand.nextInt(10) + 1;
			System.out.println(numerot[0]);
			System.out.println(numerot[1]);
			System.out.println(numerot[2]);
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
		System.out.println("Jäljellä: " + rahat + "€");
	}
}
}
