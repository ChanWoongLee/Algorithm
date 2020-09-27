package jobs;

import java.util.LinkedList;

public class JOHAB {
	static int n = 3;
	static int c = 2;
	static int temp[];
	static boolean vtemp[];
	static LinkedList<Integer> list = new LinkedList();
	static int check[];

	public static void main(String[] args) {
		temp = new int[2];
		vtemp = new boolean[3];

//		sunyel(0, 0);
//		System.out.println("--------------------------");
//		temp = new int[2];
//		check = new int[3];
//		vtemp = new boolean[3];
//		jungboksunyel(0, 0);
//		System.out.println("--------------------------");
//		//
		// temp = new int[3];
		// vtemp = new boolean[3];
		// johab(0, 0);
		// System.out.println("--------------------------");
		//
		// temp = new int[3];
		// vtemp = new boolean[3];
		// jungbokjohab(0, 0);
		// System.out.println("--------------------------");
		//
//		johab2(0, 0);
		boolean[] visit = new boolean[3];
		 all(0, visit);
	}

	static void all(int cnt, boolean[] visit) {
		if (cnt == visit.length) {
			for (boolean b : visit)
				System.out.print(b + " ");
			System.out.println();
			return;
		}
		visit[cnt] = true;
		all(cnt + 1, visit);
		visit[cnt] = false;
		all(cnt + 1, visit);

	}

	static void sunyel(int index, int cnt) {
		if (cnt == 2) {
			for (int k : list) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (vtemp[i] == false) {
				vtemp[i] = true;
				list.addLast(i);
				sunyel(i, cnt + 1);
				list.removeLast();
				vtemp[i] = false;
			}
		}
	}

	static void jungboksunyel(int index, int cnt) {
		if (cnt == 2) {
			for (int k : temp) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < 3; i++) {
			temp[cnt] = i;
			jungboksunyel(i, cnt + 1);

		}
	}

	static void johab(int index, int cnt) {

		if (cnt == 2) {
			for (int i = 0; i < 3; i++) {
				if (vtemp[i] == true)
					System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (index == 3)
			return;
		vtemp[index] = true;
		johab(index + 1, cnt + 1);
		vtemp[index] = false;
		johab(index + 1, cnt);
	}

	static void johab2(int index, int cnt) { // 3 개중에 2개
		if (cnt == 2) {
			for (int i = 0; i < 2; i++)
				System.out.print(temp[i] + " ");
			System.out.println();
			return;
		}
		if (index == 3)
			return;

		for (int i = index; i < 3; i++) {
			temp[cnt] = i;
			johab2(i, cnt + 1);
		}
	}

	static void jungbokjohab(int index, int cnt) {

		if (cnt == 2) {
			for (int k : list) {
				System.out.print(k + " ");
			}
			System.out.println();
			for (int k : check) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}
		if (index == 3)
			return;
		list.addLast(index);
		check[cnt] = index;
		jungbokjohab(index, cnt + 1);
		list.removeLast();
		jungbokjohab(index + 1, cnt);

	}

}
