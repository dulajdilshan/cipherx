import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		String s = input();
		int s_len = s.length();
		int p = 10;
		
		//Testing
//		System.out.println((int)' ');
//		System.out.println(s.length()+" "+(s.length()/p+1)*(p));
	
		for(int i = s_len+1;i<(s_len/p+1)*(p+1)-2;i++) {
			s+='#'; 
			System.out.println(i);
			//t.addText('#');
		}
		System.out.println(s.length());
		
		
		
		
		
		
		
		
		
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
}
