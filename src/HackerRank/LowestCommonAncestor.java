package HackerRank;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LowestCommonAncestor {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	
	static List<Node> NodeToRootPath(Node root,int node){
		List<Node> ans = new ArrayList<Node>();
		if(root.data==node) { 
			ans.add(root);
			return ans;
		}
		if(root.left!=null) {
			List<Node> temp = NodeToRootPath(root.left,node);
			if(temp.size()!=0) {
				 ans.addAll(temp);
				 ans.add(root);
				 return ans;
				}
//			return ans;
		}
		
		if(root.right!=null) {
			List<Node> temp =NodeToRootPath(root.right,node);
			if(temp.size()!=0) {
			 ans.addAll(temp);
			 ans.add(root);
			 return ans;
			}
//			return ans;
		}
		
		return ans;
	}
	public static Node lca(Node root, int v1, int v2) {
      	 
		List<Node> vlist1 = NodeToRootPath(root,v1);
		List<Node> vlist2 = NodeToRootPath(root,v2);

//		for(Node v : vlist1)
//		System.out.print(v.data);
//		
//		
//		System.out.println();
//        for(Node v: vlist2)
//		System.out.print(v.data);
//        
//        System.out.println();
		
		int visited[] = new int[26];
//		int i=0,j=0;
		for(Node i:vlist1) {
			visited[i.data] = 1;
		}
		
		for(Node i:vlist2) {
			if(visited[i.data]==1) {
				return i;
			}
		}
		return root;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}