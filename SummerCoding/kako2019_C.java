package SummerCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class kako2019_C {

	public static void main(String[] args) {

	}

	public int solution(int[] food_times, long k) {
		int answer = 0;
		ArrayList<Food> food = new ArrayList<>();
		for (int i = 0; i < food_times.length; i++) {
			food.add(new Food(food_times[i], i+1));
		}
		Collections.sort(food);
		long stopTime =k;
		for(Food f : food) {
			int minLeftFood = f.leftFood;
			if(k - (minLeftFood * food.size()) > 0) {
				for()
			}
			
		}
		return answer;
	}

	static class Food implements Comparable<Food> {
		int leftFood, index;

		public Food(int leftFood, int index) {
			this.leftFood = leftFood;
			this.index = index;
		}

		@Override
		public int compareTo(Food o) {
			return this.leftFood - o.leftFood;
		}
	}
}
