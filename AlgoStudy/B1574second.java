package AlgoStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B1574second {
	static int N;
	//static ArrayList<Integer> cup;
	static int[] cup;
	public static void swap(int a, int b) {
		int save = cup[a];
		cup[a] = cup[b];
		cup[b] = save;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cup =  new int[4];
		cup[1] = 1; cup[2] = 2; cup[3] = 3;
		//cup = new ArrayList();
		//cup.add(1); cup.add(2); cup.add(3);
		for(int i = 0; i < N; i++) 
			swap(sc.nextInt(), sc.nextInt());
		System.out.println(cup[1]);
	}

}
