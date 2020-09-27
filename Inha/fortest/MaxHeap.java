package Inha;

public class MaxHeap {

	public static void main(String[] args) {
		int[] abcd = { 1, 6, 8, 9, 4, 3, 4, 4, 5, 6 };
		maxheap(abcd);
		for (int i : abcd)
			System.out.print(i + " ");
	}

	static void maxheap(int[] num) {
		for (int node = num.length - 1; node >= 0; node--) {
			maxheapify(num, node, num.length);
		}
		for (int end = num.length - 1; end > 0; end--) {
			int temp = num[0];
			num[0] = num[end];
			num[end] = temp;
			maxheapify(num, 0, end);
		}
	}

	static void maxheapify(int[] num, int node, int end) {
		if (node * 2 >= end)
			return;

		int target = node * 2;
		if (target + 1 < end) {
			if (num[target] < num[target + 1])
				target += 1;
		}

		if (num[target] > num[node]) {
			int temp = num[target];
			num[target] = num[node];
			num[node] = temp;
			maxheapify(num, target, end);
		}
	}
}
