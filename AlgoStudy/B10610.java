package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		ArrayList<Integer> num = new ArrayList();
		for(int i = 0; i < str.length;i ++) {
			num.add(Integer.parseInt(str[i]));
		}
		if(!num.contains(0)) { System.out.println(-1); System.exit(0);}
		Collections.sort(num, (a,b)-> -(a-b));

		
	}

}
