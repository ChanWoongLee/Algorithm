package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2512 {
	static int[] money;
	static int maxMoney;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		money = new int[num];
		int total = 0;
		int max = 0;
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < num; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			max = max < money[i] ? money[i] : max;
			total += money[i];
		}
		st = new StringTokenizer(bf.readLine());
		maxMoney = Integer.parseInt(st.nextToken());

		if (maxMoney > total) {
			System.out.println(max);
		} else {
			binarySearch(max, 0);
		}
	}

	static void binarySearch(int max, int min) {
		System.out.println(max + " " + min);
		if (max < min) {
			System.out.println(min-1);
			System.exit(0);
		}
		
		int mid = (max + min) / 2;
		if (check(mid))
			binarySearch(max, mid+1);
		else
			binarySearch(mid-1, min);
	}

	static boolean check(int mid) {
		int total = 0;
		for (int i = 0; i < money.length; i++) {
			if (mid <= money[i])
				total += mid;
			else
				total += money[i];
		}
		
		if (total <= maxMoney)
			return true;
		else
			return false;
	}
}

