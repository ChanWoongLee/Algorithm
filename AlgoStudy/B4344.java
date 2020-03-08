package AlgoStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> grade;
		double[] result = new double[N];
		
		for (int i = 0; i < N; i++) {
			int student = sc.nextInt();
			double average=0;
			int averageUpStduent = 0;
			grade = new ArrayList();
			
			for (int j = 0; j < student; j++) {
				grade.add(sc.nextInt());
			}
			for (int g: grade) {
				average+=g;
			}
			average/=student;
			
			grade.sort((a,b)->{
				if(a>b) 
					return -1;
				else if(a==b)
					return 0;
				else
					return 1;
				});
			
			
			for (int g: grade) {
				if(g>average)
					averageUpStduent++;
				else
					break;
			}
			result[i]=((double)averageUpStduent*100)/(double)student;
		}
		
		for(double r : result) {
			System.out.format("%.3f%%\n", r);
		}
	}
}
