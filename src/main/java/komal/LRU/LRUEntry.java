package komal.LRU;


public class LRUEntry {
    public int value;
    public int key;
    public LRUEntry left;
    public LRUEntry right;

    LRUEntry(int value, int key){
        this.value = value;
        this.key = key;
        left = right = null;
    }
}
