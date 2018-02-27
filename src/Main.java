import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		//Initialize and select encrypt and decrypt
		System.out.println("Type 'en' for encryption, 'dy' for decryption");
		System.out.print("Answer : ");
		
		
		String url = "/home/dulaj/eclipse-workspace/CipherX_v1.0/test0.txt";
		String operator = in.next();
		
		//Selection 
		if (operator.equals("en")) {
			SecretText t = new SecretText();
			t.readText(url);
			System.out.println("operator got");
		}
		System.out.println("\n"+operator);
		
	}
}
