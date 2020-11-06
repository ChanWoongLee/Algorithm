package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L17 {

	public static void main(String[] args) {

	}

	static String[][] str;
	static String[] temp;
	static ArrayList<String> ar;

	public List<String> letterCombinations(String digits) {
		str = new String[][] { {}, {}, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
		temp = new String[digits.length()];
		ar = new ArrayList<>();
		recur(digits, 0, digits.length());
		return ar;

	}

	static public void recur(String digit, int cnt, int maxCnt) {
		if (maxCnt == cnt) {
			String save = "";
			for (String s : temp) {
				save = s + save;
			}
			ar.add(save);
			return;
		}
		int nowNum = Integer.valueOf(digit.charAt(cnt) + "");
		if (nowNum == 7 || nowNum == 9) {
			for (int i = 0; i < 4; i++) {
				temp[cnt] = str[nowNum][i];
				recur(digit, cnt + 1, maxCnt);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				temp[cnt] = str[nowNum][i];
				recur(digit, cnt + 1, maxCnt);
			}
		}

	}
}
