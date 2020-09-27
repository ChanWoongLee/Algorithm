package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17615 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bf.readLine();
		String[] str = bf.readLine().split("");
		String now = "";
		int red = 0;
		int blue = 0;

		for (int i = 0; i < str.length; i++) {
			if (now.equals("")) {
				now = str[i];
			} else {
				if (!now.equals(str[i])) {
					if (str[i].equals("R")) {
						red++;
					} else
						blue++;
					now = str[i];
				}
			}
		}
		if ((red == 1 && blue == 0) || (blue == 1 && red == 0)) {
			System.out.println("0");
			return;
		}
		if (red <= blue)
			System.out.println(red);
		else
			System.out.println(blue);
	}
}
