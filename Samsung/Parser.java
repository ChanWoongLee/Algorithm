package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] str = bf.readLine().replace(":", "").replace(",", "").trim().split(" ");
			System.out.println("{\"animal_name\" :"+str[0]+","+"\"animal_code\":"+str[1]+"},");
		}
	}
}
