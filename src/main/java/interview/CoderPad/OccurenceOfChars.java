package interview.CoderPad;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccurenceOfChars {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
       //koma printNumberOfoccurences(string);
        FirstNonRepeatingChar firstNonRepeatingChar = new FirstNonRepeatingChar();
        System.out.println(firstNonRepeatingChar.firstNonRepeatingChar(string));


    }

     public static  void  printNumberOfoccurences(String string){
        System.out.println("String is "+string);
        Map<Character,Integer> map  = new HashMap<>();

        int count = 0;
        for(int i =0; i<string.length(); i++){
            if(map.containsKey(string.charAt(i)))
            {
                count = map.get(string.charAt(i));
                map.put(string.charAt(i),++count);
            }
            else
                map.put(string.charAt(i),1);
        }
        System.out.println("occurences are "+ map);

    }

}
