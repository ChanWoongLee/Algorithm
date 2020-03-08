package practice;

import java.util.Scanner;

public class B11724useBFS {
	static int[][] graph ;
	static int[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m =sc.nextInt();
		int n =sc.nextInt();
		graph = new int[m+1][m+1];
		visit = new int[m+1];
		for (int i = 0; i < n; i++) {
			int p1 =sc.nextInt();
			int p2 =sc.nextInt();
			graph[p1][p2]=1;
			graph[p2][p1]=1;
		}
		int cnt =0;
		for (int i = 1; i <= m; i++) {
			if(visit[i]==0) {
				bfs(i,m+1);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void bfs(int i, int m) {
		visit[i]=1;
		for (int j = 1; j < m; j++) {
			if (graph[i][j]==1 && visit[j]==0) {
				visit[j]=1;
				bfs(j, m);
			}
		}
	}
}
