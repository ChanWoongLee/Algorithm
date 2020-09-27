package SummerCoding;

import java.util.ArrayList;

public class Summer2019_A {
	static ArrayList<Integer> ar = new ArrayList();

	public static void main(String[] args) {

	}

	public int[] solution(int n) {
		paper root = new paper(0);
		for (int i = 1; i < n; i++) {
			addChild(root);
		}
		visit(root);

		int[] answer = new int[ar.size()];
		for (int i = 0; i < ar.size(); i++) {
			answer[i] = ar.get(i);
		}
		return answer;
	}

	static void addChild(paper root) {
		if (root.left != null) {
			addChild(root.left);
		}
		if (root.right != null) {
			addChild(root.right);
		}
		if (root.left == null && root.right == null) {
			root.left = new paper(0);
			root.right = new paper(1);
		}
	}

	static void visit(paper p) {
		if (p.left != null) {
			visit(p.left);
		}
		ar.add(p.v);
		if (p.right != null) {
			visit(p.right);
		}
	}
}

class paper {
	paper left;
	paper right;
	int v;

	public paper(int v) {
		this.v = v;
	}
}
