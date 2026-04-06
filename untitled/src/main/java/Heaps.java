public class Heaps {
    private int[] items = new int[10];
    private int size;

    public void insert(int value){
        if(items.length == size){
            throw new IllegalStateException();
        }
        items[size++] = value;

        bubbleUp();
    }

    public void remove(){
        if (size == 0){
            throw new IllegalStateException();
        }
        items[0] = items[--size];
        var index = 0;
        while (index <= size && !isValidParent(index)){
            var largerChildIndex = largerChildLeftOrRight(index);
            swap(index,largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }
    private int largerChildLeftOrRight(int index){
        if(!hasLeftChild(index)){
            return index;
        }
        if(!hasRightChild(index)){
            return leftChildIndex(index);
        }
        return (leftChild(index) > rightChild(index)) ? leftChild(index) : rightChild(index);
    }
    private boolean hasLeftChild(int index){
        return leftChildIndex(index) > size;
    }
    private boolean hasRightChild(int index){
        return rightChild(index) > size;
    }
    private boolean isValidParent(int index){
        if(!hasLeftChild(index)){
            return true;
        }
        if(!hasRightChild(index)){
            return items[index] >= leftChild(index);
        }
    return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }
    private int leftChildIndex(int index){
        return (index * 2) + 1;
    }
    private int rightChildIndex(int index){
        return (index * 2) + 2;
    }
    private void bubbleUp(){
        var index = size - 1;
        while (index > 0 && items[index] > items[parentIndex(index)]){
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }
    private void swap(int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;

    }
    private int parentIndex(int index){
        return (index - 1) / 2;
    }

}
