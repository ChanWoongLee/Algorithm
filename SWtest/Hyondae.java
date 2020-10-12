package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Hyondae {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

	}

	static public long solution(String[] purchase) {
		int msToday = 24 * 60 * 60 * 1000;
		int[] answer = new int[5];
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date[] date = new Date[purchase.length];
		for (int i = 0; i < purchase.length; i++) {
			String[] str = purchase[i].split(" ");
			int money = Integer.parseInt(str[1]);
			date[i] = (Date) df.parse(str[0].replace("/", ""));
		}
		Date start = (Date) df.parse("20190101");
		Date end = (Date) df.parse("20191231");
		int differ = (int) ((date[0].getTime() - start.getTime()) / msToday);
		answer[0] += differ;
		int nowpoint = 0;
		for (int i = 0; i < purchase.length; i++) {
			differ =(int) ((date[i].getTime() - date[i+1].getTime()) / msToday)
			if( differ< 30) {
				
			}
		}

		return answer;
	}
}
