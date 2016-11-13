package dynamic.programming;

import java.util.Arrays;

public class BoxStackingProblem {

    class Box implements Comparable<Box>{
        int l;
        int b;
        int h;

        Box(int l, int b, int h) {
            this.l = l;
            this.b = b;
            this.h = h;
        }

        public int compareTo(Box b) {
            return (b.l * b.b - this.l * this.b);
        }
    }

    int boxStacking(int[][] boxes) {
        Box[] b = new Box[3*boxes.length];
        int l = 0;
        for (int k = 0; k < boxes.length; k++) {
            b[l] = new Box(boxes[k][0],boxes[k][1],boxes[k][2]);
            b[l + 1] = new Box(boxes[k][1],boxes[k][2],boxes[k][0]);
            b[l + 2] = new Box(boxes[k][2],boxes[k][0],boxes[k][1]);
            l += 3;
        }
        Arrays.sort(b);
        int[] lis = new int[b.length];
        for (int h = 0; h < b.length; h++) lis[h] = b[h].h;
        int maxSoFar = 0;
        for (int i = 1; i < b.length; i++) {
            int max = b[i].h;
            for (int j = 0; j < i; j++) {
                if (b[i].l < b[j].l && b[i].b < b[j].b)
                    max = Math.max(max, lis[j] + b[i].h);
            }
            lis[i] = max;
            maxSoFar = Math.max(maxSoFar,max);
        }
        return maxSoFar;
    }

}
