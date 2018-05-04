import javax.sound.midi.Soundbank;

public class Key {
//	String t= "230251945929957";
	
	public Key() {
		// TODO Auto-generated constructor stub
	}

	int[] convert(String key) {
		int key0 = 0;
        for(int i =0;i<key.length();i++) {
        	key0 = key0+ (int)key.charAt(i);
        }
        
        int tint = (int)Math.pow(10,(Integer.toString(key0)).length()-2);
        String pString = Integer.toString(key0);
        int keyA = (int)Math.pow(10,(Integer.toString(key0)).length()) / (tint*10);
        int keyB = (pString.length()*11)%10;
        int keyC = (1+(keyA ^ key0) % 21);
        
        int[] keys = {keyA,keyB,keyC};
       return keys; 
		
	}
	
}
