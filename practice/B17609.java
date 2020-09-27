package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			System.out.println(isP(str));
		}
	}

	static boolean isH(int left, int right, String str) {
		String[] parse = str.split("");
		while (left <= right) {
			if (parse[left].equals(parse[right])) {
				left++;
				right--;
			} else
				return false;
		}
		return true;
	}

	static int isP(String str) {
		String[] parse = str.split("");
		for (int i = 0; i < str.length() / 2; i++) {
			if (!(parse[i].equals(parse[str.length() - i - 1]))) {
				boolean removeLeft = isH(i + 1, str.length() - i - 1, str);
				boolean removeRight = isH(i, str.length() - i - 1 - 1, str);
				if (removeLeft || removeRight)
					return 1;
				else
					return 2;
			}
		}
		return 0;
	}
}
