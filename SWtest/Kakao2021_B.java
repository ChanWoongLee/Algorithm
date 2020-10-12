package SummerCoding;

import java.util.ArrayList;

public class Kakao2021_B {
	static int[] temp = new int[3];
	static boolean[] visit = new boolean[3];
	static ArrayList<String> ar;
	static String[] oper = { "*", "w+", "-" };
	static long result;

	public static void main(String[] args) {
		String ex = "100-200";
		System.out.println(solution(ex));
		;
	}

	static public long solution(String expression) {
		ar = new ArrayList();
		char[] tochar = expression.toCharArray();
		int zero = '0';
		int nine = '9';
		String str = "";
		result = 0;
		for (int i = 0; i < tochar.length; i++) {
			if (tochar[i] >= zero && tochar[i] <= nine) {
				str += String.valueOf(tochar[i]);
			} else {
				ar.add(str);
				ar.add(String.valueOf(tochar[i]));
				str = "";
			}
		}
		ar.add(str);

		per(0, 0);
		return result;
	}

	static void per(int index, int cnt) {
		if (cnt == 3) {
			for (int i : temp)
				System.out.print(i + " ");
			System.out.println();
			long res = 0;
			ArrayList<String> tempar = new ArrayList();
			for (int i = 0; i < ar.size(); i++) {
				tempar.add(ar.get(i));
			}

			for (int i = 0; i < 3; i++) {
				String nowOper = oper[temp[i]];
				while (tempar.contains(nowOper)) {
					int idx = tempar.indexOf(nowOper);
					long cal = 0;
					if (nowOper.equals("+")) {
						cal = Long.valueOf(tempar.get(idx - 1)) + Long.valueOf(tempar.get(idx + 1));
					} else if (nowOper.equals("*")) {
						cal = Long.valueOf(tempar.get(idx - 1)) * Long.valueOf(tempar.get(idx + 1));
					} else {
						cal = Long.valueOf(tempar.get(idx - 1)) - Long.valueOf(tempar.get(idx + 1));
					}
					tempar.set(idx - 1, String.valueOf(cal));
					tempar.remove(idx);
					tempar.remove(idx);
				}
			}
			res = Math.abs(Long.valueOf(tempar.get(0)));
			result = res > result ? res : result;
			System.out.println(res);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			temp[cnt] = i;
			per(index, cnt + 1);
			visit[i] = false;
		}

	}
}
