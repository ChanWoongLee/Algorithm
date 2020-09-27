package SummerCoding;

import java.net.Inet4Address;
import java.util.HashSet;

public class Naver_C {

	public static void main(String[] args) {
		System.out.println(soulution(7));
	}

	public static long soulution(int k) {
		HashSet<String>[] hs = new HashSet[k + 8];
		for (int i = 0; i < hs.length; i++) {
			hs[i] = new HashSet<>();
		}
		hs[2].add("1");
		hs[3].add("7");
		String  a = "2";
		for(String s : hs[2])
			System.out.println(s);
		return 1;
	}
}
