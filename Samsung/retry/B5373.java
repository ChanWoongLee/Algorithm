package Samsung.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5373 {
	// 9 �� 30 ����
	static String[][] move;
	// F + : L1 -> U3 , U3-> R1, R1 - > D1, D1->L1 F��ȸ��
	// D + : L��3 -> F3 , F3-> R��1, R��1 -> B1
	// L + : B��1 -> U��1, U��1 -> F��1, F��1 -> D�� 1
	// R + : F��3 -> fubf ����
	//
	// left up right down
	// f�� L�� U�� R�� D��
	// D�� L�� F�� R�� B��
	// B�� L�� D�� R�� U��
	// U�� L�� B�� R�� F��
	// L�� B�� U�� F�� D��
	// R�� F�� U�� B�� D��
	static String[][] F = { { "r", "r", "r" }, { "r", "r", "r" }, { "r", "r", "r" } };
	static String[][] D = { { "y", "y", "y" }, { "y", "y", "y" }, { "y", "y", "y" } };
	static String[][] B = { { "o", "o", "o" }, { "o", "o", "o" }, { "o", "o", "o" } };
	static String[][] U = { { "w", "w", "w" }, { "w", "w", "w" }, { "w", "w", "w" } };
	static String[][] L = { { "g", "g", "g" }, { "g", "g", "g" }, { "g", "g", "g" } };
	static String[][] R = { { "b", "b", "b" }, { "b", "b", "b" }, { "b", "b", "b" } };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			move = new String[num][2];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < num; i++) {
				String[] temp = st.nextToken().split(" ");
				move[i][0] = temp[0];
				move[i][1] = temp[2];
			}
		}
	}

	static void Fplus() {
	}
}
