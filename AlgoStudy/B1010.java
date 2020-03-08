package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1010 {
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// nCr = n-1Cr-1 + n-1Cr
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
			String[] str =bf.readLine().split(" ");
			System.out.println(str[0]);
//			bf.readLine();
//			String orgCd = bf.readLine().replace("<orgCd>", "").replace("</orgCd>", "");
//			String name = bf.readLine().replace("<orgdownNm>", "").replace("</orgdownNm>", "").replace("½Ã", "").replace("±º", "");
//			bf.readLine();
//			bf.readLine();
//			System.out.println("\""+name+"\" : \""+orgCd+"\",");
		}
	}
}
