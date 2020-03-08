package AlgoStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class B10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] data = new int[N];
		for(int i=0; i < N; i++) {
			data[i]=sc.nextInt();
		}
		ArrayList<Integer> result = new ArrayList();
		for(int i=0; i<N; i++) {
			if(data[i]<X) {
				result.add(data[i]);
			}
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if(i!=result.size()-1) {
				System.out.print(" ");
			}
		}
	}

}
