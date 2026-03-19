public class Arrays {
    private int[] numbers;
    private int size;

    public Arrays(int value){
        numbers = new int[value];
    }

    public void print(){
      for(int i = 0; i < size; i++){
          System.out.println(numbers[i]);
      }
    }
    public void insert(int value){

        if(numbers.length == size){
            int[] newNumbers = new int[size*2];

            for(int i = 0; i < size; i++){
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        numbers[size++] = value;
    }

   public void removeAt(int index){
        if(index < 0 || index >= size){
            throw new IllegalStateException();
        }
        for (int i = index; i < size; i++){
            numbers[i] = numbers[i + 1];
        }
        size--;
   }

   public int search(int item){
        for (int i = 0; i < size; i++){
            if(numbers[i] == item){
                return i;
            }
        }
        return -1;
   }
}
