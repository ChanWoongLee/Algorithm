package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;

public class S_C {
	static ArrayList<Integer>[] tree;

	static int result = 0;

	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 1, 3 }, { 3, 6 }, { 3, 4 }, { 3, 5 } };
		solution(121, a);
	}

	static public int[] solution(int total_sp, int[][] skills) {
		tree = new ArrayList[skills.length + 2];
		int[] cnt = new int[skills.length + 2];
		for (int i = 0; i < tree.length; i++)
			tree[i] = new ArrayList<>();
		boolean[] second = new boolean[tree.length];
		for (int i = 0; i < skills.length; i++) {
			tree[skills[i][0]].add(skills[i][1]);
			second[skills[i][1]] = true;
		}
		int root = 0;
		for (int i = 1; i < second.length; i++) {
			if (second[i] == false) {
				root = i;
				break;
			}
		}
		recur(root, cnt);
		int sum = 0;
		int[] answer = new int[skills.length + 1];
		for (int i = 1; i < cnt.length; i++) {
			sum += cnt[i];
		}
		total_sp /= sum;
		for (int i = 1; i < cnt.length; i++) {
			answer[i - 1] = total_sp * cnt[i];
		}
		return answer;
	}

	static int recur(int r, int[] cnt) {
		if (tree[r].size() == 0) {
			cnt[r]++;
			return 1;
		}

		int child = 0;
		for (int i = 0; i < tree[r].size(); i++) {
			child += recur(tree[r].get(i), cnt);
		}
		cnt[r] = child;
		return child;
	}
}
