package recursion;

class Subset {

    void subset(String soFar, String remaining) {
        if (remaining.length() == 0) System.out.println(soFar);
        else {
            String next = remaining.substring(1);
            subset(soFar, next);
            subset(soFar + remaining.charAt(0), next);
        }
    }

}
