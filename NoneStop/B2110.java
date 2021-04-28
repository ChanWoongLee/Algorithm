package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] house = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			house[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(house);
		int start = 1;
		int end = house[N - 1];
		int ans = 0;
		while (start < end) {
			int mid = (start + end) / 2;
			int cnt = 0;
			int nowDir = 0;
			for (int i = 0; i < N; i++) {
				if (i == 0) {
					cnt++;
				} else {
					nowDir += house[i] - house[i - 1];
					if (nowDir >= mid) {
						cnt++;
						nowDir = 0;
					}
				}
			}

			if (cnt < M) {
				end = mid;
			} else if (cnt >= M) {
				ans = Math.max(ans, mid);
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}

}
