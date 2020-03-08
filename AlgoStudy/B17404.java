package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17404 {
	static int[][] house;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		house = new int[num][3];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			int temp = house[num - 1][i];
			house[num - 1][i] = 0;
			dfs(0, i, house[0][i]);
			house[num - 1][i] = temp;
		}	
		System.out.println(result);
	}

	static void dfs(int n, int color, int sum) {
		if (house[n][color] == 0)
			return;
		if (result < sum)
			return;
		if (n == house.length - 1) {
			result = result > sum ? sum : result;
			return;
		}
		color = color + 1 >= 3 ? (color + 1) % 3 : color + 1;
		dfs(n + 1, color, sum + house[n + 1][color]);
		color = color + 1 >= 3 ? (color + 1) % 3 : color + 1;
		dfs(n + 1, color, sum + house[n + 1][color]);
	}
}
