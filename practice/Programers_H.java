package practice;

import java.util.Arrays;

public class Programers_H {

	public static void main(String[] args) {

	}

	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
        int max = 0;
		for (int i = 0; i < citations.length; i++) {
			if (citations.length - citations[i] == citations.length - i+1) {
				if(max < citations[i])
                    max = citations[i];
			}
		}
		return max;
	}
}
