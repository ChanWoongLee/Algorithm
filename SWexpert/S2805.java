package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testcase = Integer.parseInt(st.nextToken());// N
		int test = 0;
		while ((test++)!=testcase) {
			String a ;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			int corp = size / 2;
			int result = 0;
			int change = 0;
			for (int i = 0; i < size; i++) {
				String[] str = bf.readLine().split("");
				for (int j = 0; j < size; j++) {
					if (j >= corp - i -change && j <= corp + i + change)
						result += Integer.parseInt(str[j]);
				}
				if(i >= corp) {
					change -= 2;
				}
			}
			System.out.println("#"+test+" "+result);
		}
	}

}
