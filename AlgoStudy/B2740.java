package AlgoStudy;

import java.util.Scanner;

public class B2740 {
	public static void main(String[] args) {
		int N,M1,M2,K;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M1 = sc.nextInt();
		int[][] A = new int[N][M1];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M1; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		M2 = sc.nextInt();
		K = sc.nextInt();
		int[][] B = new int[M2][K];
		for(int i = 0; i < M2; i++) {
			for(int j = 0; j < K; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		// 곱특성에 의해 어짜피 M1 = M2 M1만 쓸꺼임
		int[][] result = new int[N][K];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				int index = 0;
				while(index < M1) {
					result[i][j] += A[i][index] * B[index][j];
					index++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				if(j == 0)
					System.out.print(result[i][j]);
				else
					System.out.print(" "+result[i][j]);
			}
			System.out.println();
		}
		
	}
}
