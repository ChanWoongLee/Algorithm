package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class NewNumber {

	public static void main(String[] args) {
		Scanner T = new Scanner(System.in);
		Scanner TT = new Scanner(System.in);
		Scanner TTT = new Scanner(System.in);
		String newString = ""; 
		
		int t= T.nextInt();
		
		LinkedList st = new LinkedList();
		LinkedList nu = new LinkedList();
		
		for (int i = 0; i < t; i++) {
			nu.add(i,TTT.nextInt());
			st.add(i,TT.nextLine());
		}
		st.toString();
		for (int j = 0; j < nu.size(); j++) {
			for (int i = 0; i < String.valueOf(st.get(j)).length(); i++) {
				for (int k = 0; k < (int)nu.get(j) ; k++) {
					newString = newString + String.valueOf(st.get(j)).charAt(i) ;
				}
			}
			st.set(j,newString);
			newString="";
		}
		for (int i = 0; i < t; i++) {
			System.out.println(st.get(i));
		}	
	}
}
