package AlgoStudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1966TryAgain {
	public static class Pare{
		int priori = 0;
		boolean target = false;
		public Pare(boolean n, int p) {
			priori = p;
			target = n;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Pare> dataPare;

		for(int i = 0; i < N; i++) {
			int num=sc.nextInt();
			int tar = sc.nextInt();
			dataPare = new LinkedList();
			ArrayList<Integer> priority = new ArrayList();

			for(int j = 0; j < num; j++) {
				int inputPriori = sc.nextInt();
				if(tar == j) 
					dataPare.add(new Pare(true, inputPriori));
				else
					dataPare.add(new Pare(false, inputPriori));
				priority.add(inputPriori);
			}

			priority.sort((a, b) -> {
				if (a > b)
					return -1;
				else if (a == b)
					return 0;
				else
					return 1;
			});
			int index = 0;
			int result = 0;
			Pare check = new Pare(false,0);
			
			while(true) {
				//if((dataPare.peek().priori == priority.get(index)) && (dataPare.peek().target == true))
				while(dataPare.peek().priori != priority.get(index)) {
					Pare goInput = dataPare.poll();
					dataPare.add(goInput);
				}
				result++;
				if(dataPare.poll().target==true)
					break;
				index++;
			}
			System.out.println(result);
		}
	}
}
