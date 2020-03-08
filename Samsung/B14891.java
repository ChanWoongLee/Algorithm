package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B14891 {
	// 05:08 시작
	static ArrayList<Integer>[] wheel = new ArrayList[4];
	static int[] moveDir;
	static int[] moveWhe;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			wheel[i] = new ArrayList();
		}
		for (int i = 0; i < 4; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < 8; j++) {
				wheel[i].add(Integer.parseInt(str[j]));
			}
		}
		st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		moveDir = new int[num];
		moveWhe = new int[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			moveWhe[i] = Integer.parseInt(st.nextToken());
			moveDir[i] = Integer.parseInt(st.nextToken());
		}
		// 0 ,3 과 1,7 1,3과 2,7 2,3과 3,7
		for (int i = 0; i < num; i++) {
			int nowMD = moveDir[i];
			int nowMW = moveWhe[i] - 1;

			int dir1 = nowMD;
			int dir2 = nowMD;
			for (int index = nowMW; index <= 3; index++) {
				if (index == 3) {
					rotate(index, dir1);
					dir1 = dir1 == -1 ? 1 : -1;
					break;
				}
				if (wheel[index].get(2) == wheel[index + 1].get(6)) {
					rotate(index, dir1);
					break;// 같은경우 회전하고 멈춤
				}
				rotate(index, dir1);
				dir1 = dir1 == -1 ? 1 : -1;
			} // 오늘쪽으로 쭉 검사

			if (nowMD == -1)
				rotate(nowMW, 1);
			else
				rotate(nowMW, -1);

			for (int index = nowMW; index >= 0; index--) {
				if(index == 0) {
					rotate(index, dir2);
					dir2 = dir2 == -1 ? 1 : -1;
					break;
				}
				if (wheel[index].get(6) == wheel[index - 1].get(2)) {
					rotate(index, dir2);
					break;// 같은경우 회전하고 멈춤
				}
				rotate(index, dir2);
				dir2 = dir2 == -1 ? 1 : -1;
			} // 왼쪽으로 쭉 검사
		}
		int result = 0;
		int score = 1;
		for (int i = 0; i < 4; i++) {
			if (wheel[i].get(0) == 1)
				result += score;
			score *= 2;
		}
		System.out.println(result);
	}

	static void rotate(int w, int d) {
		if (d == 1) {
			int[] temp = new int[8];
			for (int i = 0; i < 8; i++) {
				temp[i] = wheel[w].get(i);
			}
			wheel[w].removeAll(wheel[w]);
			wheel[w].add(temp[7]);
			for (int i = 0; i < 7; i++) {
				wheel[w].add(temp[i]);
			}
		} else if (d == -1) {
			int[] temp = new int[8];
			for (int i = 0; i < 8; i++) {
				temp[i] = wheel[w].get(i);
			}
			wheel[w].removeAll(wheel[w]);
			for (int i = 1; i < 8; i++) {
				wheel[w].add(temp[i]);
			}
			wheel[w].add(temp[0]);

		}
	}
}
