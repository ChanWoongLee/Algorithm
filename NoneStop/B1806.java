package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] ar = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = ar[0];
		int min = Integer.MAX_VALUE;
		while (start <= end) {
			if (sum < S) {
				end++;
				if(end == N)
					break;
				sum += ar[end];
			} else if (sum >= S) {
				min = Math.min(min, end - start + 1);
				sum -= ar[start];
				start++;
			}
		}
		if (min == Integer.MAX_VALUE)
			System.out.println("0");
		else
			System.out.println(min);
	}

}
