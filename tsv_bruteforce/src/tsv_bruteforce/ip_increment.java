package tsv_bruteforce;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ip_increment {
	private int ip = 0;
	private InetAddress address;
	private String check;
	private String progress_str;
	private String f;

	private int progress;

	public String inc() {

		String ip_s = toInetAddress(ip);

		String s = "https://www.nexteamspeak.de/backend/external/tsviewer/ts3v.php?ip=" + ip_s
				+ ":3271&tcp=30066&mode=4";

		this.check = "Check with: " + ip_s; // +++++
		System.out.println(this.check);
		progress = this.ip * (-1);
		this.progress_str = progress + " IPs of 4.294.967.296";

		System.out.println(this.progress_str);
		Float f = (float) (progress * 100 / 2 ^ 32);

		this.f = f + "";
		System.out.println(f);

		this.ip++;

		return s;

	}

	private static String toInetAddress(int ipAddress) {
		long ip = (ipAddress < 0) ? (long) Math.pow(2, 32) + ipAddress : ipAddress;
		InetAddress inetAddress = null;
		String addr = String
				.valueOf((ip >> 24) + "." + ((ip >> 16) & 255) + "." + ((ip >> 8) & 255) + "." + (ip & 255));
		return addr;
	}

	public void setStartIP(int startIP) {
		this.ip = startIP;
	}

	///////////////////////////////////////////////

	public String getCheck() {
		return check;
	}

	public String getProgress_str() {
		return progress_str;
	}

	public String getF() {
		return f;
	}

	// public String inc_a() {
	// String s = null;
	// if (this.ip_a < 1000) {
	// s = "https://www.nexteamspeak.de/backend/external/tsviewer/ts3v.php?ip=" +
	// this.ip_a + "." + this.ip_b + "."
	// + this.ip_c + "." + this.ip_d + ":3271&tcp=30066&mode=4";
	//
	// this.ip_a++;
	// } else {
	//
	// }
	// return s;
	// }
	//
	// public String inc_b() {
	// String s = null;
	// if (this.ip_b < 1000) {
	// s = "https://www.nexteamspeak.de/backend/external/tsviewer/ts3v.php?ip=" +
	// this.ip_a + "." + this.ip_b + "."
	// + this.ip_c + "." + this.ip_d + ":3271&tcp=30066&mode=4";
	//
	// this.ip_b++;
	// } else {
	//
	// }
	// return s;
	// }
	//
	// public String inc_c() {
	// String s = null;
	// if (this.ip_c < 1000) {
	// s = "https://www.nexteamspeak.de/backend/external/tsviewer/ts3v.php?ip=" +
	// this.ip_a + "." + this.ip_b + "."
	// + this.ip_c + "." + this.ip_d + ":3271&tcp=30066&mode=4";
	//
	// this.ip_c++;
	// } else {
	//
	// }
	// return s;
	// }
	//
	// public String inc_d() {
	// String s = null;
	// if (this.ip_d < 1000) {
	// s = "https://www.nexteamspeak.de/backend/external/tsviewer/ts3v.php?ip=" +
	// this.ip_a + "." + this.ip_b + "."
	// + this.ip_c + "." + this.ip_d + ":3271&tcp=30066&mode=4";
	//
	// this.ip_d++;
	// } else {
	// this.ip_d = 0;
	// }
	// return s;
	// }
}
