package practice;

import java.util.Scanner;

public class B1991useTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char data[];
		BTree b= new BTree();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			data=line.replaceAll(" ", "").toCharArray();
			b.add(data[0], data[1], data[2]);
		}
		
		b.preorder(b.root);
		System.out.println();
		b.inorder(b.root);
		System.out.println();
		b.postorder(b.root);
		System.out.println();
	}
}
class Node{ // 트리의 기!!!!!!!!!!!!!!초 노드 클래스 생성하기  2진트리로함
	char value =0;
	Node left ;
	Node right;
	public Node(char v) {
		this.value=v;
	}
}

class BTree{
	Node root;
	public void add(char value, char leftValue, char rightValue) {// 추가함수
		if(root==null) {//만약 가장위 루트가 비어있다면
			if(value!='.')root= new Node(value);//멤버값이 value 인 root 클래스 생성
			if(leftValue!='.')root.left = new Node(leftValue);// root클래스안에 있는 left 클래스도 값을 leftvalue로  생성
			if(rightValue!='.')root.right = new Node(rightValue);//마찬가지로
		}
		else search(root, value, leftValue,rightValue);// 기본적으로 채워져있다면 들어갈 자리 찾아야함
	}
	public void search(Node root,int value, char leftValue, char rightValue) {//찾는법 재귀에쓰일 노드랑  부모 자식 노드들의 값
		if(root==null)return;// 기저임
		else if(root.value==value){
			if(leftValue!='.')root.left = new Node(leftValue);
			if(rightValue!='.')root.right = new Node(rightValue);
		}
		else {
			search(root.left, value, leftValue, rightValue);
			search(root.right, value, leftValue, rightValue);
		}
	}

	public void preorder(Node root) {//전위 순서  중앙->좌->우
		System.out.print(root.value);
		if (root.left!=null) preorder(root.left);
		if (root.right!=null) preorder(root.right);
	}
	public void inorder(Node root) {//중위순서  좌->중앙 -> 우
		if (root.left!=null) inorder(root.left);
		System.out.print(root.value);
		if (root.right!=null) inorder(root.right);
	}
	public void postorder(Node root) {//후위순서 좌->우->중앙
		if (root.left!=null) postorder(root.left);
		if (root.right!=null)	postorder(root.right);
		System.out.print(root.value);
	}

}
