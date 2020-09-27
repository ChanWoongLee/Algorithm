package Inha;

public class Heapsort {

	public static void main(String[] args) {
		int[] num = { 5, 9, 7, 8, 6, 3, 2, 1, 4, 5, 6, 8 };
		maxheap(num);
		for(int a : num) {
			System.out.println(a);
		}
	}

	static void maxheap(int[] num) {
		for (int node = 0; node < num.length; node++) {
			maxheapify(num, node, num.length);
		}
		for (int end = num.length - 1; end > 0; end--) {
			int temp = num[0];
			num[0] = num[end];
			num[end] = temp;
			maxheapify(num, 0, end - 1);
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
