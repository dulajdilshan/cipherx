import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SecretText {
	
	String text;
	
	
	public void readText(String url) throws IOException {
		text = new String(Files.readAllBytes(Paths.get(url)));
		System.out.println(text);
	}
}
