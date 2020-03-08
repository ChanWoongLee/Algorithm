package AlgoStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B1574 {
	static int N;
	static ArrayList<Integer> cup;
	public static void swap(int a, int b) {
		int indexA =cup.indexOf(a);
		int indexB =cup.indexOf(b);
		int save = cup.get(indexA);
		cup.add(indexA, cup.get(indexB));
		cup.add(indexB, save);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cup = new ArrayList();
		cup.add(1); cup.add(2); cup.add(3);
		for(int i = 0; i < N; i++) 
			swap(sc.nextInt(), sc.nextInt());
		System.out.println(cup.get(0));
	}

}
