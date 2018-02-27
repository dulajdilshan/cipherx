import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Decrypter {

	static String text;
	static char[][] appendAll(char[][] sourceList,char[][] bigList,int key0,int key1) {
		char[] temList;
		for(int i=0;i<sourceList.length;i++) {
			temList = sourceList[i];
			appendToList(setList(temList, key0), bigList, i, key1);
		}
		return bigList;
	}
	static void appendToList(char[] charList,char[][] bigList,int index,int key){
//		index = (index + key)%bigList.length;
		bigList[index] = charList;
	}
	static char[] setList(char[] sr,int key) {
		char[] op = new char[sr.length];
		for(int j=0;j<sr.length;j++) {
			op[j] = notShift(sr[j],j,key);
			text += op[j];
		}
		return op;
	}

	//Decrypt
	static char notShift(char c, int index, int key) {
		index = index % 9;
		key = key % 9;
		int op = index*3+key;
		return (char)((int)c+op);
	}
	
	void save(String op) {
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/home/dulaj/eclipse-workspace/CipherX_v1.0/decout.txt"));
            out.write(op);
            out.close();
        }catch (IOException e)
        {
            System.out.println("Exception ");

        }
	}
	
	
}
