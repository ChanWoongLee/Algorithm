package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class L394 {

	public static void main(String[] args) {
		decodeString("3[a]2[bc]");
	}

	static public String decodeString(String s) {
		Stack<String> stack = new Stack<>();
		ArrayList<String> ar = new ArrayList<>();
		for (int i = 0; i <= 9; i++) {
			ar.add(String.valueOf(i));
		}
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty())
				stack.add(s.charAt(i) + "");
			else {
				if (s.charAt(i) == ']') {
					String temp = "";
					String nowPop = "";
					int num = 0;
					while (true) {
						nowPop = stack.pop();
						String toNum = "";
						if (nowPop.equals("[")) {
							while (!stack.isEmpty() && ar.contains(stack.peek())) {
								toNum = stack.pop() + toNum;
							}
							num = Integer.parseInt(toNum);
							break;
						} else
							temp = nowPop + temp;
					}
					String save = "";
					for (int j = 0; j < num; j++) {
						save += temp;
					}
					stack.add(save);
				} else
					stack.add(s.charAt(i) + "");
			}
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		return result;
	}
}
