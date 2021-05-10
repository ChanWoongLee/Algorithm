package NoneStop;

import java.util.ArrayList;
import java.util.HashMap;

public class P_다단계_칫솔_판매 {

	public static void main(String[] args) {

	}

	static int[] totalMoney;
	static ArrayList<Integer>[] manyStep;
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int people = enroll.length;
		int totalPeople = enroll.length+1;
		totalMoney = new int[totalPeople];
		manyStep = new ArrayList[totalPeople];
		for (int i = 0; i < totalPeople; i++) {
			manyStep[i] = new ArrayList<>();
		}

		HashMap<String, Integer> strTonum = new HashMap<>();
		strTonum.put("-", 0);
		int num = 1;
		for (int i = 0; i < people; i++) {
			strTonum.put(enroll[i], num);
			manyStep[num].add(strTonum.get(referral[i]));
			num++;
		}

		for (int i = 0; i < seller.length; i++) {
			int now = strTonum.get(seller[i]);
			int nowMoney = amount[i] * 100;
			int tenPercent = 0;
			while (true) {
				tenPercent = (int) (nowMoney / 10);
				totalMoney[now] += nowMoney - tenPercent;
				if (tenPercent == 0)
					break;
				if (now == 0)
					break;
				now = manyStep[now].get(0);
				nowMoney = tenPercent;

			}
		}
		int[] answer = new int[people];
		for(int i = 1; i < totalPeople; i++) {
			answer[i-1] = totalMoney[i];
		}
		return answer;
	}
}
