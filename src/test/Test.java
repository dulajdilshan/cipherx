package test;

import java.awt.List;

public class Test{

    public static void main(String []args){
      System.out.println('H');
      
      int[] keys = getKey("230251945928957");
      System.out.println(keys[0]);
      System.out.println(keys[1]);
      System.out.println(keys[2]);
      
    }
    
    public static int[] getKey(String k)
    {
    	String a = k.substring(0, 5);
		String b = k.substring(5,10);
		String c = k.substring(10);
		
		double a0 = Integer.parseInt(a)*0.0001;
		double b0 = Integer.parseInt(b)*0.0001;
		double c0 = Integer.parseInt(c)*0.0001;
		
		int a1 = (int) Math.round(Math.exp(a0));
		int b1 = (int) Math.round(Math.exp(b0));
		int c1 = (int) Math.round(Math.exp(c0));
		
		int[] key = {a1,b1,c1};
		return key;
    }
}
