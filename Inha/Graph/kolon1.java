package Inha.Graph;

import java.util.Arrays;
import java.util.Collections;

public class kolon1 {

	public static void main(String[] args) {

	}

	static int solution(int[] prices, int[] discounts) {
		Arrays.sort(prices);
		Arrays.sort(discounts);
		int index = discounts.length - 1;
		int result = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (index >= 0) {
				result += (prices[i] - ((prices[i] * discounts[index]) / 100));
			} else if (index < 0) {
				result += prices[i];
			}
			index--;
		}
		return 0;

	}
}
