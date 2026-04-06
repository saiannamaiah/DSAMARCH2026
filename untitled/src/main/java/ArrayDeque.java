import java.util.Arrays;

public class ArrayDeque {
    private int[] items;
    private int front;
    private int rear;
    private int count;


    public ArrayDeque(int capacity){
        items = new int[capacity];
    }
    public void add(int value){
        if(count == items.length){
            throw new IllegalStateException();
        }
        items[rear] = value;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int remove(){
         var item = items[front];
         items[front] = 0;
         front = (front + 1) % items.length;
         count--;
         return item;
    }

    @Override
    public String toString(){
       return Arrays.toString(items);
    }
}
