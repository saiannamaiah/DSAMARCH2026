public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        if (root == null){
            root = new Node(value);
        }
        var current = root;
        while (true){
            if (value < current.value){
                if(current.leftChild == null){
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild == null){
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public void preOrderReversal(){
        preOrderReversal(root);
    }

    private void preOrderReversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrderReversal(root.leftChild);
        preOrderReversal(root.rightChild);
    }
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    private void postOrderTraversal(Node root){
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root.leftChild == null && root.rightChild == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }
}
