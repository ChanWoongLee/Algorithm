package AlgoStudy;

import java.util.Scanner;

public class B14503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		
		int y = sc.nextInt();
		int direction = sc.nextInt();
		int[][] room = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				room[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		int originDir = direction;
		int dx = 0,dy = 0;
		
		while(true) {
			if (room[x][y] == 0) {
				room[x][y] = 2;
				result++;
				originDir = direction;//원래방향 기억
			}
			
			switch(direction) {
				case 0:
					dx = 0; dy = -1;
					direction = 3;
					break;
				case 1:
					dx = -1; dy = 0;
					direction = 0;
					break;
				case 2:
					dx = 0; dy = 1;
					direction = 1;
					break;
				case 3:
					dx = 1; dy = 0;
					direction = 2;
					break;
			}

			if(room[x+dx][y+dy]==0) { 
					x = x+dx; y = y+dy;//이동
			}
			else if(originDir == direction) {
				switch(direction) {
				case 0:
					dx = 1; dy = 0;
					break;
				case 1:
					dx = 0; dy = -1;
					break;
				case 2:
					dx = -1; dy = 0;
					break;
				case 3:
					dx = 0; dy = 1;
					break;
				}
				if(room[x+dx][y+dy] == 1)
					break;
				else {
					x = x+dx; y = y+dy;
				}
			}
		}
		System.out.println(result);
	}

}
