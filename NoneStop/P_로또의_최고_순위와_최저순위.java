package NoneStop;

public class P_�ζ���_�ְ�_������_�������� {

	public static void main(String[] args) {

	}

	static int[] rank = { 6, 6, 5, 4, 3, 2, 1 };

	// 9 : 54 �н���
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {};
		boolean[] lvisit = new boolean[lottos.length];
		boolean[] wvisit = new boolean[win_nums.length];
		int correct = 0;
		int zero = 0;
		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zero++;
				continue;
			}
			for (int j = 0; j < lottos.length; j++) {
				if (win_nums[j] == lottos[i]) {
					correct++;
					break;
				}
			}
		}
		

		return new int[] {rank[correct+zero], rank[correct]};
	}
}
