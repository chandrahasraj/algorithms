/**
 * 
 */
package algorithms.datastructures;

import java.util.Scanner;

/**
 * @author chand
 *
 */
public class BinaryTree<T> extends Node<T> {

	Node<T> rootNode;
	static int nodeCount=0;
	
	public BinaryTree(T data, Node<T> left, Node<T> right) {
		super(data, left, right);
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(T data) {
		nodeCount++;
		if(rootNode==null){
			rootNode=new BinaryTree<T>(data,null,null);
		}else{
			Node<T> temp=rootNode;
			if(temp.left==null){
				temp.left=new BinaryTree<T>(data, null, null);
				return;
			}
			else if(temp.right==null){
				temp.right=new BinaryTree<T>(data, null, null);
				return;
			}
			else{
				Node<T> temp2=temp;
				int leftCount=0,rightCount=0;
				boolean tempRight=false,temp2Right=false;
				while(temp.left!=null&&temp.right!=null){
					temp=temp.left;
					leftCount++;
					if(temp.right==null&&temp.left!=null){
						tempRight=true;
					}
					if(temp.left==null&&temp.right==null){
						tempRight=false;
					}
				}
				while(temp2.left!=null&&temp2.right!=null){
					temp2=temp2.right;
					rightCount++;
					if(temp2.right==null&&temp2.left!=null){
						temp2Right=true;
					}
					if(temp2.left==null&&temp2.right==null){
						temp2Right=false;
					}
				}
				
				if(leftCount==rightCount){
					if(tempRight){
						temp.right=new BinaryTree<T>(data,null,null);
						return;
					}else{
						temp.left=new BinaryTree<T>(data,null,null);
						return;
					}
				}else{
					if(temp2Right){
						temp2.right=new BinaryTree<T>(data,null,null);
						return;
					}else{
						temp2.left=new BinaryTree<T>(data,null,null);
						return;
					}
				}
				
			}
		}
	}

	@Override
	public void display() {
		//Inorder Traversal
		recurse(rootNode);
	}
	
	private void recurse(Node<T> rootNode2) {
		if (rootNode2 != null) {
			System.out.println(rootNode2.data);
			recurse(rootNode2.left);
			recurse(rootNode2.right);
		}
	}

	@Override
	public boolean lookup(T data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String as[]){
		Scanner input = new Scanner(System.in);
		String line[];
		BinaryTree<String> tree = new BinaryTree<String>(null, null, null);
		System.out.println("Enter values to insert into binary tree[1,2,3]");
		line = input.nextLine().split(",");
		for (String value : line) {
			tree.insert(value);
		}
		tree.display();
//		tree.delete("c");
//		tree.display();

		input.close();
	}
	
}
