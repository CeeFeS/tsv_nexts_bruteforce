package tsv_bruteforce;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	/**
	 * @param args
	 *            index 0 = startip (pattern = "000.000.000.000"), index 1 = log or
	 *            not with "log"
	 * 
	 */
	public static void main(String[] args) {

		String ip;

		ip_increment ic = new ip_increment();
		Web_con wc = new Web_con();
		ic.setStartIP(ipToLong(args[0])); // 212.224.000.000

		while (true) {

			ip = ic.inc();
			wc.setIp(ip);
			wc.connect(ip);

			if (args[1].equals("log")) {
				File f = new File("log.txt");
				BufferedWriter logwriter = null;

				try {
					logwriter = new BufferedWriter(new FileWriter(f, true));

					logwriter.write(ic.getCheck() + "\n" + ic.getProgress_str() + "\n" + ic.getF() + "\n"
							+ wc.getLog_sfc() + "\n\n");
					;

					logwriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	/**
	 * @param ipToLong
	 *            (ipToInt ) source:
	 *            "https://www.mkyong.com/java/java-convert-ip-address-to-decimal-number/"
	 */
	public static int ipToLong(String ipAddress) {

		String[] ipAddressInArray = ipAddress.split("\\.");

		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {

			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);

		}

		return (int) result;
	}

}
