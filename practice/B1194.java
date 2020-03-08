package practice;

import java.util.Scanner;

public class B1194 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		int y= sc.nextInt();
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		int daycount = 1;
		int monthcount = 1;
		int weekcount = 0;
		int month2 = 0;
		
		while(true) {
			while(true) {
				if(weekcount>6)
					weekcount=0;
				if(monthcount==x&&daycount==y)
					break;
				if(daycount==month[month2])
					break;
				daycount++;
				weekcount++;

			}
			if(monthcount==x&&daycount==y)
				break;
			daycount=1;
			weekcount++;
			monthcount++;
			month2++;
			
		}
		System.out.println(day[weekcount]);
	}

}
