//Build a Tree from its Preorder traversal

public class BinaryTreesYT {
   static class Node {

       int data;
       Node left;
       Node right;

       Node(int data) {
           this.data = data;
           this.left = null;
           this.right = null;
       }
   }

   static class BinaryTree {
       static int idx = -1;

       public static Node buildTree(int nodes[]) {
           idx++;
           if(nodes[idx] == -1) {
               return null;
           }

           Node newNode = new Node(nodes[idx]);

           newNode.left = buildTree(nodes);
           newNode.right = buildTree(nodes);
           return newNode;

       }
   }

   public static int height(Node root) {

       if(root == null) {
           return 0;
       }


       int leftHeight = height(root.left);
       int rightHeight = height(root.right);

       
       return leftHeight + rightHeight + root.data;

    //    return Math.max(leftHeight, rightHeight) +1;

    // return (leftHeight+ rightHeight) +1;   //-> to get the count of nodes..


   }


   public static void main(String args[]) {
       int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7, -1, -1, -1};
     
       BinaryTree tree = new BinaryTree();
       Node root = tree.buildTree(nodes);
       System.out.println(root.data);

       System.out.println(root.left);  // 2
       System.out.println(root.right);  // 3

       System.out.println(height(root));


   }
}
