package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Anoher {

	public static void main(String[] args) {
		int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] order = { { 8, 5 }, { 6, 7 }, { 4, 1 } };
		System.out.println(solution(9, path, order));

	}

	static public boolean solution(int n, int[][] path, int[][] order) {
		ArrayList<Integer>[] node = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			node[i] = new ArrayList();
		}
		for (int i = 0; i < path.length; i++) {
			node[path[i][0]].add(path[i][1]);
			node[path[i][1]].add(path[i][0]);
		}

		ArrayList<Integer>[] seq = new ArrayList[n];
		for (int i = 0; i < seq.length; i++) {
			seq[i] = new ArrayList();
		}
		boolean[] LockNode = new boolean[n];
		for (int i = 0; i < order.length; i++) {
			seq[order[i][0]].add(order[i][1]);
			LockNode[order[i][1]] = true;
		}
		boolean[] visit = new boolean[n];
		int now = 0;
		visit[now] = true;
		Queue<Integer> q = new LinkedList();
		q.add(0);
		while (!q.isEmpty()) {
			now = q.poll();
			for (int i = 0; i < node[now].size(); i++) {
				int child = node[now].get(i);
				if (visit[child] || LockNode[child])
					continue;

				if (seq[child].size() != 0) {
					LockNode[seq[child].get(0)] = false;
					visit = new boolean[n];
					seq[child].remove(0);
				}
				visit[child] = true;
				q.add(child);
			}
		}

		boolean[] allTrue = new boolean[visit.length];
		Arrays.fill(allTrue, true);
		if (Arrays.equals(allTrue, visit))
			return true;
		return false;
	}

}
