package NoneStop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Line_2021_2 {

	public static void main(String[] args) {
		int [] a = solution("UUUUU");
		System.out.println(a);
		
	}

	static public int[] solution(String inp_str) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (inp_str.length() < 8 || inp_str.length() > 15)
			ans.add(1);

		int[] pos = new int[1000];
		posCheck('a' - '!', 'z' - '!', 1, pos);
		posCheck('A' - '!', 'Z' - '!',  2, pos);
		posCheck('0' - '!', '9' - '!',  3, pos);
		String[] str = "~!@#$%^&*".split("");
		for (String s : str) {
			pos[s.charAt(0)-'!'] = 4;
		}
		Set<Integer> set = new HashSet<>();
		int[] cnt = new int[1000];
		boolean oneTime = false;
		for (int i = 0; i < inp_str.length(); i++) {
			int state = pos[inp_str.charAt(i) - '!'];
			cnt[inp_str.charAt(i) - '!']++;
			if (state == 0 && !oneTime) {
				ans.add(2);
				oneTime = true;
			} else {
				set.add(state);
			}
		}
		if (set.size() < 3)
			ans.add(3);

		for (int i = 0; i < inp_str.length() - 3; i++) {
			char now = inp_str.charAt(i);
			boolean dup = true;
			for (int j = i; j < i + 4; j++) {
				if (now != inp_str.charAt(j)) {
					dup = false;
					continue;
				}
			}
			if(dup) {
				ans.add(4);
				break;
			}
		}

		for (int i : cnt) {
			if (i >= 5) {
				ans.add(5);
				break;
			}
		}
		if(ans.size() ==0)
			return new int[] {0};
		else {
			int[] answer = new int[ans.size()];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = ans.get(i);
			}
			return answer;
		}
	}

	static void posCheck(int start, int end, int num, int[] pos) {
		for (int i = start; i <= end; i++) {
			pos[i] = num;
		}
	}
}
