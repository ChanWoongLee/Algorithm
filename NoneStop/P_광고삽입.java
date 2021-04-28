package NoneStop;

import java.io.BufferedReader;

public class P_±¤°í»ðÀÔ {
	public static void main(String[] args) {
		solution("02:03:55", "00:14:15", new String[] { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29",
				"01:30:59-01:53:29", "01:37:44-02:02:30" });
	}

	static public String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		int[] timeStamp = new int[400000];
		for (int i = 0; i < logs.length; i++) {
			int[] parseTime = toSecond1(logs[i]);
			timeStamp[parseTime[0]]++;
			timeStamp[parseTime[1] + 1]--;
		}
		int playTimeSecond = toSecond2(play_time);
		int advTimeSecond = toSecond2(adv_time);

		for (int i = 1; i <= playTimeSecond; i++) {
			timeStamp[i] += timeStamp[i - 1];
		}

		int save = 0;
		for (int i = 1; i <= advTimeSecond; i++) {
			save += timeStamp[i];
		}
		int max = save;
		int ans = 0;
		for (int i = advTimeSecond + 1; i <= playTimeSecond; i++) {
			save += timeStamp[i];
			save -= timeStamp[i - advTimeSecond];
			if (max < save) {
				max = save;
				ans = i - advTimeSecond - 1;
			}
			System.out.println(save);
		}
		int hour = ans / (60 * 60);
		ans -= hour * 60 * 60;
		int min = ans / 60;
		ans -= min * 60;
		int sec = ans;

		StringBuffer stb = new StringBuffer();
		if (String.valueOf(hour).length() == 1) {
			stb.append(0);
			stb.append(hour);
		} else
			stb.append(hour);
		stb.append(":");
		if (String.valueOf(min).length() == 1) {
			stb.append(0);
			stb.append(min);
		} else
			stb.append(min);
		stb.append(":");
		if (String.valueOf(sec).length() == 1) {
			stb.append(0);
			stb.append(sec);
		} else
			stb.append(sec);
		return stb.toString();
	}

	public static int[] toSecond1(String str) {
		String[] part = str.split("-");
		String[] start = part[0].split(":");
		String[] end = part[1].split(":");
		int startTime = Integer.parseInt(start[0]) * 60 * 60 + Integer.parseInt(start[1]) * 60
				+ Integer.parseInt(start[2]);
		int endTime = Integer.parseInt(end[0]) * 60 * 60 + Integer.parseInt(end[1]) * 60 + Integer.parseInt(end[2]);

		return new int[] { startTime, endTime };
	}

	public static int toSecond2(String str) {
		String[] part = str.split(":");
		int time = Integer.parseInt(part[0]) * 60 * 60 + Integer.parseInt(part[1]) * 60 + Integer.parseInt(part[2]);

		return time;
	}
}
