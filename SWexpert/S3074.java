package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]); // 심사대 수
			int M = Integer.parseInt(tmp[1]); // 사람수
			int[] times = new int[N];
			int max = 0;
			for (int j = 0; j < N; j++) {
				times[j] = Integer.parseInt(br.readLine());
				max = Math.max(max, times[j]);
			}

			long left = 1;
			long right = max * (long) M;
			long total = 0, mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				total = 0;
				for (int k = 0; k < N; k++)
					total += mid / times[k];
				if (total < M)
					left = mid + 1;
				else
					right = mid - 1;
			}
			System.out.println("#" + i + " " + left);
		}
	}
}