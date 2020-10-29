package SummerCoding;

public class k_A {

	public static void main(String[] args) {
		SolutionA a = new SolutionA();
		System.out.println(a.solution("m.m.mmm...m.m"));
	}

}

class SolutionA {
	static public String solution(String new_id) {
		new_id = new_id.toLowerCase();
		
		for (int i = 0; i < new_id.length(); i++) {
			char nowIndex = new_id.charAt(i);
			if ((nowIndex >= 45 && nowIndex <= 57) || (nowIndex >= 97 && nowIndex <= 122) || (nowIndex == '-')
					|| (nowIndex == '_') || (nowIndex == '.'))
				continue;
			new_id = new_id.replace(String.valueOf(nowIndex), "");
			i = -1;
		}

		///////////////////////

		while (true) {
			String check = "..";
			String before = new_id;
			
			new_id = new_id.replace(check, ".");
			if (before.equals(new_id))
				break;
		}

		/////////////////
		if (!new_id.equals("")) {
			if (new_id.charAt(0) == '.')
				new_id = new_id.substring(1);
		}
		if (!new_id.equals("")) {
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, new_id.length() - 1);
		}
		////////////////
		if (new_id.equals("")) {
			new_id += "a";
		}
		///////////////
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, new_id.length() - 1);
		}

		if (new_id.length() <= 2) {
			char last = new_id.charAt(new_id.length() - 1);
			while (!(new_id.length() >= 3)) {
				new_id += String.valueOf(last);
			}
			
		}
		////////////////
		return new_id;
	}
}