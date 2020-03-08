package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1204 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int test = Integer.parseInt(st.nextToken());// N
			int[] num = new int[101];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 1000; i++) {
				num[Integer.parseInt(st.nextToken())]++;
			}
			int m = 0;
			int result = -1;
			for(int i = 0; i < 101; i++) {
				if(num[i]>=m) {
					m=num[i];
					result = i;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
