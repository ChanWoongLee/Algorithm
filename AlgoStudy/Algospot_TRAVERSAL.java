package AlgoStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class Algospot_TRAVERSAL {
	// 후위 LRV
	// 전위 VLR
	// 중위 LVR
    private int[] preorder;
    private int[] inorder;
    private ArrayList<Integer> postorder;
    // 어느노드가 루트인지 파악하는것이 핵쉼!!
    
    public void generatePostorder(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return;
        }
        int root = preorder[0];
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                rootIdx = i;
                break;
            }
        }
        // next subPreorder by left Tree : 1 ~ rootIdx + 1
        // next subInorder by left Tree : 0 ~ rootIdx
        // next subPreorder by right Tree : rootIdx + 1 ~ preorder.length
        // next subInorder by right Tree : rootIdx + 1 ~  ~ inorder.length
        int[] leftSubPreorder = new int[rootIdx];
        int[] leftSubInorder = new int[rootIdx];
        int[] rightSubPreorder = new int[preorder.length - rootIdx - 1];
        int[] rightSubInorder = new int[inorder.length - rootIdx - 1];
        System.arraycopy(preorder, 1, leftSubPreorder, 0, leftSubPreorder.length);
        System.arraycopy(inorder, 0, leftSubInorder, 0, leftSubInorder.length);
        System.arraycopy(preorder, rootIdx + 1, rightSubPreorder, 0, rightSubPreorder.length);
        System.arraycopy(inorder, rootIdx + 1, rightSubInorder, 0, rightSubInorder.length);

        
        generatePostorder(leftSubPreorder, leftSubInorder);
        generatePostorder(rightSubPreorder, rightSubInorder);

        postorder.add(root);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int loop = scan.nextInt();
        while(loop-- > 0) {
            Algospot_TRAVERSAL traversal = new Algospot_TRAVERSAL();

            // init traversals
            int nodes = scan.nextInt();
            traversal.preorder = new int[nodes];
            traversal.inorder = new int[nodes];
            traversal.postorder = new ArrayList<>();

            for (int i=0; i<nodes; i++) {
                traversal.preorder[i] = scan.nextInt();
            }
            for (int i=0; i<nodes; i++) {
                traversal.inorder[i] = scan.nextInt();
            }

            traversal.generatePostorder(traversal.preorder, traversal.inorder);
            for (int node : traversal.postorder){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}