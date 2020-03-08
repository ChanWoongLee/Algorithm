package AlgoStudy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Progress_num {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		String answer = "";
		
		String[] num = number.split("");
		ArrayList<String> arListStr = new ArrayList();
		int index = 0;
		for (String n : num) {
			arListStr.add(num[index++]);
		}
		Arrays.sort(num); // 112244775 ·ÎÁ¤·Ä
		String removeList = "";
		for (int i = 0; i < num.length - k; i++) {
			removeList+=num[i];
		}
		int count = 0;
		for(int i = 0; i < number.length(); i++) {
			if(removeList.contains(arListStr.get(i))) {
				arListStr.remove(arListStr.get(i));
				i--;
				count++;
			}
			if(count == k)
				break;
		}
		index = 0;
		for (String str : arListStr) {
			answer += arListStr.get(index++);
		}
		System.out.println(answer);
	}
}
