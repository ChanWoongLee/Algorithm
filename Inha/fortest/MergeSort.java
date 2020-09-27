package Inha;

import java.util.Arrays;

class item implements Comparable<item> {
	int key;
	String str;

	public item(int key, String str) {
		this.key = key;
		this.str = str;
	}

	@Override
	public int compareTo(item arg0) {
		if (this.key > arg0.key)
			return 1;
		else if (this.key < arg0.key)
			return -1;
		else
			return 0;
	}
}

public class MergeSort {

	public static void main(String[] args) {
		item[] a = new item[6];
		a[0] = new item(4, "a");
		a[1] = new item(4, "b");
		a[2] = new item(6, "c");
		a[3] = new item(2, "d");
		a[4] = new item(1, "e");
		a[5] = new item(3, "f");

//		MergeSort(a, 0, a.length - 1);
//

		Arrays.sort(a);
		for (item i : a) {
		System.out.println(i.key + " " + i.str);
	}
	}

	static void MergeSort(item[] num, int start, int end) {
		if (start == end)
			return;
		int middle = (start + end) / 2;

		MergeSort(num, start, middle);
		MergeSort(num, middle + 1, end);
		Merge(num, start, middle, end);

	}

	static void Merge(item[] num, int start, int middle, int end) {
		item[] save = new item[num.length];
		int i = start;
		int j = middle + 1;
		int index = start;
		while (i <= middle && j <= end) {
			int temp = 0;
			String str;
			if (num[i].key < num[j].key) {
				temp = num[i].key;
				str = num[i].str;
				i++;
			} else {
				temp = num[j].key;
				str = num[j].str;
				j++;
			}

			save[index] = new item(temp, str);
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
}
