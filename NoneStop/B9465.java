package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[] line1 = new int[N];
			int[] line2 = new int[N];

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < line1.length; i++) {
				line1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < line2.length; i++) {
				line2[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp1 = new int[N + 1];
			int[] dp2 = new int[N + 1];

			dp1[0] = line1[0];
			dp2[0] = line2[0];

			for (int i = 1; i < N; i++) {
				dp1[i] = Math.max(line1[i] + dp2[i - 1], dp1[i - 1]);
				dp2[i] = Math.max(line2[i] + dp1[i - 1], dp2[i - 1]);
			}
			System.out.println(Math.max(dp1[N - 1], dp2[N - 1]));

		}
	}

}
