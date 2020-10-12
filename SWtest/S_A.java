package SummerCoding;

public class S_A {

	public static void main(String[] args) {

	}

	public int solution(int p) {
		while (true) {
			p += 1;
			boolean[] year = new boolean[10];
			String[] str = String.valueOf(p).split("");
			boolean flag = true;
			for (int i = 0; i < str.length; i++) {
				if (year[Integer.parseInt(str[i])]) {
					flag = false;
					break;
				} else
					year[Integer.parseInt(str[i])] = true;
			}
			if(flag)
				return p;
		}

	}

}
