package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class F_final {
	static boolean[] visit;
	static ArrayList<Integer>[] student;
	static int[] temp;
	static int[] prob;
	static int cnt = 0;
	static int result;

	// 그래프인줄 알았는데 완전 탐색.... ㄹㅇ 생각 하지도 못했네
	// 붙어있는 정점확인 count로 하는 생각을 못했다. 다녀온 애들 체크한뒤 원하는 인덱스에 체크가 되어있나 다시 확인하려고 했음..
	// 내가 저장하려는 값을 index에 둘수도 있고 value에도 둘수 있음을 기억하자!!!!!!~!!
	// index에 저장하면 value는 1로 길어지면 비효율 임
	// value로 저장하고 싶으면 arraylist에 넣고 contain으로 확인 객체면 확인하기 힘듬
	// 내가 순회?찾고자함? 할때 count를 잘이용하자!!!!!!~!~!
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			int studentAmount = Integer.parseInt(st.nextToken());
			temp = new int[31];
			prob = new int[31];
			result = Integer.MAX_VALUE;
			student = new ArrayList[studentAmount];
			for (int i = 0; i < student.length; i++) {
				student[i] = new ArrayList();
			}
			for (int i = 0; i < studentAmount; i++) {
				st = new StringTokenizer(bf.readLine());
				int problem = Integer.parseInt(st.nextToken());
				prob[i] = problem;
				int friendnum = Integer.parseInt(st.nextToken());
				for (int j = 0; j < friendnum; j++) {
					int friend = st.nextToken().charAt(0) - 65;
					student[i].add(friend);
					student[friend].add(i);
				}
			}

			for (int i = 1; i < studentAmount; i++) {
				sunyel(0, 0, i);
			}
			if(result== Integer.MAX_VALUE)
				System.out.println("#"+t+" "+"-1");
			else
				System.out.println("#"+t+" "+result);
		}

	}

	static void sunyel(int index, int cnt, int goal) {
		if (cnt == goal) {
			if (check(goal)) {
				int Atotal = 0;
				int Btotal = 0;
				for (int i = 0; i < student.length; i++) {
					if (temp[i] == 1)
						Atotal += prob[i];
					else
						Btotal += prob[i];
				}
				int differ = Math.abs(Atotal - Btotal);
				result = result > differ ? differ : result;
			}
			return;
		}
		if (index == student.length)
			return;

		temp[index] = 1;
		sunyel(index + 1, cnt + 1, goal);
		temp[index] = 0;
		sunyel(index + 1, cnt, goal);
	}

	static boolean check(int Ateam) {
		cnt = 0;
		visit = new boolean[31];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1) {
				dfs(i, 1);
				if (cnt != Ateam) {
					return false;
				}
				break;
			}
		}
		cnt = 0;
		visit = new boolean[31];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				dfs(i, 0);
				if (cnt != student.length - Ateam) {
					return false;
				} else {
					return true;
				}
			}
		}
		return true;
	}

	static void dfs(int num, int color) {
		visit[num] = true;
		cnt++;
		for (int i = 0; i < student[num].size(); i++) {
			int target = student[num].get(i);
			if (visit[target])
				continue;
			if (temp[target] != color)
				continue;
			dfs(target, color);
		}
	}
}
