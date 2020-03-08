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
class Node{ // Ʈ���� ��!!!!!!!!!!!!!!�� ��� Ŭ���� �����ϱ�  2��Ʈ������
	char value =0;
	Node left ;
	Node right;
	public Node(char v) {
		this.value=v;
	}
}

class BTree{
	Node root;
	public void add(char value, char leftValue, char rightValue) {// �߰��Լ�
		if(root==null) {//���� ������ ��Ʈ�� ����ִٸ�
			if(value!='.')root= new Node(value);//������� value �� root Ŭ���� ����
			if(leftValue!='.')root.left = new Node(leftValue);// rootŬ�����ȿ� �ִ� left Ŭ������ ���� leftvalue��  ����
			if(rightValue!='.')root.right = new Node(rightValue);//����������
		}
		else search(root, value, leftValue,rightValue);// �⺻������ ä�����ִٸ� �� �ڸ� ã�ƾ���
	}
	public void search(Node root,int value, char leftValue, char rightValue) {//ã�¹� ��Ϳ����� ����  �θ� �ڽ� ������ ��
		if(root==null)return;// ������
		else if(root.value==value){
			if(leftValue!='.')root.left = new Node(leftValue);
			if(rightValue!='.')root.right = new Node(rightValue);
		}
		else {
			search(root.left, value, leftValue, rightValue);
			search(root.right, value, leftValue, rightValue);
		}
	}

	public void preorder(Node root) {//���� ����  �߾�->��->��
		System.out.print(root.value);
		if (root.left!=null) preorder(root.left);
		if (root.right!=null) preorder(root.right);
	}
	public void inorder(Node root) {//��������  ��->�߾� -> ��
		if (root.left!=null) inorder(root.left);
		System.out.print(root.value);
		if (root.right!=null) inorder(root.right);
	}
	public void postorder(Node root) {//�������� ��->��->�߾�
		if (root.left!=null) postorder(root.left);
		if (root.right!=null)	postorder(root.right);
		System.out.print(root.value);
	}

}
