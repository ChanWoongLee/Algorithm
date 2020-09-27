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
		ArrayList<Integer>[] ar = new ArrayList[problem1.length];// list�� �׷����� ��Ÿ����.
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList<>();// �ʱ�ȭ ����
		for (int i = 0; i < problem1.length; i++) {
			for (int j = 0; j < problem1[i].length; j++) {// ������ �������� �׷����� �Ʒ��Ͱ��� ����Ʈ�� ����ش�.
				ar[i].add(problem1[i][j]);
				ar[problem1[i][j]].add(i);
			}
		}
		System.out.println("21������ �׷��� ��������");
		System.out.print("BFS: ");
		bfs(ar);// bfs����
		System.out.print("\nDFS: ");
		forStart = new LinkedList<>();// dfs �� ���� �湮�Լ�
		visit_dfs = new boolean[ar.length];// ���۳�带 ������� ť
		dfs(ar, 0);
		System.out.println();
		ar = new ArrayList[problem2.length];
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList<>();
		for (int i = 0; i < problem2.length; i++) {
			for (int j = 0; j < problem2[i].length; j++) {// ������ �������� �׷����� �Ʒ��Ͱ��� ����Ʈ�� ����ش�.
				ar[i].add(problem2[i][j]);
				ar[problem2[i][j]].add(i);
			}
		}
		System.out.println("������ ��� �׷��� ��������");
		System.out.print("BFS: ");
		bfs(ar);
		System.out.print("\nDFS: ");
		forStart = new LinkedList<>();// dfs �� ���� �湮�Լ�
		visit_dfs = new boolean[ar.length];// ���۳�带 ������� ť
		dfs(ar, 0);
		System.out.println();
	}

	static void bfs(ArrayList<Integer>[] ar) {
		Queue<Integer> q = new LinkedList<Integer>(); // ��带 ���� q
		forStart = new LinkedList<>();
		q.add(0);// ���۳�带 0 ���� �����Ѵ�.
		boolean[] visit = new boolean[ar.length];
		visit[0] = true;// 0�� �湮 ��
		while (!q.isEmpty()) {// q�� �������� while���� �ݺ��Ѵ�.
			int now = q.poll();// q�� �ٷξտ� ���� ����
			if (!forStart.isEmpty())// �Ʒ������� ���۳�� ����� ���� �����̴�. ������ ��Ŀ�������� poll���ش�.
				// System.out.println(forStart.poll() + " " + now);
				System.out.print("(" + forStart.poll() + "," + now + ") ");

			for (int i = 0; i < ar[now].size(); i++) {// ��������� ���������� �ϳ��� �˻��Ѵ�.
				int ad = ar[now].get(i);
				if (visit[ad] == false) {// ���� �湮�����̾��ٸ�
					q.add(ad); // q���־��ְ� �湮ó�����ش�.
					forStart.add(now);// ���۳�嵵 �־�д�.
					visit[ad] = true;
				}
			}
		}
	}

	static void dfs(ArrayList<Integer>[] ar, int node) {
		visit_dfs[node] = true;// ���³�带 �湮ó���Ѵ�.
		if (!forStart.isEmpty())
			// System.out.println(forStart.poll() + " " + node);
			System.out.print("(" + forStart.poll() + "," + node + ") ");
		for (int i = 0; i < ar[node].size(); i++) {// �� ����� ������ ��带 �ҷ��´�.
			int ad = ar[node].get(i);
			if (visit_dfs[ad] == false) {// ���� �ݹ������̾��ٸ�
				forStart.add(node);// ���۳�带 ����� ���س־��ְ�
				dfs(ar, ad);// recursive�Լ��� �� �����ѳ�带 �־��ش�.
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
