package algorithms.interviewQuestions;

import java.util.Scanner;

/*
 * given n number of nodes. 
 * 
 * if a node is pointed to 1 then it is a good node
 * if a node pointed to a node pointed to 1 is also a good node
 * if a node pointed to good node is also a good node
 */

public class MakeGoodNodes {
	public static void main(String as[]){
		String line = new Scanner(System.in).next();
		int[] data = new int[line.length()];
		
		for(int i=0;i<line.length();i++)
			data[i]=line.charAt(i)-'0';
		
		String status = noOfChanges(data);
		System.out.println(status);
	}
	
	static class Node{
		int from,to;
		Node(int _from,int _to){
			from = _from;
			to = _to;
		}
	}

	private static String noOfChanges(int[] data) {
		Node nodes[] = new Node[data.length+1];
		for(int i=0;i<data.length;i++){
			nodes[i+1] = new Node(i+1,data[i]);
		}
		for(int i=1;i<nodes.length;i++){
			if(hasCycle(nodes,i))
				System.out.println("has cycle "+i);
			else
				System.out.println("no cycle");
		}
		
		return "  sds";
	}
	
	static boolean hasCycle(Node[] nodes, int from){
		int forward = nodes[nodes[from].to].to;
		int slow = nodes[from].to;
		int length = nodes.length;
		while(forward!=slow && length!=0){
			forward = nodes[nodes[forward].to].to;
			slow = nodes[forward].to;
			length--;
		}
		if(length>=0)
			return true;
		else
			return false;
	}
}
