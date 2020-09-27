package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int now = 0;
		int result = 0;
		while (true) {
			if (M <= now) {
				now -= num[start++];
			} else if (end == N) {
				break;
			} else {
				now += num[end++];
			}
			if (now == M)
				result++;
		}
		System.out.println(result);
	}

}
