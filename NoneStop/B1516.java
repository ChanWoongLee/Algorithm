package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516 {
	static ArrayList<Integer>[] ar;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		ar = new ArrayList[N + 1];
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList<>();
		int[] value = new int[N + 1];
		int[] degree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			String[] str = bf.readLine().split(" ");
			value[i] = Integer.parseInt(str[0]);
			for (int j = 1; j < str.length - 1; j++) {
				int friend = Integer.parseInt(str[j]);
				ar[friend].add(i);
				degree[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				q.add(i);
		}
		int[] ans = new int[N + 1];
		int[] dp = new int[N + 1];
		while (!q.isEmpty()) {
			int now = q.poll();
			ans[now] = dp[now] + value[now];
			for (int i = 0; i < ar[now].size(); i++) {
				int friend = ar[now].get(i);
				if (dp[friend] < ans[now])
					dp[friend] = ans[now];
				
				degree[friend]--;
				if (degree[friend] == 0)
					q.add(friend);
			}
		}

		for (int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
