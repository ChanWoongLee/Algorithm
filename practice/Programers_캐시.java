package practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programers_Ä³½Ã {

	public static void main(String[] args) {
	}

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Deque<String> queue = new LinkedList<String>();
		Stack<String> stack = new Stack<>();
		for (String str : cities) {
			str = str.toLowerCase();
			if (queue.contains(str)) {
				while (!queue.peekFirst().equals(str)) {
					stack.add(queue.removeFirst());
				}
				String target = queue.removeFirst();
				while (!stack.isEmpty())
					queue.addFirst(stack.pop());
				queue.add(target);
			} else {
				queue.addFirst(str);
				answer += 5;
				if (queue.size() > cacheSize)
					queue.removeLast();
			}
		}
		return answer;
	}
}
