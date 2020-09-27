package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Heap {
	static int[] num;
	static int[] num2;
	static int[] num2_order;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		num = new int[n + 1];
		num2 = new int[n + 1];
		num2_order = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			num2[i] = Integer.parseInt(st.nextToken());
		}
		num2_order = Arrays.copyOf(num2, num2.length);
		heapsort(num2_order);
		ArrayList<Integer> ar = new ArrayList();
		for (int i = 1; i <= n; i++) {
			ar.add(num2_order[i]);
		}

		heapsort(num);
		ArrayList<Integer> ar2 = new ArrayList();
		for (int i = num.length - 1; i > 0; i--) {
			ar2.add(num[i]);
		}
		
		int result = 0;
		for(int i = 0; i < ar.size(); i++) {
			result += ar.get(i) * ar2.get(i);
		}
		System.out.println(result);
	}

	static void heapsort(int[] num) {
		int end = num.length;
		for (int i = end / 2; i >= 1; i--) {
			heapify(num, i, end);
		}
		for (int i = end - 1; i >= 1; i--) {
			int temp = num[1];
			num[1] = num[i];
			num[i] = temp;
			heapify(num, 1, i);
		}
	}

	static void heapify(int[] num, int start, int end) {
		if (start * 2 >= end)
			return;

		int target_index = start * 2;
		if (start * 2 + 1 < end) {
			if (num[start * 2] < num[start * 2 + 1])
				target_index = start * 2 + 1;
		}
		if (num[target_index] >= num[start]) {
			int temp = num[target_index];
			num[target_index] = num[start];
			num[start] = temp;
			heapify(num, target_index, end);
		} else
			return;

	}

}
