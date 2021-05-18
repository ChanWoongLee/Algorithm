package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3665 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int[] rank = new int[n];
			for (int i = 0; i < n; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int i = 0; i < m ; i++) {
				st = new StringTokenizer(bf.readLine());
				
			}
		
		}
	}

}
