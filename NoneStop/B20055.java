package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B20055 {
	static ArrayList<Belt> up;
	static ArrayList<Belt> down;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		up = new ArrayList<>();
		down = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		int len = st.countTokens();
		for (int i = 0; i < len / 2; i++) {
			up.add(new Belt(Integer.parseInt(st.nextToken()), false));
		}
		for (int i = len / 2; i < len; i++) {
			down.add(0, new Belt(Integer.parseInt(st.nextToken()), false));
		}
		int ans = 0;
		while (cnt < K) {

			rotate();
			move();
			goRobot();
			ans++;
		}
		System.out.println(ans);
	}

	static void goRobot() {
		Belt state = up.get(0);
		if (state.robot || state.num == 0)
			return;
		up.set(0, new Belt(state.num - 1, true));
		if (state.num - 1 == 0)
			cnt++;
	}

	static void move() {
		for (int i = up.size() - 1; i >= 0; i--) {
			Belt state = up.get(i);
			if(i == up.size()-1) {
				up.set(i, new Belt(state.num, false));
				continue;
			}
			Belt nextState = up.get(i + 1);
			if (!state.robot || nextState.robot || nextState.num == 0)
				continue;
			up.set(i, new Belt(state.num, false));
			if (i + 1 == up.size() - 1) {
				up.set(i + 1, new Belt(nextState.num - 1, false));
			} else {
				up.set(i + 1, new Belt(nextState.num - 1, true));
			}
			if (nextState.num - 1 == 0)
				cnt++;
		}
	}

	static void rotate() {
		down.add(up.remove(up.size() - 1));
		up.add(0, down.remove(0));
	}

	static class Belt {
		int num;
		boolean robot;

		public Belt(int num, boolean robot) {
			super();
			this.num = num;
			this.robot = robot;
		}

	}
}
