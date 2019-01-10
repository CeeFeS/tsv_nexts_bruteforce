package tsv_bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Comp_algorithm {

	private String ip;
	private String comp_text;
	private int ip_nummer = 1;
	private String finalIp;
	private int existingIp_counter;
	private int non_exisingIp_counter;
	private String log_scf;

	private String server_on;
	private String comp_text_str;
	private String found_ip;

	public void check_write(String comp_text) {

		this.comp_text = comp_text;
		if (comp_text.contains("Verbindung zum TeamSpeak3 Server fehlgeschlagen.") || comp_text.contains("ist keine")) {
			this.found_ip = "";
			this.server_on = "NO SERVER ON: " + this.ip + "\n"; // +++
			System.out.println(this.server_on);
			non_exisingIp_counter++;
			this.comp_text_str = "########\n" + this.comp_text + "\n########\n\n";
			System.out.println(this.comp_text_str);

		} else {

			File f = new File("existing_ips.txt");
			BufferedWriter writer = null;

			try {
				writer = new BufferedWriter(new FileWriter(f, false));

				finalIp = this.ip.replaceAll(":3271&tcp=30066&mode=4", "").replaceAll(
						"https://www.nexteamspeak.de/backend/external/tsviewer/ts3v.php", "IP#" + ip_nummer + " ");
				;
				this.server_on = "Found Server on: " + this.ip + "\n"; // +++
				this.found_ip = "\n\n---------------------------------------------------------------------\nFound IP: "
						+ this.finalIp + "\n---------------------------------------------------------------------\n\n";

				System.out.println(this.server_on + this.found_ip);

				writer.append(this.finalIp + "\n");
				existingIp_counter++;
				ip_nummer++;
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		log_scf = this.server_on + this.comp_text_str + this.found_ip;
		writeStats();
	}

	public void writeStats() {
		File f = new File("stats.txt");
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(f, false));

			writer.write("ip found: " + existingIp_counter + "\n" + "no ip found: " + non_exisingIp_counter + "\n\r");
			writer.close();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	//////////////////////////////////////////////////////////////////////////

	public String getLog_scf() {
		return log_scf;
	}

}
