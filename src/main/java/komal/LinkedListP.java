package komal;

public class LinkedListP {

    public static NodeWithRandom clone(NodeWithRandom node){
        NodeWithRandom head = node;
        NodeWithRandom newNode = node;
        NodeWithRandom next = null;

        while (head!= null){
            NodeWithRandom arbitaryNode = new NodeWithRandom(head.data);
            next = head.next;
            head.next = arbitaryNode;
            head.next.next = next;
            head = next;
        }
        head = node;
       // print(head);

        while (head!= null){
            if(head.next!= null)
                head.next.random = head.random!= null? head.random.next: head.random;
           // head.next = head.next.next.next!= null?head.next.next.next: head.next.next;
           // if(head.next!= null)
             head = (head.next!= null)?head.next.next:head.next;
        }
        newNode = node.next;
        head = node;
        NodeWithRandom copy = newNode;

        while (head!= null){
            head.next = head.next!= null? head.next.next:head.next;
            copy.next = copy.next!= null? copy.next.next:copy.next;

            head = head.next;
            copy = copy.next;
        }


        return newNode;
    }

    public static void main(String[] args) {
        NodeWithRandom start = new NodeWithRandom(1);
        start.next = new NodeWithRandom(2);
        start.next.next = new NodeWithRandom(3);
        start.next.next.next = new NodeWithRandom(4);
        start.next.next.next.next = new NodeWithRandom(5);

        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        NodeWithRandom nodeWithRandom = clone(start);
        print(nodeWithRandom);


    }
    static void print(NodeWithRandom start)
    {
        NodeWithRandom ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.data +
                    ", Random = "+ptr.random.data);
            ptr = ptr.next;
        }
    }
}
