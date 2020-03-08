package AlgoStudy;
import java.util.Scanner;
import java.util.Stack;
public class B10828 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack();
		
		for(int i=0; i<N; i++){
			String s= sc.next();
			
			if(s.equals("push")) {
				int putNumber = sc.nextInt();
				stack.add(putNumber);
			}
			else if(s.equals("pop")) {
				System.out.println(stack.isEmpty()? -1:stack.pop());
			}
			else if(s.equals("size")) {
				System.out.println(stack.size());
			}
			else if(s.equals("empty")) {
				System.out.println(stack.isEmpty()? 1:0);
			}
			else if(s.equals("top")) {
				System.out.println(stack.isEmpty()? -1: stack.peek());
			}
		}
		
	}

}
