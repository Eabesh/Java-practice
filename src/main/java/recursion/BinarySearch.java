package recursion;

import java.util.Vector;

class BinarySearch {

    int search(Vector<Integer> elements, int key, int start, int stop) {
        if (start > stop) return -1;
        else {
            int mid = (start + stop)/2;
            if (elements.elementAt(mid) == key) return mid;
            else if (elements.elementAt(mid) > key) return search(elements,key,start,mid-1);
            else return search(elements,key,mid+1,stop);
        }
    }

}
