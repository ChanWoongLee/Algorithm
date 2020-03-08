package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 {
	static int N;
	static int[][] paper;
	static StringBuffer sb;
	static int[] paperType;
	public static void divide(int startX, int startY, int length) {
		if(length == 1) {
			if(paper[startX][startY] == -1) {
				paperType[2]++;
			}
			else
				paperType[paper[startX][startY]]++;
			return;
		}
		
		int check = paper[startX][startY];
		boolean allSame = true;
		for (int i = startX; i < startX + length; i++) {
			for (int j = startY; j < startY + length; j++) {
				if (check != paper[i][j]) {
					allSame = false;
					break;
				}
			}
		}
		
		if(allSame) {
			if(check == -1) {
				check = 2;
				paperType[check]++;
			}
			else
				paperType[check]++;
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					divide(startX + (length/3)*i, startY + (length/3)*j, length/3);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] low = null;
		String p = null;
		paper = new int[N][N];
		paperType = new int[3];
		for (int i = 0; i < N; i++) {
			p = br.readLine();
			low = p.split(" ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(low[j]);
			}
		} // 위에는 주어진 종이 데이터 2차배열에 저장
		
		divide(0,0,N);
		System.out.println(paperType[2]);
		System.out.println(paperType[0]);
		System.out.println(paperType[1]);
	}

}
