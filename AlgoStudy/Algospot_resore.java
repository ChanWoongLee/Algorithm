package AlgoStudy;

import java.util.*;

public class Algospot_resore {
	private static ArrayList<String> Datastr;
	private static int[][] m;

	public static String overlap(int last, int next) {
		int begin = 0;

		if (last == -1)
			return Datastr.get(next);
		if (m[last][next] != 0)
			return Datastr.get(next).substring(m[last][next]);

		String lastStr = Datastr.get(last);
		String nextStr = Datastr.get(next);
		int lastLen = lastStr.length();
		int nextLen = nextStr.length();

		for (int overlapLen = 1; overlapLen <= ((lastLen < nextLen) ? lastLen : nextLen); overlapLen++) {
			boolean chk = true;
			for (int j = 0; j < overlapLen; j++) {
				if (lastStr.charAt(lastLen - overlapLen + j) != nextStr.charAt(j))
					chk = false;
			}
			if (chk)
				begin = overlapLen;
		}
		m[last][next] = begin;
		return Datastr.get(next).substring(begin);
	}

	public static String solve(int last, ArrayList<Integer> nRemain) {
		String answer = "";

		if (nRemain.size() == 0)
			return answer;

		for (int i = 0; i < nRemain.size(); i++) {
			int index = nRemain.get(i);
			ArrayList<Integer> temp = (ArrayList<Integer>) nRemain.clone();
			temp.remove(i);
			String result = overlap(last, index) + solve(index, temp);

			if (answer == "")
				answer = result;
			else if (answer.length() > result.length())
				answer = result;
		}

		return answer;
	}

	public static void main(String[] args) {
		int numCase;

		Scanner scan = new Scanner(System.in);
		numCase = scan.nextInt();

		for (int i = 0; i < numCase; i++) {
			int k = scan.nextInt();

			Datastr = new ArrayList<String>();

			for (int j = 0; j < k; j++) {
				boolean chkContain = false;
				String s = scan.next();
				for (int l = Datastr.size() - 1; l >= 0; l--) {
					if (s.contains(Datastr.get(l)))
						Datastr.remove(l);
					else if (Datastr.get(l).contains(s)) {
						chkContain = true;
						break;
					}
				}
				if (!chkContain)
					Datastr.add(s);
			}
			ArrayList<Integer> dataInt = new ArrayList<Integer>();
			for (int j = 0; j < Datastr.size(); j++) {
				dataInt.add(j);
			}
			m = new int[Datastr.size()][Datastr.size()];

			System.out.println(solve(-1, dataInt));
		} 

		scan.close();
	}
}