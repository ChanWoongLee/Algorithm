package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] someting = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			someting[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(someting);
		int start = 0;
		int end = N - 1;

		int answerA = 0;
		int answerB = 0;
		int nowDiff = 0;
		while (start < end) {
			int sum = someting[start] + someting[end];
			if (nowDiff == 0) {
				nowDiff = sum;
				answerA = someting[start];
				answerB = someting[end];
			}
			if(Math.abs(nowDiff) > Math.abs(sum)) {
				nowDiff = sum;
				answerA = someting[start];
				answerB = someting[end];
			}
			if (sum > 0) {
				end--;
			} else if (sum < 0) {
				
				start++;
			} else {
				System.out.println(answerA + " " + answerB);
				return;
			}
		}
		System.out.println(answerA + " " + answerB);
	}

}
