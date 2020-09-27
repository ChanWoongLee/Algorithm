package practice;

public class progrmers_줄서는방법 {

	public static void main(String[] args) {

	}

	static int[] temp;
	static boolean[] visitTemp;
	static int count = 0;
	static boolean finish = false;
	public int[] solution(int n, long k) {
		temp = new int[n];
		visitTemp = new boolean[n];
		recur(0,k);
		return temp;
	}

	static void recur(int cnt, long k) {
		if (cnt == temp.length) {
			count ++;
			if(count == k)
				finish = true;
			return;
		}
		for (int i = 0; i < temp.length; i++) {
			if (visitTemp[i])
				continue;
			temp[cnt] = i + 1;
			visitTemp[i] = true;
			recur(cnt + 1,k);
			if(finish)
				return;
			visitTemp[i] = false;
		}
	}
}
