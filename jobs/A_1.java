package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_1 {
	static int[] temp = new int[10];
	static int k;
	static int cnt = 0;
	static boolean finish = false;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		k = Integer.parseInt(st.nextToken());
		dfs(0);
	}

	static void dfs(int n) {
		if(finish)
			return;
		
		if (n == 10) {
			cnt++;
			if (cnt == k) {
				for (int i = 0; i < 10; i++) {
					System.out.print(temp[i] + " ");
				}
				finish= true;
			}
			return;
		}
		for (int i = 1; i <= 4; i++) {
			temp[n] = i;
			dfs(n + 1);
		}
	}
}
