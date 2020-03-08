package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3752 {
	static int[] num;
	static boolean[] visit;
	static int[] resultA;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			num = new int[size];
			resultA = new int[10001];
			visit = new boolean[size];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			resultA[0] = 1;
			for (int i = 0; i < num.length; i++) {
				for (int j = resultA.length-1; j >= 0; j--) {
					if(resultA[j] == 1) {
						resultA[j+num[i]] = 1;
					}
				}
			}
			for(int i = 0; i< resultA.length; i++) {
				if(resultA[i] == 1)
					result++;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
