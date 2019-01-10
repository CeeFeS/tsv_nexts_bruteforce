package tsv_bruteforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Web_con {
	private String ip;
	private BufferedReader input;
	private String log_sfc;

	Read read = new Read();
	Comp_algorithm cp = new Comp_algorithm();

	public void connect(String urlstring) {

		URLConnection connection;
		try {
			URL url = new URL(urlstring);
			connection = url.openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

			InputStream inStream = connection.getInputStream();
			input = new BufferedReader(new InputStreamReader(inStream));

			File f = new File("return.txt");
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
			String line = "";

			while ((line = input.readLine()) != null) {
				out.write(line);
			}

			inStream.close();
			input.close();
			out.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		String s = read.read();
		cp.setIp(this.ip);
		cp.check_write(s);
		log_sfc = cp.getLog_scf();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLog_sfc() {
		return log_sfc;
	}

}
