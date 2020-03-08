package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B14499 {//ť��
	// 09 : 10 ����
	// 10 : 50�� ��   
	// ���� ���ؿ�  Ǯ������ ��� ������ �ʹ� �����ɷȴ�.
	// �� ������ ó�� ť�꿡 ��ȣ�� �� ����� ���⿡ ���� ��ȣ�� �̵�
	// ��ȣ�� ���� value �迭�� ����
	
	// ������ ���� value ĭ�� �ȸ��餷�� �ǰ�
	// �ƶ󿡼��� �迭�� �����ѵ� �װ��� ����ϸ�ȴ�.
	static int[][] map;
	static int[] move;
	static int[] up = { 5, 4, 3, 2, 1, 0 };
	static int[] cube_value = { 0, 0, 0, 0, 0, 0 };
	static int[] cuve_dir = { 0, 1, 2, 3, 4, 5 }; // �Ʒ�0 ��1 ��2 ��3 ��4 ��5
	static int[] dr = { 0, 0, 0, -1, 1 }; // 0 �� �� �� ��
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move = new int[num];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < move.length; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < num; i++) {
			if (!(r + dr[move[i]] >= 0 && r + dr[move[i]] < map.length && c + dc[move[i]] >= 0
					&& c + dc[move[i]] < map[0].length)) {
				continue; // ���� �Ѿ�� ������ continue
			}
			r += dr[move[i]];
			c += dc[move[i]];
			rotate(move[i]);
			if (map[r][c] != 0) {
				cube_value[cuve_dir[0]] = map[r][c];
				map[r][c] = 0;
			}else {
				 map[r][c] = cube_value[cuve_dir[0]] ;
			}
			System.out.println(cube_value[cuve_dir[5]]);
		}
		
	}

	static void rotate(int d) { // 1�� 2�� 3�� 4��
		// ���� �̵��� �Ʒ� -> �� , �� -> �Ʒ� , �� -> �� , �� - > ��, ��->��, �� -> ��
		// ���� �̵��� �Ʒ� -> ��, �� -> ��, �� -> �Ʒ�, �� ->�� , ��->�� , �� -> ��
		// ���� �̵��� �Ʒ� -> ��, �� -> ��, �� -> �� , ��->�� , ��->�Ʒ�, �� - > ��
		// ���� �̵��� �Ʒ� -> ��, �� -> ��, �� ->�� , ��-> �Ʒ� , �� -> �� , �� -> ��
		// �Ʒ�0 ��1 ��2 ��3 ��4 ��5
		int down = cuve_dir[0];
		int east = cuve_dir[1];
		int west = cuve_dir[2];
		int south = cuve_dir[3];
		int north = cuve_dir[4];
		int up = cuve_dir[5];
		//*************** int[] temp = cuve_dir.clone ***************
		//*************** int[] temp = Arrays.copyof(cuve_dir, lengt)*********�� ��ó�� �Ƚᵵ��
		if (d == 1) {
			cuve_dir[0] = west;
			cuve_dir[1] = down;
			cuve_dir[2] = up;
			cuve_dir[3] = south;
			cuve_dir[4] = north;
			cuve_dir[5] = east;
		} else if (d == 2) {
			cuve_dir[0] = east;
			cuve_dir[1] = up;
			cuve_dir[2] = down;
			cuve_dir[3] = south;
			cuve_dir[4] = north;
			cuve_dir[5] = west;

		} else if (d == 3) {
			cuve_dir[0] = south;
			cuve_dir[1] = east;
			cuve_dir[2] = west;
			cuve_dir[3] = up;
			cuve_dir[4] = down;
			cuve_dir[5] = north;
		} else if (d == 4) {
			cuve_dir[0] = north;
			cuve_dir[1] = east;
			cuve_dir[2] = west;
			cuve_dir[3] = down;
			cuve_dir[4] = up;
			cuve_dir[5] = south;
		}
	}

}
