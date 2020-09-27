package SummerCoding;

public class Progrmers_가장_긴_팰린드롬 {

	public static void main(String[] args) {
		System.out.println(solution("abacde"));

	}

	static public int solution(String s) {
		int answer = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (i == 0)
				return 1;
			for (int j = 0; i + j < s.length(); j++) {
				// String part = s.substring(j, i + j + 1);
				if (checkReverse(s, j, i + j))
					return i + 1;
			}
		}
		return answer;
	}

	static boolean checkReverse(String s, int start, int end) {
		// for (int i = 0; i < part.length() / 2 - 1; i++) {
		// if (part.charAt(i) != part.charAt(part.length() - 1 - i))
		// return false;
		// }
		for (int i = 0; i <= (end - start) - 1; i++) {
			if (s.charAt(start + i) != s.charAt(end - i))
				return false;
		}
		return true;
	}
}
