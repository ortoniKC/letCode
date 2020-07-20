package zipFileOrFolder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.io.Zip;

public class ZipFiles {

	public static void main(String[] args) throws IOException {
		String zip = Zip.zip(new File("./images"));

		BufferedOutputStream stream = new BufferedOutputStream(
			new FileOutputStream("./images.zip"), 10000);
		byte[] decode = Base64.getDecoder().decode(zip);
		stream.write(decode);
		stream.close();
	}

	// public static void main(String[] args) throws FileNotFoundException,
	// IOException {

	// Zip.unzip(new FileInputStream("images.zip"), new File("./images"));

	// }
}