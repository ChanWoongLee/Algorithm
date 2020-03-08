package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

public class Algospot_ZIM {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Algospot solver = new Algospot();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class Algospot {
	String CurrentPrice;
	char e[];
	int M, N;
	public static int cache[][][] = new int[1 << 15][20][2];
	final int MOD = 1000000007;

	public void solve(int testNumber, Scanner in, PrintWriter out) {
		CurrentPrice = in.next();
		M = in.nextInt();

		N = CurrentPrice.length();
		e = CurrentPrice.toCharArray();
		Arrays.sort(e);
		for (int i = 0; i < cache.length; ++i) {
			for (int j = 0; j < M; ++j) {
				for (int k = 0; k < 2; ++k) {
					cache[i][j][k] = -1;
				}
			}
		}

		int ans = dp(0, 0, 0, 0);
		out.println(ans);
	}

	int dp(final int index, final int used, final int r, final int less) {
		if (index == N) {
			return (r == 0 && less == 1 ? 1 : 0);
		}

		if (cache[used][r][less] != -1)
			return cache[used][r][less];

		cache[used][r][less] = 0;

		for (int next = 0; next < N; ++next) {
			if ((used & (1 << next)) > 0)
				continue;
			if (less == 0 && CurrentPrice.charAt(index) < e[next])
				continue;
			if (next > 0 && e[next - 1] == e[next] && (used & (1 << (next - 1))) == 0)
				continue;

			boolean nextLess = (less == 1) || (CurrentPrice.charAt(index) > e[next]);
			cache[used][r][less] += dp(index + 1, (used | (1 << next)), (r * 10 + e[next] - '0') % M,
					nextLess == true ? 1 : 0);
			cache[used][r][less] %= MOD;
		}

		return cache[used][r][less];
	}
}