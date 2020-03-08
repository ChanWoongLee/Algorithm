package practice;

import java.util.Scanner;

public class WordSize {

	public static void main(String[] args) {
		Scanner word = new Scanner(System.in);
		String w = word.nextLine();
		int count = 0;
		char w2 = ' ';
		for (int i = 0; i < w.length(); i++) {
			if(w.charAt(i)==w2)
				count++;
		}
		if(w.charAt(0)==w2)
			count--;
		if(w.charAt(w.length()-1)==w2)
			count--;
		System.out.println(count+1);

	}
}
