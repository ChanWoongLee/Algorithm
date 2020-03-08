package Samsung;

import java.util.LinkedList;

public class JOHAB {
	static int n = 3;
	static int c = 2;
	static int temp[];
	static boolean vtemp[];
	static LinkedList<Integer> list = new LinkedList();

	public static void main(String[] args) {
		temp = new int[3];
		vtemp = new boolean[3];
		sunyel(0, 0);
		System.out.println("use for");
		for(int i = 0; i < 3; i++) {
			for(int j =0; j <3; j++) {
				if(i ==j)
					continue;
				System.out.println(i +" "+j );
			}
		}
		System.out.println("--------------------------");
		temp = new int[3];
		vtemp = new boolean[3];
		jungboksunyel(0, 0);
		System.out.println("use for");
		for(int i = 0; i < 3; i++) {
			for(int j =0; j <3; j++) {
				System.out.println(i +" "+j );
			}
		}
		System.out.println("--------------------------");

		temp = new int[3];
		vtemp = new boolean[3];
		johab(0, 0);
		System.out.println("use for");
		for(int i = 0; i <3; i++) {
			for(int j = i+1; j<3; j++) {
				System.out.println(i +" "+j );
			}
		}
		System.out.println("--------------------------");

		temp = new int[3];
		vtemp = new boolean[3];
		jungbokjohab(0, 0);
		System.out.println("use for");
		for(int i = 0; i <3; i++) {
			for(int j = i; j<3; j++) {
				System.out.println(i +" "+j );
			}
		}
		System.out.println("--------------------------");

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
			for (int k : list) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < 3; i++) {
			list.addLast(i);
			sunyel(i, cnt + 1);
			list.removeLast();
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

	static void jungbokjohab(int index, int cnt) {

		if (cnt == 2) {
			for (int k : list) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}
		if (index == 3)
			return;
		list.addLast(index);
		jungbokjohab(index, cnt + 1);
		list.removeLast();
		jungbokjohab(index + 1, cnt);

	}

}
