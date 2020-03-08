package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1068 {
	static int[][] graph; // graph[a][b] -> a¿¡¼­ b·Î
	static boolean[] visit;
	static int N;
	static int result = 0;
 	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
	
		graph = new int[N][N];
		visit = new boolean[N];
		Queue<Integer> q = new LinkedList();
		str = bf.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			if(!str[i].equals("-1")) 
				graph[Integer.parseInt(str[i])][i] = 1;
			else
				q.add(i);
		}
		str = bf.readLine().split(" ");
		int removeNode = Integer.parseInt(str[0]);
		for(int i = 0; i < N; i ++) {
				graph[removeNode][i] = 0;
				graph[i][removeNode] = -1;
		}
		if(N == 1) {
			System.out.println(0);
			return;
		}

		for(int i = 0; i < q.size(); i++) {
			dfs(q.poll());
		}
		
		System.out.println(result);
 	}
 	static void dfs(int n) {
 		boolean haveChild = false;
 		int noChild = 0;
 		for(int i =0; i < N;i++) {
 			if(graph[n][i]==1 && visit[i]==false) {
 				visit[i] = true;
 				haveChild = true;
 				dfs(i);
 			}
 			else
 				noChild++;
 		}
 		if(noChild == N-1) {
 			return;
 		}
 		if(!haveChild) {
 			result++;
 		}
 	}
 	
}
