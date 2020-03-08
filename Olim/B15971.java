package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class B15971 {
	static ArrayList<Node>[] map;
	static boolean[] visit;
	static int start, end, SUM, MAX;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		// 1 부터 num 까지
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		map = new ArrayList[num+1];
		for(int i = 0 ; i < map.length; i ++)
			map[i] = new ArrayList();
		visit = new boolean[num + 1];
		
		for (int i = 0; i < num - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			map[s].add(new Node(e,len));
			map[e].add(new Node(s,len));
		}
		dfs(start,0,0);
		System.out.println(SUM-MAX);
	}

	static void dfs(int n, int sum, int max) {
		visit[n] = true;
		if(n == end) {
			SUM = sum; MAX = max; return;
		}
		for (int i = 0; i < map[n].size(); i++) {
			if (visit[map[n].get(i).end] != true) {
				visit[map[n].get(i).end] = true;
				dfs(map[n].get(i).end, sum + map[n].get(i).len, max < map[n].get(i).len ? map[n].get(i).len : max);
			}
		}
	}
	static class Node{
		int end = 0;
		int len = 0;
		public Node(int e, int l){
			end = e;
			len = l;
		}
	}
}

