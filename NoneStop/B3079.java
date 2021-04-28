package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3079 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] time = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, time[i]);
		}

		long start = 0;
		long end = max * M;
		long ans = end;
		while (start < end) {
			long mid = (start + end) / 2;
			long person = 0;
			for (int t : time) {
				person += mid / t;
			}

			
			if (person >= M) {
				ans = Math.min(ans, mid);
				end = mid;
			} else {
				start = mid+1;
			}
		}
		System.out.println(ans);
	}

}
