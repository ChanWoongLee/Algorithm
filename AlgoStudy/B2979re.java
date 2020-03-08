package AlgoStudy;

import java.util.Scanner;

public class B2979re {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] money = new int[4];
		money[1] = sc.nextInt();
		money[2] = sc.nextInt();
		money[3] = sc.nextInt();
		int[] time = new int[101];
		int low = 101, max = 0;
		int start, end = 0;
		for (int i = 0; i < 3; i++) {
			start = sc.nextInt();
			end = sc.nextInt() - 1;
			if (max <= end)
				max = end;
			if (low >= start)
				low = start;
			for(int j = start; j <= end; j++) {
				time[j]++;
			}
		}
		int result = 0;
		for (int i = low; i <= max; i++) {
			if(time[i] == 1) 
				result+=money[1];
			else if(time[i] == 2) 
				result+=money[2]*2;
			else 
				result+=money[3]*3;
		}
		System.out.println(result);
	}

}
