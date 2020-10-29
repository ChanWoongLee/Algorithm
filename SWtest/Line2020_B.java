package SWtest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Line2020_B {

	public static void main(String[] args) {
		int[] a = solution(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 6, 2, 5, 1, 4, 3 });
		System.out.println();
	}

	static public int[] solution(int[] ball, int[] order) {
		ArrayList<Integer> ar = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> answerQ = new LinkedList<>();
		Deque<Integer> dq = new LinkedList<>();
		ArrayList<Integer> boru = new ArrayList<>();
		for (int i = 0; i < ball.length; i++) {
			dq.addLast(ball[i]);
		}
		for (int i = 0; i < order.length; i++) {
			int outNunmber = order[i];
			if (dq.peekFirst() == outNunmber) {
				answerQ.add(dq.removeFirst());
				while (dq.size() != 0) {
					int num = dq.peekFirst();
					if (boru.contains(num)) {
						answerQ.add(dq.removeFirst());
						boru.remove((Integer) num);
					} else
						break;
				}
			} else if (dq.peekLast() == outNunmber) {
				answerQ.add(dq.removeLast());
				while (dq.size() != 0) {
					int num = dq.peekLast();
					if (boru.contains(num)) {
						answerQ.add(dq.removeLast());
						boru.remove((Integer) num);
					} else
						break;
				}
			} else {
				boru.add(order[i]);
			}
		}
		int[] answer = new int[answerQ.size()];
		int i = 0;
		for (int a : answerQ) {
			answer[i++] = a;
		}
		Queue<Integer> qq = new LinkedList<>();
		HashMap<Integer, Integer> aa = new HashMap<>();
		LinkedList<Integer> bb = new LinkedList<>();
		String a = "e";
		System.out.println();
		return answer;
	}

}
