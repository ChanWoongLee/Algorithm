package AlgoStudy;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Algospot_nerd {
	// HashMap은 O(1)로 속 도가 빠름
	// TreeMap은 key를 기준으로 BST정렬을 자동으로 해줌  log(n) 걸림
	// BST의 내장함수 ceilingKey(a) 는 a의 key보다 큰 key중에서 작은 key 
	//            floorkey(a) 는 a의 key보다 작은 key중에서 큰 key
    private TreeMap<Integer, Integer> nerds = new TreeMap<>();
    private int numOfNerds = 0;

    public boolean isDominated(int x, int y) {
    	// 지배 된지 안된지는 확인
        Integer key = nerds.ceilingKey(x);
        if (key != null && y < nerds.get(key))
            return true;
        else
            return false;
    }

    public void checkNerds(int x, int y) {
        if (isDominated(x, y)) { // 지배되면 트리추가 안하고 이전거 그냥 더해줌
            numOfNerds += nerds.size();
            return;
        }

        Integer key = nerds.floorKey(x);
        while (key != null) {// 새로 들어올 x,y 에 대해 x 보다 key에 대해  
            if (nerds.get(key) < y) {// y보다 작은 값을 갖고 있으면  제거
                nerds.remove(key);
            }else {
                break;
            }
            key = nerds.floorKey(key);// 반복
        }

        nerds.put(x, y);
        numOfNerds += nerds.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        while (loop-- > 0) {
            Algospot_nerd nerd2 = new Algospot_nerd();
            int applicants = Integer.parseInt(br.readLine());

            for (int i = 0; i < applicants; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                nerd2.checkNerds(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
            }

            System.out.println(nerd2.numOfNerds);
        }

        br.close();
    }
}