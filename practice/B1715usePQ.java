package practice;

import java.util.PriorityQueue;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class B1715usePQ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int N=sc.nextInt();
		for (int i = 0; i < N ; i++) {
			pq.add(sc.nextInt());
		}
		long result = 0;
		for (int i = 1; i < N; i++) {
			int num1= pq.element();
			pq.remove();
			int num2= pq.element();
			pq.remove();
			result+=num1+num2;
			pq.add(num1+num2);
		}
		System.out.println(result);
	}

}
