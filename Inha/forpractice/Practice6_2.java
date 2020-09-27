package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice6_2 {
	static int[] num = new int[100000];
	static int root = 1;

	// https://kim6394.tistory.com/223
	// https://yaboong.github.io/data-structures/2018/02/12/binary-search-tree/
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int input = Integer.parseInt(st.nextToken());
			if (input == 0) {
				for (int i = 0; i < num.length; i++) {
					if (num[i] == 0)
						continue;
					else
						System.out.print(num[i] + " ");
				}
				break;
			}
			if (input > 0) {
				insert(input);
			} else {
				int absNum = input * (-1);
				if (deleteNode(absNum))
					System.out.println(absNum);
				else
					System.out.println("0");

			}

		}
	}

	public static void insert(int key) {
		if (num[root] == 0) {
			num[root] = key;
			return;
		} else {
			int target = root;
			int parent = 0;

			while (true) {
				parent = target;
				if (key < num[parent]) {
					target = parent * 2;
					if (num[target] == 0) {
						num[target] = key;
						return;
					}
				} else {
					target = parent * 2 + 1;
					if (num[target] == 0) {
						num[target] = key;
						return;
					}
				}
			}
		}
	}

	public static int findNode(int key) {
		if (num[root] == 0)
			return 0;

		int target = root;

		while (num[target] != key) {
			if (key < num[target]) {
				target = target * 2;
			} else {
				target = target * 2 + 1;
			}
			if (num[target] == 0)
				return -1;
		}

		return target;
	}

	public static int getRightMinNode(int rightChild) {
		int parent = rightChild;
		int targetIdx = rightChild;

		while (num[targetIdx] == 0) {
			parent = targetIdx;
			targetIdx = targetIdx * 2;
		}

		return targetIdx;
	}

	public static boolean deleteNode(int key) {
		int targetIdx = findNode(key);

		if (targetIdx == -1)
			return false;
		boolean isLeftChild = false;
		boolean isRightChild = false;

		if (num[targetIdx * 2] != 0)
			isLeftChild = true;
		if (num[targetIdx * 2 + 1] != 0)
			isRightChild = true;

		if (isLeftChild == false && isRightChild == false) {
			num[targetIdx] = 0;
		} else if (isLeftChild == true && isRightChild == true) {
			int replaceIdx = getRightMinNode(targetIdx * 2 + 1);
			num[targetIdx] = num[replaceIdx];
			num[replaceIdx] = 0;
		} else {
			int[] tempArr = new int[num.length];
			int targetChild = 0;
			if (isLeftChild)
				targetChild = targetIdx * 2;
			else
				targetChild = targetIdx * 2 + 1;

			recur(targetIdx, targetChild);
		}
		return true;
	}

	static void recur(int target, int targetChild) {

		num[target] = num[targetChild];
		num[targetChild] = 0;
		if (num[targetChild * 2] != 0) {
			recur(target*2, targetChild * 2);
		}
		if (num[targetChild * 2 + 1] != 0) {
			recur(target*2+1, targetChild * 2 + 1);
		}
	}
}
