package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(bf.readLine());
		}
		heapsort(num, n);
		for (int i = 0; i < n; i++) {
			System.out.println(num[i]);
		}
	}

	static void heapsort(int a[], int length) {
		buildheap(a, length);
		int heapsize, i, temp;
		heapsize = length - 1;
		for (i = heapsize; i >= 0; i--) {
			temp = a[0];
			a[0] = a[heapsize];
			a[heapsize] = temp;
			heapsize--;
			satisfyheap(a, 0, heapsize);
		}

	}

	static void buildheap(int a[], int length) {
		int i, heapsize;
		heapsize = length - 1;
		for (i = (length / 2); i >= 0; i--) {
			satisfyheap(a, i, heapsize);
		}
	}

	static void satisfyheap(int a[], int i, int heapsize) {
		int l, r, largest, temp;
		l = 2 * i;
		r = 2 * i + 1;
		if (l <= heapsize && a[l] > a[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapsize && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			satisfyheap(a, largest, heapsize);
		}
	}
}
