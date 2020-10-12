package SummerCoding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cp4 {

	public static void main(String[] args) throws ParseException {
		System.out.println(solution(3,
				new String[] { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
						"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" }));
	}

	static public int solution(int n, String[] customers) throws ParseException {
		Calendar[] kioskTime = new Calendar[n];
		int[] kioskNum = new int[n];
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd HH:mm:ss");
		Date date;
		Calendar now = Calendar.getInstance();
		for (int i = 0; i < customers.length; i++) {
			String[] str = customers[i].split(" ");
			date = formatter.parse(str[0] + " " + str[1]);
			now.setTime(date);
			int time = Integer.parseInt(str[2]);
			Calendar minKioskTime = Calendar.getInstance();
			date = minKioskTime.getTime();
			int minKioskNum = 0;
			Calendar minKioskTime2 = Calendar.getInstance();
			int minKioskNum2 = 0;
			boolean allUse = true;
			for (int j = 0; j < n; j++) {
				if (kioskTime[j] == null) {
					minKioskTime.setTime(now.getTime());
					minKioskNum = j;
					minKioskTime2.setTime(now.getTime());
					minKioskNum2 = j;
					break;
				}
				if (now.after(kioskTime[j])) {
					if (minKioskTime.getTime() == date || minKioskTime.after(kioskTime[j])) {
						minKioskTime.setTime(kioskTime[j].getTime());
						minKioskNum = j;
						allUse = false;
					}
				} else {
					//System.out.println(minKioskTime2.getTime());
					//System.out.println(kioskTime[j].getTime());
					if (minKioskTime2.getTime() == date || minKioskTime2.after(kioskTime[j])) {
						minKioskTime2.setTime(kioskTime[j].getTime());
						minKioskNum2 = j;
					}
				}
			}
			minKioskTime2.add(Calendar.MINUTE, time);
			minKioskTime.add(Calendar.MINUTE, time);
			if (allUse) {
				kioskTime[minKioskNum] = minKioskTime;
				kioskNum[minKioskNum]++;
			} else {
				kioskTime[minKioskNum2] = minKioskTime2;
				kioskNum[minKioskNum2]++;
			}
			for(int k = 0; k < kioskTime.length; k++) {
				if(kioskTime[k] != null)
				System.out.println(kioskTime[k].getTime());
			}
			System.out.println("----------");
		}
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < kioskNum.length; i++) {
			if (kioskNum[i] > max) {
				max = kioskNum[i];
				maxIndex = i;
			}
		}
		return max;

	}
}
