package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2477 {
	// 9시 52 분 시작!!
	static int N, M, K, A, B;
	static int[] a;
	static int[] b;
	static int[] come;
	static int[][] res;
	static int[] a_wait, a_waitPerson;
	static int[] b_wait, b_waitPerson;
	static Queue<Integer> a_waitRoom = new LinkedList<Integer>();
	static Queue<Integer> b_waitRoom = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testcase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			res = new int[K][2];
			a = new int[N];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			b = new int[M];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			come = new int[K];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < K; i++) {
				come[i] = Integer.parseInt(st.nextToken());
			}
			int time = 0;
			int person = 0;
			a_wait = new int[N];
			a_waitPerson = new int[N];
			b_wait = new int[M];
			b_waitPerson = new int[M];
			a_waitRoom.clear();
			b_waitRoom.clear();
			int[] check = new int[N];
			while (true) {
				for (; person < come.length; person++) { // 시간에 온사람 창구에 세우기
					if (come[person] == time) {
						if (fill_a(person) == false) // 들어갈 창구 없으면 wait존
							a_waitRoom.add(person);
					} else
						break;
				}
				perform(a_wait, b_wait);

				if (Arrays.equals(a_wait, check) && person >= come.length && b_waitRoom.isEmpty())
					break;
				time++;
			}
			int result = 0;
			for (int i = 0; i < K; i++) {
				if (res[i][0] == A - 1 && res[i][1] == B - 1)
					result += (i + 1);
			}
			result = 0 == result ? -1 : result;
			System.out.println("#" + t + " " + result);
		}

	}

	static boolean fill_b(int person) {
		for (int i = 0; i < b_wait.length; i++) {
			if (b_wait[i] == 0) {
				b_wait[i] = b[i];
				b_waitPerson[i] = person;
				res[person][1] = i;
				return true;
			}
		}
		return false;
	}

	static void perform(int[] a_wait, int[] b_wait) {
		for (int i = 0; i < b_wait.length; i++) {
			if (b_wait[i] != 0) {
				b_wait[i]--;
				if (b_wait[i] == 0) {
					int nextP = b_waitPerson[i];
					b_waitPerson[i] = 0;
					if (!b_waitRoom.isEmpty()) {
						nextP = b_waitRoom.poll();
						b_wait[i] = b[i];
						b_waitPerson[i] = nextP;
						res[nextP][1] = i;
					}
				}
			}
		}
		for (int i = 0; i < a_wait.length; i++) {
			if (a_wait[i] != 0) {
				a_wait[i]--;
				if (a_wait[i] == 0) {
					int nextP = a_waitPerson[i];
					a_waitPerson[i] = 0;
					if (fill_b(nextP) == false)
						b_waitRoom.add(nextP);
					if (!a_waitRoom.isEmpty()) {
						nextP = a_waitRoom.poll();
						a_wait[i] = a[i];
						a_waitPerson[i] = nextP;
						res[nextP][0] = i;
					}
				}
			}
		}
	}

	static boolean fill_a(int person) {
		for (int i = 0; i < a_wait.length; i++) {
			if (a_wait[i] == 0) {
				a_wait[i] = a[i];
				a_waitPerson[i] = person;
				res[person][0] = i;
				return true;
			}
		}
		return false;
	}

}
