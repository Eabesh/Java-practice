package komal.LRU;

import java.util.HashMap;

public class LRUClass {
    private HashMap<Integer,LRUEntry> map = null;
    private int size;
    private LRUEntry start, end;

    LRUClass(int size){
        this.size = size;
        map = new HashMap<>();
    }

    public void putKey(int key, int value){
        if(map.containsKey(key)){
            LRUEntry fetchedVal = map.get(key);
            fetchedVal.value = value;
            removeNode(fetchedVal);
            addAtTop(fetchedVal);
        }
        else {
            LRUEntry node = new LRUEntry(value,key);
            if(map.size()> size){
                map.remove(end.key);
                removeNode(end);
                addAtTop(node);
            }
            else {
                addAtTop(node);
            }
            map.put(key,node);
        }
    }

    public void addAtTop(LRUEntry node){
        node.right = start;
        node.left = null;
        if(start!= null){
            start.left = node;
        }
        start = node;
        if(end== null)
            end = start;
    }

    public void removeNode(LRUEntry node){

        if(node.left!= null){
            node.left.right = node.right;
        }else {
            start = node.right;
        }

        if(node.right!= null){
            node.right.left = node.left;
        }else {
            end = node.left;
        }
    }

    public int getValue(int key){
        if(map.containsKey(key)){
            LRUEntry node = map.get(key);
            removeNode(node);
            addAtTop(node);
            return node.value;
        }
        return -1;
    }


    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        LRUClass lrucache = new LRUClass(2);
        lrucache.putKey(1, 1);
        lrucache.putKey(10, 15);
        lrucache.putKey(15, 10);
        lrucache.putKey(10, 16);
        lrucache.putKey(12, 15);
        lrucache.putKey(18, 10);
        lrucache.putKey(13, 16);

        System.out.println(lrucache.getValue(1));
        System.out.println(lrucache.getValue(10));
        System.out.println(lrucache.getValue(13));

    }

}
