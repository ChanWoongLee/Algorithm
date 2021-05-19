package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1759 {
	static StringBuffer stb;
	static int M;
	static ArrayList<String> ar;
	static String[] moum = { "a", "e", "i", "o", "u" };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			String now = st.nextToken();
			ar.add(now);
		}
		Collections.sort(ar);
		stb = new StringBuffer();
		recur(0, 0, n);
	}

	static void recur(int index, int cnt, int max) {
		if (cnt == max) {
			boolean check = false;
			int moCnt = 0;
			for (String mo : moum) {
				if (stb.indexOf(mo) != -1) {
					check = true;
					moCnt++;
				}
			}
			if(stb.length() - moCnt < 2)
				return;
			if (check == false)
				return;
			System.out.println(stb.toString());
			return;
		}
		for (int i = index; i < M; i++) {
			stb.append(ar.get(i));
			recur(i + 1, cnt + 1, max);
			stb.deleteCharAt(stb.length() - 1);
		}
	}
}
