import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Reverse {
	public static void main(String[] args) throws IOException {

		ArrayList<String> arr = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\input.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Desktop\\output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		String data;
		while ((data = br.readLine()) != null) {
			arr.add(data);
		}

		for (int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(arr.size()-(i+1)));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		osw.close();
		fos.close();
		br.close();
		isr.close();
		fis.close();
	}
}
