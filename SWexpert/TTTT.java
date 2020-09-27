package SWexpert;

import java.util.ArrayList;

public class TTTT {

	public static void main(String[] args) {
		ArrayList<stair> sss= new ArrayList();
		sss.add(new stair(3, 3, 3));
		ArrayList<stair> aaa = new ArrayList();
		aaa.addAll(sss);
		aaa.get(0).r = 333;
		System.out.println(sss.get(0).r);
		
	}

}
