package interview.CoderPad;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstNonRepeatingChar {

    public Character firstNonRepeatingChar(String string){
        Map<Character,Integer> map = new TreeMap<>();
        int count = 0;
        int flagCount = -1;
        for(int i = 0 ; i< string.length();i++){
            if(map.containsKey(string.charAt(i)))
            {
                count = map.get(string.charAt(i));
                map.put(string.charAt(i),++count);
                if(flagCount > -1)
                 flagCount = -1;
            }
            else {
                map.put(string.charAt(i), 1);
                if(flagCount == -1 )
                    flagCount = i;
            }
        }

        System.out.println("first is "+ string.charAt(flagCount) + " flag is "+ flagCount);

        /*for(Character character : map.keySet())
        {
            if(map.get(character) == 1)
                return character;
        }*/
        System.out.println("not found");
return null;
    }
}
