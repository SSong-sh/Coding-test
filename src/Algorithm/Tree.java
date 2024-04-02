package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		Node rootNode = null;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			
			String parentValue = tokenizer.nextToken(); //A
			String leftChildValue = tokenizer.nextToken(); //B
			String rightChildValue = tokenizer.nextToken(); //C 
			
			//노드 만들기
			if (rootNode == null) {
				rootNode = new Node(parentValue); //
			}
			
			Node parentNode = findNode(rootNode, parentValue);
			
		}
		
		
	}

	private static Node findNode(Node root, String value) {
		if(root == null || root.value.equals(value)) {
			return root;
		}
		
		Node leftResult = findNode(root.leftChild, value);
		if (leftResult != null) {
			return leftResult;
		}
		return findNode(root.rightChild, value);
	}
}
class Node {
	String value;
	Node leftChild;
	Node rightChild;
	
	public Node(String value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	
}


