package สตั้สา;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Assignment35 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fileInputStream_1 = new FileInputStream("7.txt");
		FileInputStream fileInputStream_2 = new FileInputStream("8.txt");
		FileInputStream fileInputStream_3 = new FileInputStream("9.txt");
		Vector<InputStream> vector = new Vector<>();
		vector.add(fileInputStream_1);
		vector.add(fileInputStream_2);
		vector.add(fileInputStream_3);
		Enumeration<InputStream> enumeration = vector.elements();
		SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
		FileOutputStream fileOutputStream = new FileOutputStream("10.txt");
		int b;
		while((b = sequenceInputStream.read())!=-1) {
			fileOutputStream.write(b);
		}
		sequenceInputStream.close();
		fileOutputStream.close();
	}
}
