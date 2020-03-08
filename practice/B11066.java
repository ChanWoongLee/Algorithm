package practice;

import java.util.ArrayList;
import java.util.Scanner;

// 생각 1
//다해봐야한다 -> DP
//DP의 재귀함수의 이미 -> n번째일때의 최소값  
public class B11066 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(;testcase>0;testcase--) {
			int chapter = sc.nextInt();
			ArrayList<Integer> data = new ArrayList();
			for(int i = 0; i < chapter; i++) 
				data.add(sc.nextInt());
			for(int i = 0; i < chapter -1; i++) {
				data.sort((a,b)->{
					if(a>b)
						return 1;
					else if(a<b)
						return -1;
					else
						return 0;
					
				});
				int sum = data.get(0)+data.get(1);
				data.remove(0);data.remove(1);
				data.add(sum);
			}
			System.out.println(data.get(0));
		}
	}
}
