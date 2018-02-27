import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	static String out;
	public static void main(String[] args) {
		out="";
		int[] key = {2,34,5};
		Encrypter encrypter = new Encrypter(key);
		String s = input();
		int s_len = s.length();
		int p = 10;  // to key
		int k1 = ((s_len/p)+1)*(p)-s_len;  // to key
		int s_len1 = s_len + k1;
		int y = s_len1/p;
		int x = p;

		char[][] s_list = new char[y][x];
		char[][] op_list = new char[y][x];
		
		for(int i = s_len+1;i<=((s_len/p)+1)*(p);i++) {
			s+=' '; 
		}
		
		for(int iy=0;iy<y;iy++) {
			for(int ix=0;ix<x;ix++) {
				s_list[iy][ix] = s.charAt(ix+(10*iy));
			}
		}
		
		for(int iy=0;iy<y;iy++) {
			for(int ix=0;ix<x;ix++) {
				System.out.print(s_list[iy][ix]);
			}
		}
		
		//Encrypt
		op_list = Encrypter.appendAll(s_list, op_list, 20, 67);
		
		for(int iy=0;iy<y;iy++) {
			for(int ix=0;ix<x;ix++) {
				out+=op_list[iy][ix];
				System.out.print(op_list[iy][ix]);
			}
		}
		save(out,"en");
		
		
		//Decrypt
		op_list = Decrypter.appendAll(op_list, s_list, 20, 67);
		out="";
		for(int iy=0;iy<y;iy++) {
			for(int ix=0;ix<x;ix++) {
				out+=s_list[iy][ix];
				System.out.print(s_list[iy][ix]);
			}
		}
		save(out,"de");
		
		
		
		
		
		
		
		
	}
	
	static String input() {
		String url = Cipher.url;
		SecretText t = new SecretText();
		
		try {
			t.readText(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t.text;
	}
	
	static void save(String op,String ca) {
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
