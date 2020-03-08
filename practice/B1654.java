package practice;

import java.util.Scanner;

public class B1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		long n=sc.nextLong();
		long[] line = new long[k];
		long max=0;
		for (int i = 0; i < k; i++) {
			line[i]=sc.nextLong();
			if(max<line[i])
				max=line[i];
		}
		long left=0;
		long right=max;
		
		while(left<=right) {
			long mid = (right+left)/2; 
			if(mid==0) {
				break;
			}
			int count=0;
			for (int j = 0; j < k; j++) {
				count+=(line[j]/mid);// 만약 미드가 영이면 런타임 에러가 남   배열,수식에서 런타임 에러 조심하자!!! 
			}
			
			if(count>=n) {
				left=mid+1;
			}
			else if(count<n) {
				right=mid-1;
			}
			
		}
		
		System.out.println(right);
	}

}
