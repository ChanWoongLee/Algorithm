package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20164 {
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String str = st.nextToken();
		recur(str, oddCnt(str.split("")));
		System.out.println(MIN + " " + MAX);
	}

	static int oddCnt(String[] strAr) {
		int ret = 0;
		for (int i = 0; i < strAr.length; i++) {
			if (Integer.parseInt(strAr[i]) % 2 != 0)
				ret++;
		}
		return ret;
	}

	static int recur(String str, int num) {
		if (str.length() == 1) {
			return oddCnt(str.split("")) + num;
		}

		if (str.length() == 2) {
			int first = Integer.parseInt(str.substring(0, 1));
			int middle = Integer.parseInt(str.substring(1, 2));
			int sum = first + middle;
			int cnt = oddCnt(String.valueOf(sum).split(""));
			if (sum >= 10) {
				return recur(String.valueOf(sum), num + cnt);
			} else
				return num + cnt;
		}
		int totalCnt = 0;
		for (int i = 1; i <= str.length() - 2; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				int first = Integer.parseInt(str.substring(0, i));
				int middle = Integer.parseInt(str.substring(i, j));
				int last = Integer.parseInt(str.substring(j, str.length()));
				int sum = first + middle + last;
				int cnt = oddCnt(String.valueOf(sum).split(""));
				totalCnt = recur(String.valueOf(sum), num + cnt);
				MIN = Math.min(totalCnt, MIN);
				MAX = Math.max(totalCnt, MAX);
			}
		}
		return totalCnt;
	}
}
