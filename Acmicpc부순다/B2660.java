	package AcmicpcºÎ¼ø´Ù;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	public class B2660 {
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(bf.readLine());
			ArrayList<Integer>[] ar = new ArrayList[N + 1];
			for (int i = 0; i < ar.length; i++)
				ar[i] = new ArrayList<>();
			while (true) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (start == -1)
					break;
				ar[start].add(end);
				ar[end].add(start);
			}
			int[] score = new int[N + 1];
			int min = Integer.MAX_VALUE;
	
			for (int i = 1; i <= N; i++) {
				int depth = -1;
				Queue<Integer> q = new LinkedList<Integer>();
				boolean[] visit = new boolean[N + 1];
				visit[i] = true;
				q.add(i);
				while (!q.isEmpty()) {
					int size = q.size();
					for (int j = 0; j < size; j++) {
						int now = q.poll();
						for (int node : ar[now]) {
							if (visit[node])
								continue;
							visit[node] = true;
							q.add(node);
						}
					}
					depth++;
				}
				score[i] = depth;
				if (min > depth) {
					min = depth;
				}
			}
			ArrayList<Integer> res = new ArrayList<>();
			for (int i = 0; i < score.length; i++) {
				if(min == score[i]) {
					res.add(i);
				}
			}
			System.out.println(min+" "+res.size());
			for(int a:res) {
				System.out.print(a+" ");
			}
	
		}
	
	}
