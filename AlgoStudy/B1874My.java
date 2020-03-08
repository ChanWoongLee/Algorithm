package AlgoStudy;

import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B1874My {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue<Integer> q = new LinkedList();
		Stack<Integer> stack = new Stack();
		Stack<String> result = new Stack();
		int n=sc.nextInt();

		for(int k=0;k<n;k++){
			int x=sc.nextInt();
			q.add(x);//주어진 어떤 수의열을 list1 스택에 저장
		}
		
		int index = 1;
		while(!q.isEmpty()) {
			int target = q.poll();
			if(target >= index) {
				for(; index <= target; index++) {
					stack.add(index);
					result.add("+");
				}
			}
			else {
				while(stack.peek() != target) {
					if(q.contains(stack.pop())) {
						System.out.println("NO");
						return;
					}
					else
						result.add("-");
				}
			}
			if(stack.peek( )== target) {
				stack.pop();
				result.add("-");
			}
		}
		for(String r : result) {
			System.out.println(r);
		}

	}
}
