package AlgoStudy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1966 {
	public static class data{
		int num = 0;
		int prority = 0;
		public data(int n, int p) {
			num = n;
			prority = p;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<data> dataPare;

		for(int i = 0; i < N; i++) {
			int number = sc.nextInt();
			int targetNum = sc.nextInt();
			int targetNumPriori = 0;
			dataPare = new LinkedList();
			ArrayList<Integer> priori = new ArrayList();
			for(int j = 0; j < number; j++) {
				int inputPriori = sc.nextInt();
				dataPare.add(new data(j, inputPriori));
				if(targetNum == j)
					targetNumPriori = inputPriori;
				priori.add(inputPriori);
			}
			priori.sort((a, b) -> {
				if (a > b)
					return -1;
				else if (a == b)
					return 0;
				else
					return 1;
			});
			int index = 0;
			int result = 0;
			data check = new data(0,0);
			while(true) {
				if ((priori.get(index) == targetNumPriori) && (check.num == targetNum))
					break;
				else {
					while(dataPare.peek().prority != priori.get(index)) {
						data goInput = dataPare.poll();
						dataPare.add(goInput);
					}
					check = dataPare.poll();
					result++;
				}
				index++;
			}
			System.out.println(result);

		}
	}

}
