package practice;


import java.util.Scanner;

public class B1780 {
	static int[] count = new int[3];
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j]=sc.nextInt();
			}
		}
		div(A,0,0,N);
		System.out.println(count[2]);  // -1로 채워진 종이개수
		System.out.println(count[0]);  // 0으로 채워진 종이개수
		System.out.println(count[1]);  // 1로 채워진 종이개수
	}

	public static void div(int[][] A, int x, int y, int n) {
		int count1=0, count2=0, count3=0;
		if(n==1) {
			if(A[x][y]==0) {
				count[0]++;
				return;
			}
			if(A[x][y]==1) {
				count[1]++;
				return;
			}
			if(A[x][y]==-1) {
				count[2]++;
				return;
			}
		}
		for (int i = x; i < n+x; i++) {
			for (int j = y; j < n+y	; j++) {
				if(A[i][j]==0)
					count1++;
				if(A[i][j]==1)
					count2++;
				if(A[i][j]==-1)
					count3++;
			}
		}
		if(n*n==count1) {
			count[0]++;
			return;
		}
		if(n*n==count2) {
			count[1]++;
			return;
		}
		if(n*n==count3) {
			count[2]++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				div(A,x+i*(n/3),y+j*(n/3),n/3);
			}
		}
		
	}
}
