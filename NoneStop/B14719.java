package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {
	static int N, M, FUEL;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] height = new int[M];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
	
		int ans = 0;
		for (int idx = 1; idx < M; idx++) {
			int leftHeight = 0;
			int rightHeight = 0;
			for(int  i = 0 ; i <idx; i++) {
				leftHeight = Math.max(height[i], leftHeight);
			}
			for(int j = idx+1; j < M ;j++) {
				rightHeight = Math.max(height[j], rightHeight);
			}
			int low = Math.min(leftHeight, rightHeight);
			if(low == 0  || low <= height[idx])
				continue;
			ans += low - height[idx];
		}
		System.out.println(ans);
	}

}
