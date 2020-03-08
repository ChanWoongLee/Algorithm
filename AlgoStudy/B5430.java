package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int i = 0; i < T; i++) {
			String fun = bf.readLine();
			char[] RD = fun.toCharArray();
			int n = Integer.parseInt(bf.readLine());
			String ele = bf.readLine();
			String[] element =ele.substring(1, ele.length()-1).split(",");
			Deque<Integer> dequeue = new LinkedList();
			int index = 0;
			try {
				for(int j = 0; j < element.length; j++) {
					dequeue.add(Integer.parseInt(element[j]));
				}
				boolean reverse = false;
				for(int j = 0; j < RD.length; j++) {
					if(RD[j] == 'R') {
						reverse = reverse ? false : true ;
					}
					else if(dequeue.isEmpty()) {

					}
					else {
						if(reverse)
							dequeue.pollLast();
						else
							dequeue.pollFirst();
					}

				}
			}catch (Exception e) {
				System.out.println("error");
			}
			System.out.print("[");
			for(int k = 0; k < dequeue.size(); k++) {
				System.out.print(dequeue.poll());
				if(k != dequeue.size()-1)
					System.out.print(",");
			}
			System.out.print("]");

		}

	}
}
