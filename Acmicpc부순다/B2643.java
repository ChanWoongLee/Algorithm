package AcmicpcºÎ¼ø´Ù;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2643 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		Paper[] papers = new Paper[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w > h) {
				papers[i] = new Paper(w, h);
			} else
				papers[i] = new Paper(h, w);
		}
		Arrays.sort(papers);
		int[] dp = new int[n];
		for (int i = 0; i < papers.length; i++) {
			for (int j = 0; j < i; j++) {
				if (papers[j].w <= papers[i].w && papers[j].h <= papers[i].h) {
					dp[i] = dp[i] < dp[j] ? dp[j] : dp[i];
				}
			}
			dp[i]++;
		}
		Arrays.sort(dp);
		System.out.println(dp[dp.length-1]);
	}

	static class Paper implements Comparable<Paper> {
		int w, h;

		public Paper(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Paper o) {
			if (this.w == o.w)
				return this.h - o.h;
			else
				return this.w - o.w;
		}

	}
}
