package AlgoStudy;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Algospot_nerd {
	// HashMap�� O(1)�� �� ���� ����
	// TreeMap�� key�� �������� BST������ �ڵ����� ����  log(n) �ɸ�
	// BST�� �����Լ� ceilingKey(a) �� a�� key���� ū key�߿��� ���� key 
	//            floorkey(a) �� a�� key���� ���� key�߿��� ū key
    private TreeMap<Integer, Integer> nerds = new TreeMap<>();
    private int numOfNerds = 0;

    public boolean isDominated(int x, int y) {
    	// ���� ���� �ȵ����� Ȯ��
        Integer key = nerds.ceilingKey(x);
        if (key != null && y < nerds.get(key))
            return true;
        else
            return false;
    }

    public void checkNerds(int x, int y) {
        if (isDominated(x, y)) { // ����Ǹ� Ʈ���߰� ���ϰ� ������ �׳� ������
            numOfNerds += nerds.size();
            return;
        }

        Integer key = nerds.floorKey(x);
        while (key != null) {// ���� ���� x,y �� ���� x ���� key�� ����  
            if (nerds.get(key) < y) {// y���� ���� ���� ���� ������  ����
                nerds.remove(key);
            }else {
                break;
            }
            key = nerds.floorKey(key);// �ݺ�
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