package AlgoStudy;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Character> stack;

		for(int i=0; i<N; i++) {
			String s= sc.next();
			char[] c = s.toCharArray();
			stack = new Stack<>();
			for(int j=0; j<c.length; j++) {
				if(c[j]==')') {
					if ((stack.empty()==true)){
						stack.add(c[j]);
					}
					else if(stack.peek()=='(')
						stack.pop();
				}
				else
					stack.add(c[j]);
			}
			if (stack.empty()==true) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
