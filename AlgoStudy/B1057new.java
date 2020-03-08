package AlgoStudy;

import java.util.Scanner;

public class B1057new {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int kim = sc.nextInt();
		int lim = sc.nextInt();
		
		int result = 0;
		if((people == kim)||(people == lim)) {
			if(people == kim) {
				if(lim % 2 != 0)
					lim++;
				result = kim - lim - 1;
			}
			result = lim - kim -1;
		}
		else {
			if(lim % 2 != 0)
				lim++;
			if(kim % 2 != 0)
				kim++;
			
			result = kim - lim;
			if(result < 0)
				result = -result;
		}
		int count = 0;
		while (true) {
			if (result == 1) {
				break;
			} else {
				result = result / 2;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
