package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1526two {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String snum = bf.readLine();
		int numSize = snum.length();
		int num = Integer.parseInt(snum);
		int result = 0;
		while (numSize != 0) {
			int part = (int) (num % (Math.pow(10, numSize)));
			if (part < 4) {
				while (numSize != -1) {
					result += (int) (7 * (Math.pow(10, numSize - 2)));
					numSize--;
				}
				break;
			} else if (part >= 4 && part < 7) {
				result += (int) (4 * (Math.pow(10, numSize - 1)));
				numSize--;
			} else {
				result += (int) (7 * (Math.pow(10, numSize - 1)));
				numSize--;
			}
			num -= part * (Math.pow(10, numSize));

		}
		System.out.println(result);
	}
}
