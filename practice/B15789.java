package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B15789 {
	static ArrayList<Integer>[] castle;
	static boolean visit[];
	static ArrayList<Integer> same;
	static int count;
	public static void dfs(int node) {
		if(visit[node])
			return;
		
		visit[node] = true;
		count++;
		for(int i = 0; i < castle[node].size(); i++) {
			if(!visit[castle[node].get(i)])
				dfs(castle[node].get(i));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		castle = new ArrayList[Integer.parseInt(input[0])+1];
		visit = new boolean[Integer.parseInt(input[0])+1];
		for(int i = 0; i < castle.length; i++) {
			castle[i] = new ArrayList();
		}
		int samenum = Integer.parseInt(input[1]);
		for(int link = 1; link <= samenum; link++) {
			input = bf.readLine().split(" ");
			castle[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			castle[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}
		input = bf.readLine().split(" ");
		same = new ArrayList();
		int result = 0;
		count = 0;
		dfs(Integer.parseInt(input[0]));
		result+=count;
		dfs(Integer.parseInt(input[1]));
		for(int i = 1; i < castle.length; i++) {
			count = 0;
			dfs(i);
			if(count!= 0)
				same.add(count);
		}
		same.sort((a,b)->{
			if(a>b)
				return -1;
			else if(a<b)
				return 1;
			else
				return 0;
		});
		for(int i = 0; i < Integer.parseInt(input[2]); i++) {
			result += same.get(i);
		}
		System.out.println(result);
	}
}
