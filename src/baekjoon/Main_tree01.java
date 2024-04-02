package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_tree01 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine());
        
        Node rootNode = null;
        
        // 노드 정보를 읽어와서 트리를 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            
            String parentValue = tokenizer.nextToken(); //A //B
            String leftChildValue = tokenizer.nextToken(); //B //D
            String rightChildValue = tokenizer.nextToken(); //C
            
            // 노드 생성 및 연결
            // 루트노드가 null인경우 = 트리가 비어 잇는 경우 부모노드를 찾는 새로운 노드를 생성
            if (rootNode == null) {
                rootNode = new Node(parentValue); //A
            }
            
            //메서드를 통해 부모 노드를 찾음 > 해당 노드가 존재하지 않는다면 rootNode 반환
            //자식 노드값이 .이 아닐 경우에만 해당 자식 노드를 부모노드에 연결
            Node parentNode = findNode(rootNode, parentValue); //A //B 
            if (!leftChildValue.equals(".")) {
                parentNode.leftChild = new Node(leftChildValue); //B
            }
            if (!rightChildValue.equals(".")) {
                parentNode.rightChild = new Node(rightChildValue); //C
            }
        }
        
        // 생성된 트리를 순회하여 출력
        preorderTraversal(rootNode);
        System.out.println();
        inorderTraversal(rootNode);
        System.out.println();
        postorderTraversal(rootNode);
    }
    
    // 트리 순회 - 전위 순회
    public static void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value);
            preorderTraversal(root.leftChild);
            preorderTraversal(root.rightChild);
        }
    }
    
    // 트리 순회 - 중위 순회
    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.leftChild);
            System.out.print(root.value);
            inorderTraversal(root.rightChild);
        }
    }
    
    // 트리 순회 - 후위 순회
    public static void postorderTraversal(Node root) {
        if (root != null) {
        	postorderTraversal(root.leftChild);
        	postorderTraversal(root.rightChild);
            System.out.print(root.value);
        }
    }
    
    // 주어진 값에 해당하는 노드 찾기
    // value가 찾고자 하는 값
    public static Node findNode(Node root, String value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }
        
        Node leftResult = findNode(root.leftChild, value);
        if (leftResult != null) {
            return leftResult;
        }
        
        return findNode(root.rightChild, value);
    }
}

//이진 트리의 노드
//각 노드는 value = 값과 왼쪽, 오른쪽 자식 노드를 가진다.
class Node {
    String value;
    Node leftChild;
    Node rightChild;
    
    
//생성자를 통해 노드의 값을 설정하고 자식 노드는 초기에 null로 설정
    public Node(String value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}
