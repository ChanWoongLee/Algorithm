package Inha;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static int[][] problem1 = { { 1, 2, 3 }, { 0, 4 }, { 0, 4, 5 }, { 0, 5 }, { 1, 2, 6 }, { 2, 3, 6 }, { 4, 5 } };
	static int[][] problem2 = { { 1, 2 }, { 15, 8 }, { 7, 6, 8 }, { 10, 11 }, { 11, 5, 19 }, { 20, 13 }, { 17, },
			{ 1, 3, 8 }, { 18, 13 }, { 10, 4 }, { 3, 6, 7 }, { 0, 4 }, { 11, 19 }, { 12, 18 }, { 9, 3 }, { 4, 1 },
			{ 0, 14 }, { 6, 20 }, { 10, 13 }, { 9, 3 }, { 11, 15 } };
	static Queue<Integer> forStart;
	static boolean[] visit_dfs;

	public static void main(String[] args) {
		ArrayList<Integer>[] ar = new ArrayList[problem1.length];// list로 그래프를 나타낸다.
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList<>();// 초기화 과정
		for (int i = 0; i < problem1.length; i++) {
			for (int j = 0; j < problem1[i].length; j++) {// 위에서 정의해준 그래프를 아래와같이 리스트에 담아준다.
				ar[i].add(problem1[i][j]);
				ar[problem1[i][j]].add(i);
			}
		}
		System.out.println("21페이지 그래프 간선정보");
		System.out.print("BFS: ");
		bfs(ar);// bfs실행
		System.out.print("\nDFS: ");
		forStart = new LinkedList<>();// dfs 를 위한 방문함수
		visit_dfs = new boolean[ar.length];// 시작노드를 담기위한 큐
		dfs(ar, 0);
		System.out.println();
		ar = new ArrayList[problem2.length];
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList<>();
		for (int i = 0; i < problem2.length; i++) {
			for (int j = 0; j < problem2[i].length; j++) {// 위에서 정의해준 그래프를 아래와같이 리스트에 담아준다.
				ar[i].add(problem2[i][j]);
				ar[problem2[i][j]].add(i);
			}
		}
		System.out.println("임의의 노드 그래프 간선정보");
		System.out.print("BFS: ");
		bfs(ar);
		System.out.print("\nDFS: ");
		forStart = new LinkedList<>();// dfs 를 위한 방문함수
		visit_dfs = new boolean[ar.length];// 시작노드를 담기위한 큐
		dfs(ar, 0);
		System.out.println();
	}

	static void bfs(ArrayList<Integer>[] ar) {
		Queue<Integer> q = new LinkedList<Integer>(); // 노드를 담을 q
		forStart = new LinkedList<>();
		q.add(0);// 시작노드를 0 부터 시작한다.
		boolean[] visit = new boolean[ar.length];
		visit[0] = true;// 0을 방문 참
		while (!q.isEmpty()) {// q가 빌때까지 while문을 반복한다.
			int now = q.poll();// q의 바로앞에 꺼를 빼서
			if (!forStart.isEmpty())// 아래구문은 시작노드 출력을 위한 구문이다. 동일한 메커니즘으로 poll해준다.
				// System.out.println(forStart.poll() + " " + now);
				System.out.print("(" + forStart.poll() + "," + now + ") ");

			for (int i = 0; i < ar[now].size(); i++) {// 꺼낸노드의 인접노드들을 하나씩 검사한다.
				int ad = ar[now].get(i);
				if (visit[ad] == false) {// 만약 방문한적이없다면
					q.add(ad); // q에넣어주고 방문처리해준다.
					forStart.add(now);// 시작노드도 넣어둔다.
					visit[ad] = true;
				}
			}
		}
	}

	static void dfs(ArrayList<Integer>[] ar, int node) {
		visit_dfs[node] = true;// 들어온노드를 방문처리한다.
		if (!forStart.isEmpty())
			// System.out.println(forStart.poll() + " " + node);
			System.out.print("(" + forStart.poll() + "," + node + ") ");
		for (int i = 0; i < ar[node].size(); i++) {// 그 노드의 인접한 노드를 불러온다.
			int ad = ar[node].get(i);
			if (visit_dfs[ad] == false) {// 만약 반문한적이없다면
				forStart.add(node);// 시작노드를 출력을 위해넣어주고
				dfs(ar, ad);// recursive함수로 그 인접한노드를 넣어준다.
			}
		}
	}

}

class direct {
	int start, end;

	public direct(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
