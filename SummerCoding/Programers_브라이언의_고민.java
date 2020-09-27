package SummerCoding;

import java.util.ArrayList;

public class Programers_브라이언의_고민 {

	public static void main(String[] args) {
		System.out.println(solution("aAa"));
	}

	static boolean INVALID = false;
	static ArrayList<Character> special;

	static public String solution(String sentence) {
		special = new ArrayList<>();
		String answer = recur(sentence);
		if (INVALID)
			return "invalid";
		else
			return answer;
	}

	static public String recur(String sent) {
		int specialCnt = 0;
		for (int i = 0; i < sent.length(); i++) {
			if (sent.charAt(i) >= 'a' && sent.charAt(i) <= 'z') {
				specialCnt++;
			}
		}

		if (sent.charAt(0) >= 'a' && sent.charAt(0) <= 'z') { // 2번확인
			if (special.contains(sent.charAt(0))) {
				INVALID = true;
				return null;
			}
			int cnt = 0;
			int index = 0;
			for (int i = 0; i < sent.length(); i++) {
				if (sent.charAt(0) == sent.charAt(i)) {
					cnt++;
					index = i;
				}
			}
			if (cnt != 2) {
				INVALID = true;
				return null;
			}
			special.add(sent.charAt(0));
			return recur(sent.substring(1, index)) + " " + recur(sent.substring(index + 1, sent.length()));
		} else if (sent.charAt(1) >= 'a' && sent.charAt(1) <= 'z') {
			if (special.contains(sent.charAt(2))) {
				INVALID = true;
				return null;
			}
			int index = sent.length() - 1;
			for (int i = 1; i < sent.length(); i += 2) {
				if (sent.charAt(i) != sent.charAt(1)) {
					index = i - 1;
					break;
				}
			}
			special.add(sent.charAt(1));
			return recur(sent.substring(0, index + 1).replaceAll(String.valueOf(sent.charAt(1)), "")) + " "
					+ recur(sent.substring(index + 1, sent.length()));
		}
		INVALID = true;
		return null;
	}
}
