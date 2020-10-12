package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hyondae2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] ip = { "7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0" };
		String[] langs = { "C++", "Java", "C#", "C#", "C", "Python3" };
		int[] scores = { 314, 225, 45, 0, 155, 400 };
		int res = solution(ip, langs, scores);
		System.out.println(res);
	}

	static public int solution(String[] ip_addrs, String[] langs, int[] scores) {
		Info[] info = new Info[ip_addrs.length];
		for (int i = 0; i < info.length; i++) {
			if (langs[i].charAt(0) == 'C')
				langs[i] = "C";

			info[i] = new Info(ip_addrs[i], langs[i], scores[i]);
		}
		Arrays.sort(info);
		int result = 0;
		int count = 1;
		for (int i = 0; i < info.length; i++) {
			if (i == info.length - 1) {
				if (!info[i].ip.equals(info[i - 1].ip))
					break;
			} else if (i != info.length - 1 && info[i].ip.equals(info[i + 1].ip)) {
				count++;
				continue;
			}
			if (count == 1) {
				continue;
			}
			if (count == 2) {
				if ((info[i].langs.equals(info[i - 1].langs)) && (info[i].score == info[i - 1].score))
					result += 2;
			} else if (count == 3) {
				if ((info[i].langs.equals(info[i - 1].langs)) && (info[i].langs.equals(info[i - 2].langs)))
					result += 3;
			} else {
				result += count;
			}
			count = 1;
		}
		return ip_addrs.length - result;
	}
}

class Info implements Comparable<Info> {
	String ip = "";
	String langs = "";
	int score = 0;

	public Info(String ip, String langs, int score) {
		this.ip = ip;
		this.langs = langs;
		this.score = score;
	}

	@Override
	public int compareTo(Info arg0) {
		return this.ip.compareTo(arg0.ip);
	}
}