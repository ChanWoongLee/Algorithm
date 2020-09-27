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

	// �׷������� �˾Ҵµ� ���� Ž��.... ���� ���� ������ ���߳�
	// �پ��ִ� ����Ȯ�� count�� �ϴ� ������ ���ߴ�. �ٳ�� �ֵ� üũ�ѵ� ���ϴ� �ε����� üũ�� �Ǿ��ֳ� �ٽ� Ȯ���Ϸ��� ����..
	// ���� �����Ϸ��� ���� index�� �Ѽ��� �ְ� value���� �Ѽ� ������ �������!!!!!!~!!
	// index�� �����ϸ� value�� 1�� ������� ��ȿ�� ��
	// value�� �����ϰ� ������ arraylist�� �ְ� contain���� Ȯ�� ��ü�� Ȯ���ϱ� ����
	// ���� ��ȸ?ã������? �Ҷ� count�� ���̿�����!!!!!!~!~!
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
