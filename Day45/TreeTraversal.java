package Day45;

// Definition of Tree Node
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class TreeTraversal {

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder Traversal: ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(root);
        System.out.println();
    }
}
