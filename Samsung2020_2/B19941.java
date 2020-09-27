package Samsung2020_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19941 {
	static String[] str;
	static int W;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		str = bf.readLine().split("");
		boolean[] visit = new boolean[str.length];
		recur(visit, 0, 0);
		System.out.println(result);
	}

	static public void recur(boolean[] visit, int idx, int ham) {
		result = result < ham ? ham : result;
		if (idx >= str.length) {
			return;
		}
		if (str[idx].equals("H")) {
			recur(visit, idx + 1, ham);
			return;
		}
		for (int i = idx - W; i <= idx + W; i++) {
			if (i < 0 || i >= str.length || str[i].equals("P") || visit[i])
				continue;
			visit[i] = true;
			recur(visit, idx + 1, ham + 1);
			visit[i] = false;
		}
		recur(visit, idx + 1, ham);
	}
}
