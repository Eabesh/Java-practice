package komal;

public class LinkedListClass {
    static Lnode node;
    static class Lnode {
        int data;
        Lnode next;

        public Lnode(int data) {
            this.data = data;
            next = null;
        }
    }
    public void push(int data) {
        Lnode new_node = new Lnode(data);
        new_node.next = node;
        node = new_node;

    }

    public static void inverseInPair(Lnode lnode){
        Lnode tmp;
        if(lnode == null || lnode.next == null)
            return ;
        else {
            tmp = lnode.next;
            lnode.next = tmp.next;
            tmp.next = lnode;

            inverseInPair(lnode.next);
        }
    }
    public Lnode inverse(Lnode node){
        Lnode prev = null;
        Lnode next = null;

        while (node!= null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    static Lnode prevR = null;
    static Lnode nextR = null;
    public static void inverseRec(Lnode lnode){
        if(lnode == null)
            return;
        else {
            nextR = lnode.next;
            lnode.next = prevR;
            prevR = lnode;
            lnode = nextR;
            inverseRec(lnode);
        }
    }

    public static void main(String[] args) {
        LinkedListClass linkedList = new LinkedListClass();
       // linkedList.n = new Lnode(1);
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        //     LinkedListClass lnode=  linkedList;
       /* while(lnode!= null){
            System.out.println("lnode before is "+ lnode.data);
            lnode = lnode.next;
        }*/


        Lnode lnode2 = linkedList.inverse(node);
        while(lnode2!= null){
            System.out.println("lnode is "+ lnode2.data);
            lnode2 = lnode2.next;
        }
         /*  while(recNode!= null){
               System.out.println("Rlnode is "+ recNode.data);
               recNode = recNode.next;
           }

           inverseRec(recNode);
           while(prev!= null){
               System.out.println("lnoder is "+ prev.data);
               prev = prev.next;
           }*/
    }
}
