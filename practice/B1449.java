package practice;

import java.util.Arrays;
import java.util.Scanner;

public class B1449 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int L=sc.nextInt();
		int[] T = new int[N];
		for (int i = 0; i < N; i++) {
			T[i]=sc.nextInt();
		}
		Arrays.sort(T);
		int tapeCount = 1;
		int index=0;
		int i=0;
		while(true) {
			if(i==N) break;
			else if(T[index]+(L-1)<T[i]) {
				index=i;
				tapeCount++;
			}

			i++;
		}
		System.out.println(tapeCount);

	}
}
