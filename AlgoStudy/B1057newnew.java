package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1057newnew {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		int people = Integer.parseInt(line[0]);
		if(people == 1) {
			System.out.println(-1);
			return;
		}
		int kim = Integer.parseInt(line[1]);
		int lim = Integer.parseInt(line[2]);
		int[] match = new int[people];
		match[kim - 1] = 1;
		match[lim - 1] = 1;
		int count = 0;
		while (true) {
			int[] tournament;
			if (match.length % 2 == 0) // ¦����
				tournament = new int[match.length / 2];
			else {// Ȧ����
				tournament = new int[match.length / 2 + 1];
				tournament[match.length / 2] = match[match.length - 1]; // �� ����� ������
			}
			count++;
			int index = 0;
			for (int i = 0; i < match.length-1 ; i+=2 ) {
				if((match[i] == 1) && (match[i+1] == 1)) { // lim�� kim�� ������
					System.out.println(count);
					return;
				}
				else if((match[i] == 1) || (match[i+1] == 1)) {// lim�� kim�� ������ �̱�� ���� �º�����
					tournament[index] = 1;
					index++;
				}
				else { // �����̱�� ������� �����
					tournament[index] = 0;
					index++;
				}
			}
			match = new int[tournament.length];
			for(int i = 0; i < tournament.length; i++) {// match�� ���������ŭ �Ҵ�� ��ġ����
				match[i] = tournament[i];
			}
		}
	}
}
