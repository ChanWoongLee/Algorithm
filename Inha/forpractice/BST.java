package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BST {
	static int outputIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int testcase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testcase; t++) {
			outputIndex = 0;
			st = new StringTokenizer(bf.readLine());
			int nodecount = Integer.parseInt(st.nextToken());
			int[] input = new int[nodecount];
			int[] output = new int[nodecount];
			int value;
			st = new StringTokenizer(bf.readLine());
			int rootValue = Integer.parseInt(st.nextToken());
			input[0] = rootValue;

			node root = new node();
			root.value = rootValue;

			for (int i = 1; i < nodecount; i++) {
				value = Integer.parseInt(st.nextToken());
				input[i] = value;
				insert(root, value);
			}
			preorder(root, output);
			int count = 0;
			boolean same = true;
			for (int i = 0; i < nodecount; i++) {
				if (input[i] != output[i])
					same = false;
			}
			if (same) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	static void insert(node root, int insertValue) {
		node child = new node();
		child.value = insertValue;
		while (true) {
			if (root.value > insertValue) {
				if (root.left != null)
					root = root.left;
				else {
					root.left = child;
					break;
				}
			} else {
				if (root.right != null)
					root = root.right;
				else {
					root.right = child;
					break;
				}
			}
		}
	}

	static void preorder(node node, int output[]) {
		if (node == null)
			return;

		output[outputIndex] = node.value;
		outputIndex++;

		preorder(node.left, output);
		preorder(node.right, output);
	}
}
//
//class node {
//	int value = -1;
//	node left = null;
//	node right = null;
//};