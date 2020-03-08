package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5658 {
	static String[] num;
	static PriorityQueue<Integer> pq;
	static ArrayList<String> value;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			int K = Integer.parseInt(st.nextToken());// K
			num = new String[size];
			String[] temp = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
			value = new ArrayList(Arrays.asList(temp));
			String[] str = bf.readLine().split("");
			for (int i = 0; i < num.length; i++) {
				num[i] = str[i];
			}
			pq = new PriorityQueue(Collections.reverseOrder());
			int finish = num.length / 4;
			for (int i = 0; i < finish; i++) {
				divide();
				rotate();
			}
			for (int i = 0; i < K - 1; i++) {
				pq.poll();
			}

			System.out.println("#" + test_case + " " + pq.poll());
		}
	}

	static void rotate() {
		Queue<String> q = new LinkedList();
		q.add(num[0]);
		for (int i = 1; i < num.length; i++) {
			q.add(num[i]);
			num[i] = q.poll();
		}
		num[0] = q.poll();
	}

	static void divide() {
		int index = 0;
		int end = num.length / 4;
		String[] save = new String[end];
		for (int i = 0; i < num.length + 1; i++) {
			if (index == end) {
				int temp = cal(save);
				if (!pq.contains(temp))
					pq.add(temp);
				index = 0;
				if(i == num.length)
					break;
			}
			save[index] = num[i];
			index++;
		}
	}

	static int cal(String[] n) {
		int res = 0;
		for (int i = 0; i < n.length; i++) {
			res += Math.pow(16, num.length / 4 - 1 - i) * (value.indexOf(n[i]));
		}
		return res;
	}
}
