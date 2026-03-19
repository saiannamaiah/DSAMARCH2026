import java.util.NoSuchElementException;

public class LinkedLists {
    private class Node{
        private int value;

        private Node next;

        public Node(int value){
            this.value = value;
        }

    }
    private Node first;
    private Node last;

    private int size;

    public void addLast(int item){
        var node = new Node(item);

        if(isEmpty()){
            first = last = node;
        } else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value){
        var node = new Node(value);

        if(isEmpty()){
            first  = last = node;
        } else{
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty(){
        return first == null;
    }

    public int indexOf(int value){
        var index = 0;
        var current = first;
       while(current != null){
           if(current.value == value){
               return index;
           }
           current = current.next;
           index++;
       }
       return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if (first == last){
            first = last = null;
            size--;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if (first == last){
            first = last = null;
            size--;
            return;
        }
        var prevois = getPrevious(last);
        last = prevois;
        last.next = null;
        size--;
    }

    public Node getPrevious(Node node){
        var current = first;
        while (current != null){
            if(current.next == node){
              return current;
            }
            current = current.next;
        }
        return null;
    }
    public int getSize(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var index = 0;
        var current = first;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }
}
