package leetcode;

import java.util.Scanner;

public class TopViewOFBinaryTree {

	 static Node insert(Node root, int data) {
//         leetcode.TopViewOFBinaryTree.this
        if(root == null) {
            Node node = new Node(data);
            return node;
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
//	static int c;
	public  void topView(Node root) {
           insert(null, root.data);

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
//        topView(root);
    }	
}

