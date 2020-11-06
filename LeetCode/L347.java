package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class L347 {

	public static void main(String[] args) {
		topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
	}

	static public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int n : nums)
			hash.put(n, hash.getOrDefault(n, 0) + 1);

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hash.get(b) - hash.get(a));
		for (int n : hash.keySet()) {
			pq.add(n);
		}
		ArrayList<Integer> ar = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			ar.add(pq.poll());
		}
		// 람다식 어나니머스식 비교!
		// Collections.sort(ar, new Comparator<Integer>() {
		// public int compare(Integer o1, Integer o2) {
		// return o1 - o2;
		// }
		//
		// });
		// Collections.sort(ar, (a, b) -> a - b);
		int[] res = new int[ar.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = ar.get(i);
		}
		return res;
	}
}
