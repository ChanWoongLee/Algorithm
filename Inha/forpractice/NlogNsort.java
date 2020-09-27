package Inha.forpractice;

public class NlogNsort {

	public static void main(String[] args) {
		int[] num = { 1, 2, 5, 8, 7, 9, 6, 5, 4, 3, 2 };
		maxheap(num);
		for (int a : num)
			System.out.print(a + " ");
		System.out.println();

		int[] num2 = { 1, 2, 5, 8, 7, 9, 6, 5, 4, 3, 2 };
		MergeSort(num2, 0, num2.length - 1);
		for (int a : num2)
			System.out.print(a + " ");
		System.out.println();

		int[] num3 = { 1, 2, 5, 8, 7, 9, 6, 5, 4, 3, 2 };
		QuickSort(num3, 0, num3.length - 1);
		for (int a : num3)
			System.out.print(a + " ");
		System.out.println();
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

	static void MergeSort(int[] num, int start, int end) {
		if (start == end)
			return;
		int middle = (start + end) / 2;

		MergeSort(num, start, middle);
		MergeSort(num, middle + 1, end);
		Merge(num, start, middle, end);

	}

	static void Merge(int[] num, int start, int middle, int end) {
		int[] save = new int[num.length];
		int i = start;
		int j = middle + 1;
		int index = start;
		while (i <= middle && j <= end) {
			int temp = 0;
			if (num[i] < num[j]) {
				temp = num[i];
				i++;
			} else {
				temp = num[j];
				j++;
			}
			save[index] = temp;
			index++;
		}
		if (index != end + 1) {
			if (i <= middle) {
				for (int idx = i; idx <= middle; idx++) {
					save[index] = num[idx];
					index++;
				}
			} else {
				for (int idx = j; idx <= end; idx++) {
					save[index] = num[idx];
					index++;
				}
			}
		}
		for (int idx = start; idx <= end; idx++)
			num[idx] = save[idx];

	}

	// 5, 8, 7, 9, 6, 5, 4, 3, 2
	static void QuickSort(int[] num, int start, int end) {
		if (start >= end)
			return;

		int pivot = end;
		int i = start;
		int j = end - 1;
		while (true) {
			for (; i <= j; i++) {
				if (num[i] < num[pivot])
					break;
			}
			for (; j >= i; j--) {
				if (num[j] > num[pivot])
					break;
			}
			if (i < j) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			} else
				break;
		}
		int temp = num[i];
		num[i] = num[pivot];
		num[pivot] = temp;
		QuickSort(num, start, i - 1);
		QuickSort(num, i + 1, end);
	}
}
