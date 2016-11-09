package fun.programs;

public class Triangle {

    /**
     *       *
     *      *  *
     *     *    *
     *    * * *  *
     */

    public static void printStar(int n) {
        int l = n/2;
        int r = n/2;
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < n; j++) {
                if(j == l || j == r) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
            l--;
            r++;
        }
        for(int k = 0; k <= n/2; k++) System.out.print("* ");
    }

    public static void print(int n, int l, int r) {
        if (l == r) {
            printSpace(n-l);
            System.out.print("*");
            printSpace(n-l);
            System.out.println("");
        }
        else {
            print(n,l + 1,r - 1);
            printSpace(n-r);
            System.out.print("*");
            printSpace(r-l);
            System.out.print("*");
            printSpace(n-l);
            System.out.println("");
            if (l == 0) for(int k = 0; k <= n/2 + 1; k++) System.out.print("* ");
        }
    }

    private static void printSpace(int n) {
        for(int i = 0; i < n; i++) System.out.print(" ");
    }

    public static void main(String args[]) {
        printStar(100);
    }


}
