package SummerCoding;

import java.util.*;


public class Cp2 {

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100}));
	}

	static public int solution(int k, int[] score) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] diff = new int[score.length];
		for (int i = 1; i < score.length; i++) {
			diff[i] = score[i - 1] - score[i];
			if (hm.containsKey(diff[i])) {
				hm.put(diff[i], hm.get(diff[i]) + 1);
			} else
				hm.put(diff[i], 1);
		}
		Set<Integer> keySet = hm.keySet();
		ArrayList<Integer> removeList = new ArrayList<>();
		for (int key : keySet) {
			if (hm.get(key) == k)
				removeList.add(key);
		}
		boolean[] trueList = new boolean[score.length];
		Arrays.fill(trueList, true);
		for (int i = 1; i < diff.length; i++) {
			if (removeList.contains(diff[i])) {
				trueList[i] = false;
				trueList[i - 1] = false;
			}
		}
		int answer = 0;
		for(int i = 0; i < trueList.length; i++) {
			if(trueList[i])
				answer++;
		}
		return answer;
	}
}
