package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice6 {
	static Node root = null;

	// https://kim6394.tistory.com/223
	// https://yaboong.github.io/data-structures/2018/02/12/binary-search-tree/
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				Queue<Node> q = new LinkedList();
				q.add(root);
				while (!q.isEmpty()) {
					Node now = q.poll();
					System.out.print(now.value + " ");
					if (now.left != null)
						q.add(now.left);
					if (now.right != null)
						q.add(now.right);
				}
				break;
			}
			if (num > 0) {
				insert(num);
			} else {
				int absNum = num * (-1);
				if (deleteNode(absNum))
					System.out.println(absNum);
				else
					System.out.println("0");

			}

		}
	}

	public static void insert(int key) {

		Node newNode = new Node(key);

		if (root == null) {
			root = newNode;
		} else {
			Node target = root;
			Node parent;

			while (true) {
				parent = target;
				if (key < parent.value) {
					target = parent.left;

					if (target == null) {
						parent.left = newNode;
						return;
					}
				} else {
					target = parent.right;

					if (target == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public static Node findNode(int key) {
		if (root == null)
			return null;

		Node focusNode = root;

		while (focusNode.value != key) {
			if (key < focusNode.value) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
			if (focusNode == null)
				return null;
		}

		return focusNode;
	}

	public static Node getRightMinNode(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node focusNode = rightChildRoot;

		while (focusNode.left != null) {
			parent = focusNode;
			focusNode = focusNode.left;
		}

		parent.left = null;
		return focusNode;
	}

	public static boolean deleteNode(int key) {
		Node focusNode = root;
		Node parent = root;

		boolean isLeftChild = true;

		while (focusNode.value != key) {
			parent = focusNode;

			if (key < focusNode.value) {
				isLeftChild = true;
				focusNode = parent.left;
			} else {
				isLeftChild = false;
				focusNode = parent.right;
			}
			if (focusNode == null) {
				return false;
			}
		}

		Node replacementNode;
		if (focusNode.left == null && focusNode.right == null) {
			if (focusNode == root)
				root = null;
			else if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		} else if (focusNode.right == null) {
			replacementNode = focusNode.left;

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;
		} else if (focusNode.left == null) {
			replacementNode = focusNode.right;
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;
		} else {
			Node rightSubTree = focusNode.right;
			replacementNode = getRightMinNode(focusNode.right);

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;

			replacementNode.right = rightSubTree;
			if (replacementNode == rightSubTree)
				replacementNode.right = null;

			replacementNode.left = focusNode.left;
		}

		return true;
	}
}

class Node {
	int value = -1;
	Node left = null;
	Node right = null;

	public Node(int value) {
		this.value = value;
	}
};