package SummerCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Cp3 {

	public static void main(String[] args) {
		System.out.println(solution("SEOUL", "DAEGU", "YEOSU", new String[][] {{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}}));
	}

	static ArrayList<Integer>[] ar;

	static public int solution(String depar, String hub, String dest, String[][] roads) {
		HashSet<String> forSize = new HashSet<>();
		for (int i = 0; i < roads.length; i++) {
			forSize.add(roads[i][0]);
			forSize.add(roads[i][1]);
		}
		HashMap<String, Integer> cityInfo = new HashMap<>();
		int num = 0;
		int startNode = 0;
		int middleNode = 0;
		int endNode = 0;
		for (String str : forSize) {
			if (str.equals(depar))
				startNode = num;
			else if (str.equals(hub))
				middleNode = num;
			else if (str.equals(dest))
				endNode = num;

			cityInfo.put(str, num++);
		}
		ar = new ArrayList[forSize.size()];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		int start, end;
		for (int i = 0; i < roads.length; i++) {
			start = cityInfo.get(roads[i][0]);
			end = cityInfo.get(roads[i][1]);
			ar[start].add(end);
		}
		int firstMiddle = dfs(startNode, middleNode);
		int middleLast = dfs(middleNode, endNode);
		return firstMiddle * middleLast;
	}

	static int dfs(int start, int end) {
		if (start == end)
			return 1;
		int ans = 0;
		for (int i = 0; i < ar[start].size(); i++) {
			ans += dfs(ar[start].get(i), end);
		}

		return ans;
	}
}
