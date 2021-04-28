package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B10800 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] ar = new ArrayList[N + 1];
		ArrayList<Bead> bead = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			ar[num].add(size);
			bead.add(new Bead(num, size, 0));

		}
		for (int i = 0; i < ar.length; i++) {
			Collections.sort(ar[i]);
		}
		// for (int i = 0; i < ar.length; i++) {
		// int sum = 0;
		// for (int j = 0; j < ar[i].size(); j++) {
		// sum += ar[i].get(j);
		// ar[i].set(j, new Bead(ar[, size, partSum))
		// partSum[i][j] = sum;
		// }
		// }
		for (Bead b : bead) {
			int sum = 0;
			for (int i = 1; i < ar.length; i++) {
				if (i == b.num)
					continue;
				if (ar[i].size() == 1) {
					if (ar[i].get(0) < b.size)
						sum += ar[i].get(0);
					continue;
				}
				int start = 0;
				int end = ar[i].size() - 1;
				int mid = 0;
				int target = 0;
				while (start < end) {
					mid = (start + end) / 2;
					target = ar[i].get(mid);
					if (target < b.size) {
						start = mid + 1;
					} else {
						end = mid;
					}
				}
				sum += partSum[i][start];
			}
			System.out.println(sum);
		}
	}

	static class Bead {
		int num, size, partSum;

		public Bead(int num, int size, int partSum) {
			super();
			this.num = num;
			this.size = size;
			this.partSum = partSum;
		}

	}

}
