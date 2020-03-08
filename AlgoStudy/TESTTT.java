package AlgoStudy;

import java.awt.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class TESTTT {

	public static void main(String[] args) {
		LinkedList<Integer> pq = new LinkedList<Integer>();
		String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };

		for (int i = 0; i < operations.length; i++) {
			if (operations[i].charAt(0) == 'I') {
				String[] num = operations[i].split(" ");
				pq.add(Integer.parseInt(num[1]));
			} else if (operations[i].charAt(0) == 'D') {
				if (!pq.isEmpty()) {
					if (operations[i].charAt(2) == '1') {
						pq.remove(pq.size() - 1);
					} else {
						pq.remove(0);
					}
				}
			}
			Collections.sort(pq, (a, b) -> a.compareTo(b));
		}

		if (pq.isEmpty()) {
			int[] answer = { 0, 0 };
			// return answer;
			System.out.println(answer[0] + answer[1]);
		} else {
			int[] answer = { pq.get(pq.size() - 1), pq.get(0) };
			// return answer;
			System.out.println(answer[0] + " " + answer[1]);
		}
	}

}
