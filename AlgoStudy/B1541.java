package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split("");
		ArrayList<String> parse = new ArrayList();
		String part = "";
		int max = line.length;
		for (int i = 0; i < line.length; i++) {
			if (line[i].equals("-") || line[i].equals("+")) {
				parse.add(part);
				part = "";
				parse.add(line[i]);

			} else {
				part += line[i];
			}
		}
		parse.add(part);
		String[] plus = new String[51];
		ArrayList<String> plus2 = new ArrayList();
		int result = 0;
		for (int i = 0; i < parse.size(); i++) {
			if (parse.get(i).equals("-")) {
				i = i+1;
				result -= Integer.parseInt(parse.get(i));
				for (int j = i + 1; j < parse.size(); j++) {
					if (parse.get(j).equals("-")) {
						break;
					} else if (parse.get(j).equals("+"))
						continue;
					else {
						result -= Integer.parseInt(parse.get(j));
						i = j;
					}
				}
			} else {
				if (!parse.get(i).equals("+"))
					result += Integer.parseInt(parse.get(i));
			}
		}
		System.out.println(result);
	}

}
