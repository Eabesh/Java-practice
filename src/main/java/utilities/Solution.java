package utilities;

import java.util.*;

/**
 * Created by abhay on 09/02/17.
 */
public class Solution {

    static HashSet<Integer> infectedSet = new HashSet<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numOfPeople = in.nextInt();
        Map<Integer, Vector<Integer>> tree = new HashMap<>();
        Vector<Integer> colors = new Vector<>();
        for (int i = 0; i < numOfPeople - 1; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            if (tree.containsKey(key)) {
               Vector<Integer> values = tree.get(key);
               values.add(value);
               tree.put(key, values);
            } else tree.put(key, new Vector<Integer>(Collections.singletonList(value)));
        }
        for (int i = 0; i < numOfPeople; i++) {
            colors.add(in.nextInt());
        }
        int attacks = in.nextInt();
        for (int i = 0; i < attacks; i++) {
           getInfectedCount(in.nextInt(),tree, colors);
        }
    }

    public static void getInfectedCount(int attackedPerson, Map<Integer, Vector<Integer>> tree, Vector<Integer> colors) {
        infectedSet.add(attackedPerson);
        int color = colors.elementAt(attackedPerson - 1);
        addToSet(tree, attackedPerson, color, colors);
        System.out.println(infectedSet.size());
    }

    public static void addToSet(Map<Integer, Vector<Integer>> tree, Integer key, Integer color, Vector<Integer> colors) {
        if (!tree.containsKey(key)) return;
        else {
            Vector<Integer> values = tree.get(key);
            for (Integer v : values) {
                if (color == colors.elementAt(v -1).intValue())
                    infectedSet.add(v);
                addToSet(tree,v,color,colors);
            }
        }
    }
}
