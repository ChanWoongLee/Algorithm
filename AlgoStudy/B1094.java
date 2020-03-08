package AlgoStudy;

import java.util.Scanner;

public class B1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tree = 64;
		int want = sc.nextInt();
		int count = 0;
		if(want == 64) {
			System.out.println("1");
			return;
		}
		while(true) {
			if(tree/2 <= want) {
				tree = tree / 2;
				want = want - tree;
				count ++;
				if(want == 0) 
					break;
			}
			else
				tree = tree / 2;
		}
		System.out.println(count);
	}

}
