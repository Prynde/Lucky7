import java.io.*;
import java.util.*;
public class lucky7 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int number1 = rand.nextInt(10) + 1;
		int number2 = rand.nextInt(10) + 1;
		int number3 = rand.nextInt(10) + 1;
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(number3);
		if (number1 == 7 || number2 == 7 || number3 == 7) {
			System.out.println("Voitit!");
		} else {
			System.out.println("Hävisit!");
		}
	}
}
