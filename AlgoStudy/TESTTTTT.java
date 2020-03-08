package AlgoStudy;

public class TESTTTTT {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BCB", "CBADF", "AECB", "BDA" };

		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			String compareStr = skill_trees[i];
			String skillCheck = "";
			for (int j = 0; j < compareStr.length(); j++) {
				if (skill.contains(String.valueOf(compareStr.charAt(j)))) {
					skillCheck+=String.valueOf(compareStr.charAt(j));
				}
			}
			for(int j = 0; j < skillCheck.length(); j++) {
				if( skill.charAt(j) != skillCheck.charAt(j)) 
					break;
				if(j == skillCheck.length()-1)
					answer++;
			}
		}
		System.out.println(answer);
	}

}
