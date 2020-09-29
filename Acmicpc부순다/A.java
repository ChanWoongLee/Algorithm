package AcmicpcºÎ¼ø´Ù;

public class A {
	public static void main(String[] args) {
		System.out.println(solution("abababaa"));

	}
	static public int solution(String S) {
		if (S.contains("aaa"))
			return -1;
		S = S.replaceAll("aa", "A");
		int result = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'a') {
				result++;	
				i++;
			} else if (S.charAt(i) == 'A') {
				i++;
			} else {
				result += 2;
			}
		}
		S = S.replaceAll("a", "A");
		if (S.charAt(S.length() - 1) != 'A')
			result += 2;
		return result;
	}
}
