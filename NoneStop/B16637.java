package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B16637 {
	// 10 : 46 Ω√¿€
	static int N;
	static String str;
	static int result = Integer.MIN_VALUE;
	static ArrayList<Integer> ar;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		str = bf.readLine();
		ar = new ArrayList<>();
		if (N == 1) {
			System.out.println(Integer.parseInt(str));
			return;
		}
		dfs(1);
		
	}

	static void dfs(int index) {
		if (index >= N) {
			Collections.sort(ar,(a,b)-> b-a);
			for(int idx : ar) {
				int leftOperand = Integer.parseInt(str.charAt(idx-1)+"");
				int rightOperand = Integer.parseInt(str.charAt(idx+1)+"");
				String operand = str.charAt(idx)+"";
				int num = 0;
				if(operand.equals("+"))
					num = leftOperand+rightOperand;
				else if(operand.equals("*"))
					sum += leftOperand*rightOperand;
				else
			}
			return;
		}
		for(int i = index; i < N; i+=2) {
			ar.add(i);
			dfs(i+4);
			ar.remove(ar.size()-1);
			dfs(i+4);
		}
		
	}
}
