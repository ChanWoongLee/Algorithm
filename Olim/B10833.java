package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10833 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		int result = 0;
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(bf.readLine());
			int student = Integer.parseInt(st.nextToken());
			int apple = Integer.parseInt(st.nextToken());
			
			result += apple - (apple/student)*student;
		}
		System.out.println(result);
	}

}
