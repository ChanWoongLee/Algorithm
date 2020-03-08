package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1526fail {
	static boolean go = true;
	static int[] num;
	static int[] result;

	public static void minsu(int index) {
		if (index == num.length) {
			for (int n : result)
				System.out.print(n);
			go = false;
			// System.exit(1);
			return;
		}
		if (go) {
			if (num[index] >= 7) {
				if (num[index] == 7) {
				result[index] = 7;
				minsu(++index);
				} else {
					result[index] = 7;
					allseven(++index);
					return;
				}
			} else if (num[index] >= 4) {
				if (num[index] == 4) {
				result[index] = 4;
				minsu(++index);
				} else {
					result[index] = 4;
					allseven(++index);
					return;
				}
			} else {
				if(index == 0){
					result[index] = 0;
					allseven(++index);
				}
				else if((result[index-1] == 4) || (result[index-1]==7)) {
					allseven(index);
					downgrade(--index);
				}
				else {
					allseven(index);
				}
			}
		}
	}

	public static void downgrade(int index) {
		if ((index == 0) && (result[index] == 4)) {
			result[index] = 0;
			return;
		} else if ((index == 0) && (result[index] == 7)) {
			result[index] = 4;
			return;
		}

		if (result[index] == 7) {
			result[index] = 4;
		} else {// 4ÀÏ¶§
			result[index] = 7;
			downgrade(--index);
		}
	}

	public static void allfour(int index) {
		for (int i = index; i < result.length; i++) {
			result[i] = 4;
		}
	}

	public static void allseven(int index) {
		for (int i = index; i < result.length; i++) {
			result[i] = 7;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// String[] charToInteger = bf.readLine().split("");
		// num = new int[charToInteger.length];
		// result = new int[num.length];
		// for(int i = 0; i < num.length; i++) {
		// num[i] = Integer.parseInt(charToInteger[i]);
		// }

		for (int t = 40000; t < 1000000; t++) {
			System.out.print(t + "  ");
			String aa = String.valueOf(t);
			String[] charToInteger = aa.split("");
			num = new int[charToInteger.length];
			result = new int[num.length];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(charToInteger[i]);
			}
			// if(num.length == 1) {
			// int result = (num[0] >= 7)? 7 : 4;
			// System.out.println(result);
			// System.exit(1);
			// }
			minsu(0);
			if(go) {
				for (int i = 0; i < result.length; i++) {
					if (result[i] != 0)
						System.out.print(result[i]);
				}
			}
			System.out.println();
			go = true;
			//Thread.sleep(1);
		}
	}
}
