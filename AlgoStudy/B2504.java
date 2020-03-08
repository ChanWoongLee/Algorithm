package AlgoStudy;

import java.util.Scanner;
import java.util.Stack;

public class B2504 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String line = sc.next();
		char[] lineToChar = line.toCharArray();
		int result=0;
		Stack<Character> stack = new Stack();
		for(int i = 0; i<line.length(); i++) {
			if(lineToChar[i]==')') {
				if(stack.peek()=='(') {
					stack.pop();
					stack.add('2');
				}
				else {
					int n=0;
					while(stack.peek()!='(') {
						n+=Integer.parseInt(String.valueOf(stack.pop()));
					}
					stack.pop();
					stack.add(String.valueOf(n*2).);
				}
			}
			else if(lineToChar[i]==']') {
				if(stack.peek()=='[') {
					stack.pop();
					stack.add('3');
				}
				else {
					int n=0;
					while(stack.peek()!='[') {
						n+=Integer.parseInt(String.valueOf(stack.pop()));
					}
					stack.pop();
					stack.add((char) (n*3));
				}
			}
			else
				stack.add(lineToChar[i]);
		}
		System.out.println(stack.peek());
	}

}
