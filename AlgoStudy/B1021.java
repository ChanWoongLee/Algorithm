package AlgoStudy;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B1021 {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque();
		List<Integer> targetList = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			targetList.add(sc.nextInt());
		}
		
		int index=0;
		int result=0;
		List<Integer> dqDemo;
		while(index!=targetList.size()) {
			int target = targetList.get(index);
			dqDemo = new ArrayList<>(dq);
			int targetPosition = dqDemo.indexOf(target);
			int centerPosition = dq.size()%2 == 0? dq.size()/2-1 : dq.size()/2;
			
			if(targetPosition <= centerPosition) {
				while(dq.peekFirst()!=target) {
					int goLast = dq.pollFirst();
					dq.addLast(goLast);
					result++;
				}
				dq.pollFirst();
			}
			else {
				while(dq.peekLast() != target) {
					int goFirst = dq.pollLast();
					dq.addFirst(goFirst);
					result++;
				}
				int goFirst = dq.pollLast();
				dq.addFirst(goFirst);
				result++;
				dq.pollFirst();
			}
			
			index++;
		}
		System.out.println(result);
	}

}
