package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9019 {
	static int result;
	static String start, end;
	static boolean flag;
	static ArrayList<Integer> ar;
	static String[] str = { "D", "S", "L", "R" };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int test = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(bf.readLine());
			start = st.nextToken();
			end = st.nextToken();
			flag = true;
			int num = 1;
			ar = new ArrayList<>();
			while (true) {
				if (!flag)
					break;
				recur(0, num);
				num++;
			}
			for (int i : ar) {
				System.out.print(str[i]);
			}
			System.out.println();
		}
	}

	static void recur(int cnt, int n) {
		if (flag == false)
			return;
		String temp = start;
		char[] char_ar;
		char[] fortemp;
		if (cnt == n) {
			for (int i = 0; i < ar.size(); i++) {
				switch (ar.get(i)) {
				case 0:
					int D = Integer.parseInt(temp) * 2;
					if (D > 9999)
						D %= 10000;
					temp = String.valueOf(D);
					break;
				case 1:
					int S = Integer.parseInt(temp) - 1;
					if (S == 0)
						S = 9999;
					temp = String.valueOf(S);
					break;
				case 2:
					if (temp.length() == 1)
						continue;
					char_ar = temp.toCharArray();
					fortemp = new char[char_ar.length];
					for (int c = 1; c < char_ar.length; c++)
						fortemp[c - 1] = char_ar[c];
					fortemp[char_ar.length - 1] = char_ar[0];
					temp = String.valueOf(fortemp);
					for (int c = 0; c < temp.length(); c++) {
						if (temp.charAt(c) != '0') {
							temp = temp.substring(c);
							break;
						}
					}
					break;
				case 3:
					if (temp.length() == 1)
						continue;
					char_ar = temp.toCharArray();
					fortemp = new char[char_ar.length];
					for (int c = 0; c < char_ar.length - 1; c++)
						fortemp[c + 1] = char_ar[c];
					fortemp[0] = char_ar[char_ar.length - 1];
					temp = String.valueOf(fortemp);
					for (int c = 0; c < temp.length(); c++) {
						if (temp.charAt(c) != '0') {
							temp = temp.substring(c);
						}
					}
					break;
				}
			}
			if (temp.equals(end))
				flag = false;
			return;
		}
		for (int i = 0; i < 4; i++) {
			ar.add(i);
			recur(cnt + 1, n);
			if (flag == false)
				return;
			ar.remove(ar.size() - 1);
		}
	}
}
