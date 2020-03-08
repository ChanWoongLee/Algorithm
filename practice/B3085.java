package practice;

import java.util.Scanner;

public class B3085 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int N=sc1.nextInt();
		String[][] candy = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				candy[i][j]=sc2.next();
			}
		}
		int candySave1=1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				String saveString=candy[i][j];
				candy[i][j]=candy[i][j+1];
				candy[i][j+1]=saveString;
				int checkCandy = check1(candy,i,j,N);
				if(candySave1<checkCandy)
					candySave1=checkCandy;
				saveString=candy[i][j];
				candy[i][j]=candy[i][j+1];
				candy[i][j+1]=saveString;
			}
		}
		int candySave2=1;
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				String saveString=candy[i][j];
				candy[i][j]=candy[i+1][j];
				candy[i+1][j]=saveString;
				int checkCandy = check2(candy,i,j,N);
				if(candySave1<checkCandy)
					candySave1=checkCandy;
				saveString=candy[i][j];
				candy[i][j]=candy[i+1][j];
				candy[i+1][j]=saveString;
			}
		}
		
		System.out.println(Math.max(candySave1, candySave2));
		
	}
	
	public static int check1(String[][] candy, int x, int y, int N) {
		int candyN=1,line1C=1,line2C=1,line3C=1;
		for (int i = 0; i < N-1; i++) {
			if(candy[i][y]==candy[i+1][y]) {
				candyN++;
				if(candyN>line1C)
					line1C=candyN;
			}
		}
		candyN=1;
		for (int i = 0; i < N-1; i++) {
			if(candy[i][y+1]==candy[i+1][y+1]) {
				candyN++;
				if(candyN>line2C)
					line2C=candyN;
			}
		}
		candyN=1;
		for (int i = 0; i < N-1; i++) {
			if(candy[x][i]==candy[x][i+1]) {
				candyN++;
				if(candyN>line3C)
					line3C=candyN;
			}
		}
		return Math.max(Math.max(line1C, line2C), line3C);
	}
	
	public static int check2(String[][] candy, int x, int y, int N) {
		int candyN=1,line1C=1,line2C=1,line3C=1;
		for (int i = 0; i < N-1; i++) {
			if(candy[x][i]==candy[x][i+1]) {
				candyN++;
				if(candyN>line1C)
					line1C=candyN;
			}
		}
		candyN=1;
		for (int i = 0; i < N-1; i++) {
			if(candy[x+1][i]==candy[x+1][i]) {
				candyN++;
				if(candyN>line2C)
					line2C=candyN;
			}
		}
		candyN=1;
		for (int i = 0; i < N-1; i++) {
			if(candy[i][y]==candy[i+1][y]) {
				candyN++;
				if(candyN>line3C)
					line3C=candyN;
			}
		}
		return Math.max(Math.max(line1C, line2C), line3C);
	}
}
