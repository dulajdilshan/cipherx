import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Cipher {
	
	static Scanner in = new Scanner(System.in);
	static String url = "/home/dulaj/eclipse-workspace/CipherX_v1.0/test1.txt";
	
	public void doSomething() throws IOException {
		
		//Initialize and select encrypt and decrypt
		System.out.println("Type 'en' for encryption, 'dy' for decryption");
		System.out.print("Answer : ");	
		String operator = in.next();
		
		//Selection 
		if (operator.equals("en")) {
			SecretText t = new SecretText();
			t.readText(url);
		}else if (operator.equals("dy")) {
			System.out.println("Decryption is not set yet");
		}else {
			System.out.println("Wrong operation");
		}
		
	}
}
