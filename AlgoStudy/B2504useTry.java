package AlgoStudy;

import java.util.Scanner;
import java.util.Stack;

public class B2504useTry {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String line = sc.next();
		int result=0;
		Stack<String> stack = new Stack();
		char[] lineToChar = line.toCharArray();
		
		try {
		for(int i=0; i<line.length(); i++) {
			if(lineToChar[i]==')') {
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.add("2");
				}
				else {
					int n=0;
					while(!stack.peek().equals("(")) {
						n+=Integer.parseInt(stack.pop());
					}
					stack.pop();
					stack.add(String.valueOf(n*2));
				}
			}
			else if(lineToChar[i]==']') {
				if(stack.peek().equals("[")) {
					stack.pop();
					stack.add("3");
				}
				else {
					int n=0;
					while(!stack.peek().equals("[")) {
						n+=Integer.parseInt(stack.pop());
					}
					stack.pop();
					stack.add(String.valueOf(n*3));
				}
			}
			else
				stack.add(String.valueOf(lineToChar[i]));
		}
		
		for(String s: stack) {
			result+=Integer.parseInt(s);
		}
		System.out.println(result);
		}catch (Exception e) {
			System.out.println("0");
			return;
		}
		
	}
}
