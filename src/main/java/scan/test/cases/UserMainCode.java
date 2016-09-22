package scan.test.cases;

/**
 * Created by pankaj.thakur on 21/09/16.
 */
public class UserMainCode {

    public static String GetSubString(String input1, String input2) {
        int start = -1;
        int end = 0;
        for(int i = 0; i < input1.length(); i++) {
            end = i;
            int j = i;
            while(!input2.isEmpty() && j < input1.length()) {
                if(input2.contains("" + input1.charAt(i))) {
                if (start <  0) start = i;
                    input2 = input2.substring(0,input2.indexOf(input1.charAt(i)))
                            + input2.substring(input2.indexOf(input1.charAt(i)) + 1);
                    end++;
                }
                j++;
            }
        }
        return input1.substring(start,end-1);
        //throw new UnsupportedOperationException("GetSubString(String input1,String input2)");

    }

    public static void main(String[] args) {
        String input1 = "My name is Fran";
        String input2 = "rim";
        String res = GetSubString(input1,input2);
        String t = res;
    }

}
