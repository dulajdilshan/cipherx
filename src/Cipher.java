import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.tools.DocumentationTool.DocumentationTask;

public class Cipher {
	
	private static String url = "/home/dulaj/eclipse-workspace/CipherX_v1.0/outen.txt";
	private static Scanner in = new Scanner(System.in);
	private static String op;
	
	public Cipher(String op) {
		this.op = op;
	} 
	
	public static void main(String[] args) {
		
		//Initialize and select encrypt and decrypt
		System.out.println("Type 'en' for encryption, 'dy' for decryption");
		System.out.print("Answer : ");	
		String operator = in.next();
		
		Cipher cipher = new Cipher(operator);
		SecretText secretText = new SecretText();
		try {
			cipher.doIt(secretText.readText(url), op);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String doIt(String secretText,String operation) {
		String outText = "";
		
		//Assign the key
		String keyString = "230251945929957";
		Key keyObject = new Key();
		int[] key = keyObject.convert(keyString);
		
		
		//length and values of the text
		int slen0 = secretText.length();
		int p = key[0];   //packet length
		int ad = ((slen0 / p) + 1) * p - slen0;   //additional chars
		int slen1 = slen0 + ad;
		
		//set list operators
		int x = p;
		int y = slen1 / p;
		
		//2D List
		char[][] inList = new char[y][x];
		char[][] outList = new char[y][x];
		
		//Filling spaces
		for(int i = slen0+1;i<=ad+slen0;i++) {
			secretText+=' '; 
		}
	
		//Set List
		for(int iy=0;iy<y;iy++) {
			for(int ix=0;ix<x;ix++) {
				inList[iy][ix] = secretText.charAt(ix+(10*iy));
			}
		}
		
		if (operation.equals("en")) {
			outList = Encrypter.appendAll(inList, outList, key[2], 67);
			for(int iy=0;iy<y;iy++) {
				for(int ix=0;ix<x;ix++) {
					outText+=outList[iy][ix];
//					System.out.print(outList[iy][ix]);
				}
			}
			save(outText, "en");
			
		} else if (operation.equals("de")) {
			outList = Decrypter.appendAll(inList, outList, key[2], 67);
			for(int iy=0;iy<y;iy++) {
				for(int ix=0;ix<x;ix++) {
					outText+=outList[iy][ix];
//					System.out.print(outList[iy][ix]);
				}
			}
			save(outText.substring(0,slen0), "de");
		}else {
			System.out.println("Bad Operation");
		}
		
		
		return keyString;
	}
	

	void save(String op,String ca) {
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/home/dulaj/eclipse-workspace/CipherX_v1.0/out"+ca+".txt"));
            out.write(op);
            out.close();
        }catch (IOException e)
        {
            System.out.println("Exception ");

        }
	}
}
