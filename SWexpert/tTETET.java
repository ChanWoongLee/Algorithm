package SWexpert;

import java.util.ArrayList;

public class tTETET {
	public static void main(String[] args) {
		cc a = new cc(5);
		System.out.println(a.c);
		a.c =1;
		System.out.println(a.c);
		cc b= a;
		ArrayList<cc> aa = new ArrayList();
		aa.add(b);
		cc bb=aa.get(0);
		bb.c = 13132323;
		System.out.println(a.c);
		
	}

}
class cc{
	int c;
	public cc(int c) {
		this.c = c;
	}
}
