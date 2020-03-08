package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class B1920 {
	static int[] num1;
	static int[] num2;
	static b
	public static void binarySearch(int target, int first, int end) {
		int mid = (end + first)/2; 
		if(num1[mid] == target) 
				return true;
		if(first == end)
				return false;
		
		if(num1[mid] > target)
			binarySearch(target, first, mid-1);
		else
			binarySearch(target, mid+1, end);
		

	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num1 = new int[N];
		for (int i = 0; i < N; i++) {
			num1[i] = sc.nextInt();
		}
		Arrays.sort(num1);
		int M = sc.nextInt();
		num2 = new int[M];
		for (int i = 0; i < M; i++) {
			num2[i] = sc.nextInt();
		}
		
		for (int i = 0; i < M; i++) {
			if(binarySearch(num2[i], 0, N-1))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
