package recursion;

class Subset {

    void subset(String sofar, String remaining) {
        if (remaining.length() == 0) System.out.println(sofar);
        else {
            String next = remaining.substring(1);
            subset(sofar,next);
            subset(sofar+remaining.charAt(0),next);
        }
    }

}
