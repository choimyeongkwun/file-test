package servlet;

import java.io.File;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		File f = new File("c:\\test.txt");
		f.createNewFile();
		System.out.println(f.exists());
	}
}
