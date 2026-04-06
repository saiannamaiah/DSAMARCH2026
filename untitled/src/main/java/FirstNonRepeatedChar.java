import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

    public char findFirstNonRepeatedValue(String value){
       Map<Character,Integer> map = new HashMap<>();

        for(var ch : value.toCharArray()){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count + 1);
            
        }
        for (var ch : value.toCharArray()){
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
}
