package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B10830 {
	static int[][] matrix;
	static int[][] result;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		BigInteger newB = new BigInteger(str[1]);
		matrix = new int[N][N];
		for(int i = 0; i<N; i++) {
			str = bf.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		result = new int[N][N];
		result = divide(newB);
		for(int i = 0 ; i < N; i++) {
			if(i!=0)
				System.out.println();
			for(int j = 0; j < N; j++) {
				System.out.print((result[i][j]%1000)+" ");
			}
		}
	}
	
	static int[][] multiMatrix(int[][] A, int[][] B) {
		int [][] multi = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k<N; k++) {
					multi[i][j] += (A[i][k] * B[k][j])%1000;
				}
			}
		}
		return multi;
	}
	
	static int[][] divide(BigInteger B) {
		if(B.equals(new BigInteger("1"))) 
			return matrix;
		
		if(B.mod(new BigInteger("2")).equals(new BigInteger("0"))) {
			int[][] mat = divide(B.divide(new BigInteger("2")));
			return multiMatrix(mat, mat);
		}
		else
			return multiMatrix(divide(B.subtract(new BigInteger("1"))), matrix);
	}
}
