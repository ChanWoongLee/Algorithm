package practice;

public class Programers_2 {
	public static void main(String[] args) {
		solution("01110");
	}

	static public int[] solution(String s) {
		int zeroCnt = 0;
		int cnt = 0;
		while (!s.equals("1")) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0')
					zeroCnt++;
			}
			s = s.replaceAll("0", "");
			int num = s.length();
			StringBuffer stb = new StringBuffer();
			while (num != 1) {
				stb.insert(0, num % 2);
				num /= 2;
			}
			stb.insert(0, 1);
			s = stb.toString();
			cnt++;
		}
		return new int[] { cnt, zeroCnt };
	}
}
