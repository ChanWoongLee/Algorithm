package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B10451 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		while (--testCase >= 0) {
			int n = Integer.parseInt(bf.readLine());
			int[] a = new int[n + 1];
			int count = 0;
			boolean[] check = new boolean[n + 1];
			String[] numString = bf.readLine().split(" ");
			for (int i = 1; i < n + 1; i++) {
				a[i] = Integer.parseInt(numString[i-1]);
			}
			Queue<Integer> q = new LinkedList();
			for (int i = 1; i < n + 1; i++) {
				if (!check[i]) {
					q.add(i);
					check[i] = true;
					while (!q.isEmpty()) {
						int x = q.poll();
						if (!check[a[x]]) {
							check[a[x]] = true;
							q.add(a[x]);
						}
					}
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
