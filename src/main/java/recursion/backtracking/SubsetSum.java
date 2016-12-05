package recursion.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Find subset of elements that are selected from a given set whose sum adds up to a given number K.
 */
class SubsetSum {

    boolean find(HashSet<Integer> subset, int[] array, int sum) {
        if (subset.stream().collect(Collectors.summingInt(e -> (Integer)e)) == sum) return true;
        else if (array.length == 0) return false;
        else {
            HashSet<Integer> next = new HashSet<Integer>();
            next.addAll(subset);
            if (find(next, Arrays.copyOfRange(array, 1, array.length), sum)) return true;
            next.add(array[0]);
            if (find(next, Arrays.copyOfRange(array, 1, array.length), sum)) return true;
        }
        return false;
    }

}
