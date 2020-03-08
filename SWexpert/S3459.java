package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3459 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			long num = Long.parseLong(st.nextToken());// N
			
			System.out.println("#" + test_case + " " + result);
		}
	}

}
