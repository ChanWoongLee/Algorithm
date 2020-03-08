package practice;

import java.util.Scanner;

public class B2850_useBinary {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();//나무개수
		long M = sc.nextLong();// 집에 가져가야하는 나무
		long[] tree = new long[N];
		long max=0;
		for (int i = 0; i <N; i++) {
			tree[i]=sc.nextInt();
			if(max<tree[i])
				max = tree[i];
		}
		long left=0;
		long right=max;
		long ans=0;
	
		
		while(left<=right) {
			long mid = (left+right)/2;
			long sum=0;
			for (int i = 0; i < N; i++) {
				if(mid<tree[i])
					sum+=tree[i]-mid;
			}
			if(sum>=M) {
				if(ans<mid)
					ans=mid;
				left=mid+1;
			}
			else 
				right=mid-1;
				
		}
		System.out.println(ans);
	}

}
