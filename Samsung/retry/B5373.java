package Samsung.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5373 {
	// 9 시 30 시작
	static String[][] move;
	// F + : L1 -> U3 , U3-> R1, R1 - > D1, D1->L1 F면회전
	// D + : L세3 -> F3 , F3-> R세1, R세1 -> B1
	// L + : B세1 -> U세1, U세1 -> F세1, F세1 -> D세 1
	// R + : F세3 -> fubf 세삼
	//
	// left up right down
	// f의 L아 U위 R아 D아
	// D의 L왼 F위 R왼 B아
	// B의 L위 D위 R위 U아
	// U의 L오 B위 R오 F아
	// L의 B왼 U왼 F왼 D왼
	// R의 F오 U오 B오 D오
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
