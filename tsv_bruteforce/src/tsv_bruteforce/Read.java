package tsv_bruteforce;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {
	private FileReader reader = null;
	private BufferedReader br = null;

	private StringBuilder sb = new StringBuilder();

	public String read() {
		String s = null;
		try {
			reader = new FileReader("return.txt");
			this.br = new BufferedReader(reader);

			while ((s = br.readLine()) != null) {
				return s;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}

}
