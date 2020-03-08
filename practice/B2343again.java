package practice;

import java.util.Scanner;

public class B2343again {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();// 레코드 개수
		int B = sc.nextInt();// 블루레이개수
		long[] rec = new long[N];	
		long max2=0;
		for (int i = 0; i <N; i++) {
			rec[i]=sc.nextLong();
			if(max2<rec[i])
				max2=rec[i];
		}
		long max=0;
		for (int i = 0; i <N; i++) {
			max+=rec[i];
		}
		long left=0; //바이너리 서치의 필수요소  값의 왼쪽
		long right=max;// 값의 오른쪽
		long ans=0;
		while(left<=right) {
			long mid = (right+left)/2; //바이너리서치에서 미드 또한 필수
			int count=1;
			long sum=0;
			for (int j = 0; j < N; j++) {
				if(sum+rec[j]>mid) {
					sum=rec[j];
					count++;
				}
				else
					sum+=rec[j];
			}
			
			if(count<=B) { 
				right= mid-1;
			}
			else {
				left=mid+1;
			}
		}

		System.out.println(left);
	}
}	
