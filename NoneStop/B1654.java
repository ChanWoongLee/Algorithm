package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] wood = new int[n];
		long end = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			wood[i] = Integer.parseInt(st.nextToken());
			end = Math.max(wood[i], end);
		}
		long start = 1;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int w : wood)
				sum += w / mid;
			// sum < k 부족하면 end = mid 더자르기
			// sum > k 널널하면 start = mid 덜자르기
			if (sum <= k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);
		long sum = 0;
		for (int w : wood)
			sum += w / 186;
		System.out.println(sum);
	}

}
