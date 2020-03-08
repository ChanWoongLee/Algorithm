package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14890 {	
	static int[][] map;
	static boolean[][] load;
	static int RESULT = 0;
	static int N, length;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		length = Integer.parseInt(str[1]);

		load = new boolean[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			checkRow(i);
		}
		load = new boolean[N][N]; // 행열 따로 검사 ,load 초기화해야해서 나눠야됨
		for (int i = 0; i < N; i++) {
			checkCol(i);
		}
		System.out.println(RESULT);

	}

	static void checkRow(int num) {
		int index = 1;
		int height = map[num][0];
		while (index < N ) {
			if (height == map[num][index]) {// 높이가 같을때 다음 인덱스 검사
				index++;
				continue;
			}
			else if (height == map[num][index] - 1) {// 다음 높이가 1 높을때 , 뒤에설치
				if (index - length >= 0) {// 경사로 놓을 수 있는 거리 체크 , 안되면 즉시 break
					for (int i = index - 1; i >= index - length; i--) {
						if (load[num][i] == true || map[num][i] != height) { // 이미 놓여져있거나, 뒤에 높이가 달라질경우
							return;
						}
					}
					for (int i = index - 1; i >= index - length; i--) {
						load[num][i] = true;
					}
					height = map[num][index];
					index++;
				} 
				else
					break;
			}
			else if (height == map[num][index] + 1) {// 다음 높이가 1낮을떄 , 앞에 설지
				if (index + length - 1 < N) {
					for (int i = index; i < index + length; i++) {
						if(load[num][i] == true || map[num][i] != height-1) {// 이미 놓여져있거나, 앞에 높이가 달라질경우
							return;
						}
					}
					for(int i = index; i < index + length; i++) {
						load[num][i] = true;
					}
					index += length; // 앞에 이미 경사로 놓인곳은 검사 생략
					height = map[num][index -1];
				}
				else
					break;
			} 
			else // 높이차이가 1이상일 경우
				break;
		}
		if(index >= N)
			RESULT++;
	}

	static void checkCol(int num) {
		int index = 1;
		int height = map[0][num];
		while (index < N ) {
			if (height == map[index][num]) {// 높이가 같을때 다음 인덱스 검사
				index++;
				continue;
			}
			else if (height == map[index][num] - 1) {// 다음 높이가 1 높을때 , 뒤에설치
				if (index - length >= 0) {// 경사로 놓을 수 있는 거리 체크 , 안되면 즉시 break
					for (int i = index - 1; i >= index - length; i--) {
						if (load[i][num] == true || map[i][num] != height) { // 이미 놓여져있거나, 뒤에 높이가 달라질경우
							return;
						}
					}
					for (int i = index - 1; i >= index - length; i--) {
						load[i][num] = true;
					}
					height = map[index][num];
					index++;
				} 
				else
					break;
			}
			else if (height == map[index][num] + 1) {// 다음 높이가 1낮을떄 , 앞에 설지
				if (index + length - 1 < N) {
					for (int i = index; i < index + length; i++) {
						if(load[i][num] == true || map[i][num] != height-1) {// 이미 놓여져있거나, 앞에 높이가 달라질경우
							return;
						}
					}
					for(int i = index; i < index + length; i++) {
						load[i][num] = true;
					}
					index += length; // 앞에 이미 경사로 놓인곳은 검사 생략
					height = map[index-1][num];
				}
				else
					break;
			} 
			else // 높이차이가 1이상일 경우
				break;
		}
		if(index >= N)
			RESULT++;
	}
}
