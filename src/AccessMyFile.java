import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class AccessMyFile {

	public static void main(String[] args) throws IOException {
		File file = new File("/home/This is my file.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		while(bis.available()>0) {
			System.out.print((char)bis.read());
		}
	}
}
