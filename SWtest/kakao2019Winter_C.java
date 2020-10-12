package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class kakao2019Winter_C {
	// 3:33
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "*rodo", "*rodo", "******" }));
	}

	static String[] userID;
	static Boolean[] userIDCheck;
	static String[] checkBannedID;
	static String[] bannedID;
	static ArrayList<ArrayList<String>> result = new ArrayList<>();
	static public int solution(String[] user_id, String[] banned_id) {
		userID = user_id;
		bannedID = banned_id;
		userIDCheck = new Boolean[user_id.length];
		Arrays.fill(userIDCheck, false);
		checkBannedID = new String[banned_id.length];
		recur(0, banned_id.length);
		return result.size();
	}

	static void recur(int cnt, int maxCnt) {
		if (cnt == maxCnt) {
			for (int i = 0; i < checkBannedID.length; i++) {
				if (bannedID[i].length() != checkBannedID[i].length())
					return;
				String nowBannedID = bannedID[i];
				String nowCheckBannedId = checkBannedID[i];

				for (int j = 0; j < nowBannedID.length(); j++) {
					if (nowBannedID.charAt(j) == '*')
						continue;
					if (nowBannedID.charAt(j) != nowCheckBannedId.charAt(j))
						return;
				}
			}
			ArrayList<String> check = new ArrayList<>(Arrays.asList(checkBannedID));
			for(ArrayList<String> ar : result) {
				if(check.containsAll(ar))
					return;
			}
			result.add(check);
			return;
		}
		for (int i = 0; i < userID.length; i++) {
			if (userIDCheck[i])
				continue;
			userIDCheck[i] = true;
			checkBannedID[cnt] = userID[i];
			recur(cnt + 1, maxCnt);
			userIDCheck[i] = false;
		}

	}
}
