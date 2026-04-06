public class AVLTrees {
    private class AVLNode{
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightRight;

        public AVLNode(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Value" + this.value;
        }
    }

    private AVLNode root;
    public void insert(int value){
        root = insert(root,value);
    }
    private AVLNode insert(AVLNode root, int value){
        if(root == null){
            return new AVLNode(value);
        }
        if(value < root.value){
            root.leftChild = insert(root.leftChild,value);
        } else {
            root.rightRight = insert(root.rightRight,value);
        }
       setHeight(root);


        return balance(root);
    }

    private AVLNode balance(AVLNode node){
        if(isLeftHeavy(node)){
            System.out.println(node.value + "Check First what it is left heavy");
            if(balanceFactor(node.leftChild) < 0){
                System.out.println( "Left Roatate First" + node.leftChild.value);
                root.leftChild = leftRotate(node.leftChild);
            }
            System.out.println("Right roatate on" + node.value );
            return rotateRight(node);
        } else if(isRightHeavy(node)){
            System.out.println(node.value + "Check First what it >  is right heavy");
            if(balanceFactor(node.rightRight) > 0){
                System.out.println("Right roatate on " + node.rightRight.value);
              root.rightRight =   rotateRight(node.rightRight);
            }
            System.out.println("left Roatate" + node.value);
            return leftRotate(node);
        }
        return node;
    }
    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
        return (node == null)  ? 0 : height(node.leftChild) - height(node.rightRight);
    }

    private AVLNode leftRotate(AVLNode node){
       AVLNode newRoot = node.rightRight;
        node.rightRight = newRoot.leftChild;
       newRoot.leftChild = node;
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode node){
        AVLNode newRoot = node.leftChild;
        node.leftChild = newRoot.rightRight;
        newRoot.rightRight = node;
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(root.leftChild),height(root.rightRight)) + 1;
    }
    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }
}
