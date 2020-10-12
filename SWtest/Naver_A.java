package SWtest;

public class Naver_A {

	public static void main(String[] args) {
		System.out.println(solution(7, new int[] { 0,0,1,0,0,0,0 }, new int[] { 1,1,1,1,1,1,1 }));
	}

	static public String solution(int n, int[] p, int[] c) {
		int initPrice = 100;
		int left = 0;
		int cnt = 1;
		int price = initPrice;
		int result = 0;
		int day = c.length;
		for (int i = 0; i < c.length; i++) {
			int make = p[i] + left;
			if (cnt == 4) {
				day = i;
				break;
			}
			if (make < c[i]) {
				cnt++;
				left = make;
				price /= 2;
			} else {
				make -= c[i];
				result += price * c[i];
				left = make;
				price = initPrice;
				cnt = 1;
			}
		}
		double res = result / (double) day;
		return String.format("%.2f", res);
	}
}
