package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String mn = bf.readLine();
		String[] MN = mn.split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		Queue<Integer> q = new LinkedList();
		ArrayList<Integer> al = new ArrayList();
		
		for(int i = 0; i < M; i++) {
			q.add(i+1);
		}
		while(!q.isEmpty()) {
			for(int i = 0; i < N-1; i++) {
				int goLast = q.poll();
				q.add(goLast);
			}
			al.add(q.poll());
		}
		System.out.print("<");
		for(int i = 0; i < al.size(); i++) {
			if(i != al.size()-1) 
				System.out.print(al.get(i)+", ");
			else
				System.out.print(al.get(i));
		}
		System.out.print(">");
		
	}
}
