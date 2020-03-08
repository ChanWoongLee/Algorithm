package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2979 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] moneyInput = bf.readLine().split(" ");
		int[] money = new int[moneyInput.length];
		for(int i = 0; i < moneyInput.length; i++) {
			money[i] = Integer.parseInt(moneyInput[i]);
		}
		String[] truck1input = bf.readLine().split(" ");
		String[] truck2input = bf.readLine().split(" ");
		String[] truck3input = bf.readLine().split(" ");
		int[] truck1 = new int[2];
		int[] truck2 = new int[2];
		int[] truck3 = new int[2];
		int low, max = 0;
		for(int i = 0; i < 2; i++) {
			truck1[i] = Integer.parseInt(truck1input[i]);
			truck2[i] = Integer.parseInt(truck2input[i]);
			truck3[i] = Integer.parseInt(truck3input[i]);
		}
		
		
		
		
	}

}
