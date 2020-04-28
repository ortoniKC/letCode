package zipFileOrFolder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.io.Zip;

public class ZipFiles {
	static BufferedOutputStream outputStream;
	public static void main(String[] args) {
		try {
			Zip.unzip(new FileInputStream("Downloads.zip"), 
					new File("./files"));
		} catch (IOException e) { e.printStackTrace(); }
		try {
			File file = new File("./files");
			String zip = Zip.zip(file);
			//UPDATE
			byte[] decode = Base64.getDecoder().decode(zip);
			outputStream = new BufferedOutputStream(
					new FileOutputStream("./zipping.zip"), 10000);
			outputStream.write(decode);
		} catch (IOException e) {e.printStackTrace();}
		finally {
			try {outputStream.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
}