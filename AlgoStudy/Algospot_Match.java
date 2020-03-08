	package AlgoStudy;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.PriorityQueue;
	import java.util.StringTokenizer;
	
	public class Algospot_Match {
	
		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			while(t-->0) {
				st = new StringTokenizer(bf.readLine());
				int size = Integer.parseInt(st.nextToken());
				ArrayList<Integer> korea = new ArrayList();
				ArrayList<Integer> russia = new ArrayList();
				StringTokenizer ru = new StringTokenizer(bf .readLine());
				StringTokenizer kor = new StringTokenizer(bf.readLine());
				for(int i = 0 ; i < size ; i ++) {
					korea.add(Integer.parseInt(kor.nextToken()));
					russia.add(Integer.parseInt(ru.nextToken()));
				}
				Collections.sort(korea);Collections.sort(russia);
				int index = 0, win = 0;
				for(int i = 0 ; i < size; i++) {
					while( index < size && !(korea.get(index) >= russia.get(i))) {
						index++;
					}
					index++;
					win++;
					if(index >= size)
						break;
				}
				System.out.println(win);
			}
		}
	
	}
