public class PriorityQueueUsingHeaps {
    private Heaps heaps = new Heaps();
    public void add(int item){
        heaps.insert(item);
    }
    public void remove(){
        heaps.remove();
    }
}
