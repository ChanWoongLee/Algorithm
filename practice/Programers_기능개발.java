package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programers_기능개발 {

	public static void main(String[] args) {
		solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
	}

	static public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int[] finish = new int[progresses.length];
		int day = 1;
		boolean hundred = false;
		while (!hundred) {
			boolean checkFinish = true;
			for (int i = 0; i < progresses.length; i++) {
				if (progresses[i] >= 100)
					continue;
				checkFinish = false;
				progresses[i] += speeds[i];
				if (progresses[i] >= 100)
					finish[i] = day;
			}
			if (checkFinish)
				break;
			day++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < finish.length; i++) {
			if (q.isEmpty())
				q.add(finish[i]);
			else {
				if (q.peek() < finish[i]) {
					ar.add(q.size());
					q.clear();
					ar.add(finish[i]);
				} else {
					q.add(finish[i]);
				}
			}
		}
		if (!q.isEmpty())
			ar.add(q.size());
		int[] result = new int[ar.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = ar.get(i);
		}
		return result;
	}
}
