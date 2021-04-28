package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20366 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] ar = new int[N];
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N - 3; i++) {
			for (int j = i + 3; j < N; j++) {
				int left = i + 1;
				int right = j - 1;
				int standard = ar[i] + ar[j];

				while (left < right) {
					int sum = ar[i] + ar[j] - ar[left] - ar[right];

					if (Math.abs(sum) < ans)
						ans = Math.abs(sum);

					if (sum > 0)
						left++;
					else
						right--;

				}
			}
		}
		System.out.println(ans);

	}

}
