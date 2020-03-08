package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		int[] room = new int[size];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < size; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		long result = 0;
		for (int i = 0; i < size; i++) {
			if (room[i] - main <= 0)
				result++;
			else {
				room[i] -= main;
				result++;
				if (room[i] <= sub)
					result++;
				else
					result += room[i] % sub == 0 ? room[i] / sub : room[i] / sub + 1;
			}
		}
		System.out.println(result);
	}

}
