package algorithms.datastructures;

import java.util.Scanner;

public class BinarySearchTree<B> extends Node<B> {
	Node<B> rootNode;
	private static boolean isFirstNode = true;
	static int totalNumberOfNodes = 0, heightOfTree;

	public BinarySearchTree(B data, Node<B> left, Node<B> right) {
		super(data, left, right);
	}

	Node<B> createNewNode(B data) {
		BinarySearchTree<B> temp = new BinarySearchTree<B>(data, null, null);
		totalNumberOfNodes++;
		return temp;
	}

	public void display() {
		int sum = 0;
		for (int i = 0;; i++) {
			sum += Math.pow(2, i);
			if (totalNumberOfNodes > sum) {
				heightOfTree = i + 1;
			} else
				break;
		}
		recurse(rootNode, heightOfTree);
	}

	public void delete(B data) {
		Node<B> rootClone = rootNode;
		Node<B> temp = this.createNewNode(data);
		totalNumberOfNodes--;
		Node<B> superParent = rootClone;
		boolean isLeft = false;
		while (rootClone != null) {
			if (compare(rootClone, temp) == 0) {
				totalNumberOfNodes--;
				if (rootClone.left != null && rootClone.right == null) {
					if (isLeft)
						superParent.left = rootClone.left;
					else
						superParent.right = rootClone.left;
					return;
				} else if (rootClone.left == null && rootClone.right != null) {
					if (isLeft)
						superParent.left = rootClone.right;
					else
						superParent.right = rootClone.right;
					return;
				} else if (rootClone.left != null && rootClone.right != null) {
					if (isLeft) {
						superParent.left = getSuccessor(rootClone);
						superParent.left.left = rootClone.left;
						return;
					} else {
						superParent.right = getSuccessor(rootClone);
						superParent.right.left = rootClone.left;
						return;
					}
				} else {
					if (isLeft)
						superParent.left = null;
					else
						superParent.right = null;
					return;
				}
			} else if (compare(rootClone, temp) > 0) {
				superParent = rootClone;
				isLeft = true;
				rootClone = rootClone.left;
			} else if (compare(rootClone, temp) < 0) {
				superParent = rootClone;
				isLeft = false;
				rootClone = rootClone.right;
			}
		}
	}

	private Node<B> getSuccessor(Node<B> rootClone) {
		Node<B> temp = rootClone.right;
		Node<B> temp2 = temp;
		boolean isRight = false;
		if (temp.left == null && temp.right == null) {
			return temp;
		} else if (temp.left == null & temp.right != null)
			return temp;
		else {
			while (temp.left != null) {
				temp2 = temp;
				temp = temp.left;
				if (temp.left == null) {
					if (temp.right != null)
						isRight = true;
					else
						isRight = false;
				}
			}
			if (isRight) {
				temp2.left = temp.right;
				temp.right = rootClone.right;
				return temp;
			} else {
				temp2.left = null;
				temp.right = rootClone.right;
				return temp;
			}
		}
	}

	public boolean lookup(B data) {
		Node<B> rootClone = rootNode;
		Node<B> temp = this.createNewNode(data);
		totalNumberOfNodes--;
		while (rootClone != null) {
			if (compare(rootClone, temp) == 0) {
				return true;
			} else if (compare(rootClone, temp) > 0) {
				rootClone = rootClone.left;
			} else {
				rootClone = rootClone.right;
			}
		}
		return false;
	}

	private void recurse(Node<B> rootNode2, int tab) {
		if (rootNode2 != null) {
			System.out.println(rootNode2.data);
			recurse(rootNode2.left, tab);
			recurse(rootNode2.right, tab);
		}
	}

	public void insert(B data) {
		if (isFirstNode) {
			rootNode = this.createNewNode(data);
			isFirstNode = false;
		} else {
			Node<B> rootClone = rootNode;
			Node<B> temp = this.createNewNode(data);
			Node<B> parent;
			while (true) {
				parent = rootClone;
				if (compare(rootClone, temp) > 0) {
					rootClone = rootClone.left;
					if (rootClone == null) {
						parent.left = temp;
						return;
					}
				} else {
					rootClone = rootClone.right;
					if (rootClone == null) {
						parent.right = temp;
						return;
					}
				}
			}
		}
	}

	public static void main(String as[]) {
		Scanner input = new Scanner(System.in);
		String line[];
		BinarySearchTree<String> tree = new BinarySearchTree<String>(null, null, null);
		System.out.println("Enter values to insert into binary tree[1,2,3]");
		line = input.nextLine().split(",");
		for (String value : line) {
			tree.insert(value);
		}
		tree.display();
		tree.delete("c");
		tree.display();

		input.close();
	}

}