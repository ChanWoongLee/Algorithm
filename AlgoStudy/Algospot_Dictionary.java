package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import practice.WordSize;

public class Algospot_Dictionary {
	static int[][] adj;
	static ArrayList<Integer> order;
	static boolean visited[]; // ���ڿ� �ߺ� ����� ���� �����ϳ��� �׷������� dfs�Ҷ��� �ʿ����

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());

		while (testcase-- > 0) {
			int wordnum = Integer.parseInt(bf.readLine());
			String[] word = new String[wordnum];
			for (int i = 0; i < wordnum; i++) {
				word[i] = bf.readLine().trim();
			}
			makeGraph(word);
			ArrayList<Integer> result = topologicalSort();

			if (result.isEmpty()) {
				System.out.print("INVALID HYPOTHESIS");
			} else {
				for (int k = 0; k < result.size(); k++) {
					System.out.print(Character.toString((char) (result.get(k) + 'a')));
				}
			}
			System.out.println();
		}

	}

	public static void makeGraph(String[] word) {// array������ ���������� ���� ����׷����� ����!!!!!!!!!!!!!���� �߿�!!!!!!!!!!!
		adj = new int[26][26];
		for (int i = 1; i < word.length; i++) {
			int j = i - 1;
			int len = Math.min(word[i].length(), word[j].length());

			for (int k = 0; k < len; k++) {
				if (word[i].charAt(k) != word[j].charAt(k)) {
					int a = word[j].charAt(k) - 'a';
					int b = word[i].charAt(k) - 'a';
					adj[a][b] = 1; // a���� b�� on
					break;
				}
			}
		}
	}

	public static ArrayList<Integer> topologicalSort() {
		int n = adj.length;
		visited = new boolean[n];
		order = new ArrayList();

		for (int i = 0; i < n; i++) {
			if (!visited[i])
				dfs(i);
		}
		Collections.reverse(order.subList(0, order.size()));
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (adj[order.get(j)][order.get(i)] == 1) {
					return new ArrayList<Integer>();
				}
			}
		}
		return order;

	}

	public static void dfs(int here) {
		visited[here] = true;
		for (int i = 0; i < adj.length; i++) {
			if (adj[here][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		order.add(here);
	}
}