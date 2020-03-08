package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.naming.directory.SearchControls;

public class B1991 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		String[] ar = bf.readLine().split(" ");
		Tree btree = new Tree(ar[0], ar[1], ar[2]);
		for(int i =1; i < num; i++) {
			ar = bf.readLine().split(" ");
			btree.add(ar[0], ar[1], ar[2]);
		}
		
		btree.preorder(btree.root);
	}
}
class Node{
	String value;
	Node leftchild;
	Node rightchild;
}

class Tree{
	Node root;
	public Tree(String ar1,String ar2, String ar3){
		root = new Node();
		root.value = ar1;
		if(!ar2.equals(".")) {
			root.leftchild = new Node();
			root.leftchild.value = ar2;
		}
		if(!ar3.equals(".")) {
			root.rightchild = new Node();
			root.rightchild.value = ar3;
		}
	}
	public void add(String ar1,String ar2, String ar3) {
		Node node = serarch(root, ar1);
		if(!ar2.equals(".")) {
			node.leftchild = new Node();
			node.leftchild.value = ar2;
		}
		if(!ar3.equals(".")) {
			node.rightchild = new Node();
			node.rightchild.value = ar3;
		}
	}
	
	public Node serarch(Node node, String ar1) {
		if(node.leftchild == null && node.rightchild==null)
			return null;
		
		if(node.leftchild != null && node.leftchild.value.equals(ar1) ) {
			return node.leftchild;
		}
		else if(node.rightchild != null &&node.rightchild.value.equals(ar1)) {
			return node.rightchild;
		}

		Node checknode1 = serarch(node.rightchild, ar1);
		Node checknode2 = serarch(node.leftchild, ar1);
		
		if(checknode1 != null)
			return checknode1;
		else if(checknode2 != null)
			return checknode2;
		else
			return null;
	}
	
	public void preorder(Node node) {
		if(node == null) 
			return;
		System.out.print(node.value);
		preorder(node.leftchild);
		preorder(node.rightchild);
	}
}