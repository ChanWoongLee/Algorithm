package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long max = 1000000000;
		long right = max + 1;
		long left = 0;
		long z = (long) (100 * ((float) y / (float) x));
		if (z >= 99) {
			System.out.println("-1");
			return;
		}
		long ans = 0;
		while (true) {
			if (left > right) {
				break;
			}
			long mid = (left + right) / 2;
			long temp = (100 * (y + mid) / (x + mid));

			if (z >= temp) {
				left = mid + 1;
			} else {
				right = mid;
				ans = mid;
			}
		}
		if (max < right)
			System.out.println("-1");
		else
			System.out.println(ans);
	}
}
