package AlgoStudy;

import java.util.Scanner;
import java.util.Stack;

public class B2504New {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String line = sc.next();
		int result=0;
		Stack<String> stack = new Stack();
		char[] lineToChar = line.toCharArray();

		for(int i=0; i<line.length(); i++) {
			if(lineToChar[i]==')') {
				if( (stack.empty()) || !stack.contains("(") ) {
					System.out.println("0");
					return;
				}
				else if(stack.peek().equals("(")) {
					stack.pop();
					stack.add("2");
				}
				else {
					int n=0;
					while(!stack.peek().equals("(")) {
						try {
							n+=Integer.parseInt(stack.pop());
						} catch (Exception e) {
							System.out.println("0");
							return;
						}
					}
					stack.pop();
					stack.add(String.valueOf(n*2));
				}
			}
			else if(lineToChar[i]==']') {
				if( (stack.empty()) || !stack.contains("[") ) {
					System.out.println("0");
					return;
				}
				else if(stack.peek().equals("[")) {
					stack.pop();
					stack.add("3");
				}
				else {
					int n=0;
					while(!stack.peek().equals("[")) {
						try {
							n+=Integer.parseInt(stack.pop());
						} catch (Exception e) {
							System.out.println("0");
							return;
						}
					}
					stack.pop();
					stack.add(String.valueOf(n*3));
				}
			}
			else
				stack.add(String.valueOf(lineToChar[i]));
		}

		if(stack.contains("[") || (stack.contains("("))) {
			System.out.println("0");
			return;
		}


		for(String s: stack) {
			result+=Integer.parseInt(s);
		}

		System.out.println(result);

	}
}
