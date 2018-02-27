import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SecretText {
	
	String text;

	public String readText(String url) throws IOException {
		text = new String(Files.readAllBytes(Paths.get(url)));
		return text;
	}
	
	void addText(char c) {
		text += c;
	}
	
}
