package komal;

import utilities.ListNode;
import utilities.TreeNode;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Array;
import java.util.*;

public class DailyPractice {

        static ArrayList<Integer> resultArray;
        static ArrayList<Integer> finalResultArray;

        public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
            if(A == null)
                return null;
            resultArray = A;
            int size = A.size();
            int resultValue = 0;
            int resultQ = 0;

            int modifiedValue = A.get(size-1)+1;
            if(modifiedValue > 9)
            {
                resultValue = modifiedValue % 10;
                resultQ = modifiedValue/10;
                resultArray.set(size-1,resultValue);
                List<Integer> newArray = A.subList(0, size-1);
                plusDigit(newArray,resultQ);
            }
            else
                resultArray.set(size-1, modifiedValue);
            if(finalResultArray != null )
                return finalResultArray;

            return resultArray;


        }
        private static void plusDigit(List<Integer> A, int digit) {
            // System.out.println("array is "+ A + " and digit is "+ digit);
            if(A == null)
                return ;
            int size = A.size();
            int resultValue = 0;
            int resultQ = 0;
            if(size == 0)
            {
                finalResultArray = new ArrayList<Integer>();
                finalResultArray.add(digit);
                for(int i=0; i< resultArray.size(); i++){
                    finalResultArray.add(resultArray.get(i));
                }
                return;
            }

            int modifiedValue = A.get(size-1)+1;
            if(modifiedValue > 9)
            {
                resultValue = modifiedValue % 10;
                resultQ = modifiedValue/10;
                resultArray.set(size-1,resultValue);
                List<Integer> newArray = A.subList(0, size-1);
                plusDigit(newArray,resultQ);
            }
            else
                resultArray.set(size-1, modifiedValue);
        }



    /*3rd question*/

    public int maxArr(ArrayList<Integer> A) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int size = A.size();
        if(size ==1)
            return 0;
        for(int i = 0; i<= size-1; i++){
            max1 = Math.max(max1, A.get(i)+i);
            min1 = Math.min(min1, A.get(i)+i);
            max2 = Math.max(max2, A.get(i)-i);
            min2 = Math.min(min2, A.get(i)-i);
        }
        int diff = Math.max(max1-min1, max2-min2);
        return diff;
    }

    /*4th*/
    public ArrayList<Integer> repeatedAndMissingNumber(final List<Integer> A) {

        int size = A.size();
        // long factorialOfN = factorial(Long.valueOf(size));
        long sqSumOfN = sumSqr(Long.valueOf(size));
        long sumOfN = (Long.valueOf(size)*(Long.valueOf(size)+1))/2;
        long sum = 0;
        long prod = 1;
        long sqSum =0;

        for(int n :A){
            sum+= Long.valueOf(n);
            //   prod *= Long.valueOf(n);
            sqSum += (Long.valueOf(n)*Long.valueOf(n));
        }

        long x;
        long y;
        // x = (sumOfN - sum)/(1-(prod/factorialOfN));
        y = (sumOfN -sum +((sqSumOfN - sqSum)/(sumOfN-sum)))/2;
        x = sum -sumOfN +y;
        ArrayList<Integer> result= new ArrayList<Integer>();
        result.add((int)x);
        result.add((int)y);
        return result;
    }

    /*private long factorial(long n){
        if( n== 0)
        return 1;
        else return (n* factorial(n-1));
    }*/

    private long sumSqr(long n){
        return ((n*(n+1)*(2*n+1))/6);
    }

    /*5th*/
    public int repeatedNumber(final List<Integer> a) {
        int size = a.size();
        if(size ==1)
            return -1;
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();

        for(int n : a){
            if(countMap.containsKey(n))
                return n;
            else
                countMap.put(n,1);
        }

        return -1;
    }

    /*6th*/
    public static int firstMissingPositive(int[] A) {
        int size = A.length;

        if (size == 1) {
            if (A[0] <= 0)
                return 1;
            if (A[0] == 1)
                return 2;
        }
        int count = 1;
        for (int integer : A) {
            if (integer <= 0 || integer > size)
                continue;
            if(count <= integer)
                count = count+1;
          //  count = count >= n ? count + 1 : count;
        }
        return count;
    }/*not working */
   /* public static void main (String[] args)
    {
        int arr[] = {0, 10, 2, -10, -20};
        int arr_size = arr.length;
        int missing = firstMissingPositive(arr);
        System.out.println("The smallest positive missing number is "+
                missing);
    }*/
    /*7th*/
    static void findSymPairs(int arr[][])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // First and second elements of current pair
            int first = arr[i][0];
            int sec   = arr[i][1];

            // Look for second element of this pair in hash
            Integer val = hM.get(sec);

            // If found and value in hash matches with first
            // element of this pair, we found symmetry
            if (val != null && val == first)
                System.out.println("(" + sec + ", " + first + ")");

            else  // Else put sec element of this pair in hash
                hM.put(first, sec);

            System.out.println("hm is "+hM);
        }
    }

    // Drive method
   /* public static void main(String arg[])
    {
       *//* int arr[][] = new int[5][2];
        arr[0][0] = 11; arr[0][1] = 20;
        arr[1][0] = 30; arr[1][1] = 40;
        arr[2][0] = 30;  arr[2][1] = 10;
        arr[3][0] = 40;  arr[3][1] = 30;
        arr[4][0] = 10;  arr[4][1] = 5;
        findSymPairs(arr);*//*

        ArrayList<Integer> arr;
        arr = new ArrayList<>();

        //output should be 6054854654
        arr.add(54);
        arr.add(546);
        arr.add(548);
        arr.add(60);

        System.out.println("result is "+ largestNumber(arr));
    }*/

    /* 8th -Given a list of non negative integers, arrange them such that they form the largest number.*/
    public static String largestNumber(ArrayList<Integer> A){
        ArrayList<String> arrayList = new ArrayList<>();
        for(Integer n : A)
            arrayList.add(n.toString());
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String XY = o1+o2;
                String YX = o2+o1;

                return XY.compareTo(YX) > 0?-1:1;
            }
        });
        String result="";
        for(String string :arrayList){
            if(result.isEmpty() && string.equals("0"))
                continue;
            result+=string;
        }
        return result;
    }

    /*9th - heap sort*/

    public static void heapSort(int[] arrayList){
        int size = arrayList.length;

        for(int i = size/2-1;i >=0 ;i--){
            heapify(arrayList,size,i);
        }
        System.out.println("heap array is ");
        for(Integer integer:arrayList)
            System.out.print(integer+",");

        for(int i = size-1; i>0; i--){
            int tmp = arrayList[0];
            arrayList[0] = arrayList[i];
            arrayList[i] = tmp;
            heapify(arrayList,i,0);
        }
        System.out.println("sorted heap array is ");
        for(Integer integer:arrayList)
            System.out.print(integer+",");

    }

    private static void heapify(int[] arrayList,int n, int i){
        int l = 2*i +1;
        int r = 2*i +2;
        int max=i;

        if( l<n && arrayList[l]> arrayList[max])
            max = l;
        if(r<n && arrayList[r]> arrayList[max])
            max = r;

        if(max != i){
            int tmp = arrayList[i];
            arrayList[i] = arrayList[max];
            arrayList[max] = tmp;
            heapify(arrayList,n,max);
        }
    }
   /* public static void main(String args[])
    {
        int arr[] = {2,12, 11, 13, 5, 6, 7};
       // heapSort(arr);

        int size = arr.length;

        for(int i = size/2-1;i >=0 ;i--){
            heapify(arr,size,i);
        }
        System.out.println("heap array is ");

        System.out.println("");
        for(Integer integer:arr)
            System.out.print(integer+",");

        int arr2[] = {2,12, 11, 13, 5, 6, 7};

        ArrayList<Integer> al =
                new ArrayList<Integer>();



        PriorityQueue<Integer> queue = new PriorityQueue(arr2.length, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return  (int)o1 <(int)o2?1:-1;
            }
        });

        for (Integer geek : arr2)
            queue.add(geek);
        System.out.println("pri array is ");

        for (Integer geek : queue) {
            System.out.print(geek+",");
        }


    }*/

    /*stack - find middle element*/

    public static int count=0;
    public static int mid = -1;
    public static int midElementOfStack(Stack<Integer> s,int currentCount){
            if (!s.empty()) {
                int x = s.pop();
                ++count;
                midElementOfStack(s, currentCount + 1);

                System.out.println("count is " + count + " cu is " + currentCount);
                if (currentCount == (count / 2)) {
                    System.out.println("here "+currentCount +" "+ count/2 + " "+x);
                    mid = x;
                }

            }

        return mid;
    }

  /*  public static void main(String args[])
    {
        Stack<Integer> st = new Stack<>();

        //push elements into the stack
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(0);
        st.push(7);
        st.push(7);
        st.push(7);
        st.push(7);
        st.push(7);
        st.push(7);
        int x = midElementOfStack(st, 0);
        System.out.println("answer is "+x);
    }
*/
    /*vertical traversal of BT*/

    private static class TreeNodeH{
        TreeNode node;
        int height;

        TreeNodeH(TreeNode node, int height){
            this.node = node;
            this.height = height;
        }
    }

    /*using level order*/
    public static void verticalTraversalOfBtLevel(TreeNode node){
        Queue<TreeNodeH> queue = new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>> hMap = new TreeMap<>();
        int horizontalDis = 0;

        TreeNodeH treeNodeH = new TreeNodeH(node,horizontalDis);
        queue.add(treeNodeH);
        ArrayList<Integer> list = null;
        while(!queue.isEmpty()){
            TreeNodeH temp = queue.poll();
            TreeNode tempNode = temp.node;
            int h = temp.height;
            if(hMap.containsKey(h)){
                hMap.get(h).add(tempNode.data);
            }
            else{
                list = new ArrayList<>();
                list.add(tempNode.data);
                hMap.put(h,list);
            }
            if(tempNode.left != null)
                queue.add(new TreeNodeH(tempNode.left,h-1));

            if(tempNode.right != null)
                queue.add(new TreeNodeH(tempNode.right,h+1));

        }

        for(Integer integer: hMap.keySet()){
            System.out.println("level - "+ integer+" "+hMap.get(integer));
        }

    }

    /*using pre order*/
    public static void verticalTraversalOfBtpreOrderUtil(TreeNode node,TreeMap<Integer,ArrayList<Integer>> hMap,int hd){

        if(node == null)
            return;
        ArrayList<Integer> list = null;
     //   System.out.println("data is "+node.data + " hd is "+hd);
        if(hMap.containsKey(hd)){
            hMap.get(hd).add(node.data);
        }
        else{
            list = new ArrayList<>();
            list.add(node.data);
            hMap.put(hd,list);
        }


        verticalTraversalOfBtpreOrderUtil(node.left,hMap,hd-1);
        verticalTraversalOfBtpreOrderUtil(node.right,hMap,hd+1);

    }

    public static void verticalTraversalOfBtpreOrder(TreeNode node){
        TreeMap<Integer,ArrayList<Integer>> hMap = new TreeMap<>();
        int hd = 0;
        verticalTraversalOfBtpreOrderUtil(node,hMap,hd);
        for(Integer integer: hMap.keySet()){
            System.out.println("level - "+ integer+" "+hMap.get(integer));
        }

    }

    /*bottom view */
    private static void bottomViewUtil(TreeNode node, TreeMap<Integer,Integer> map,int hd){

        if(node == null)
            return;
        else {
            map.put(hd,node.data);
            bottomViewUtil(node.left,map,hd-1);
            bottomViewUtil(node.right,map,hd+1);
        }

    }
    public static void bottomViewOfBtUsingPre(TreeNode node){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int hd = 0;
        bottomViewUtil(node,map,hd);
        for(Integer integer: map.keySet()){
            System.out.println(""+ integer+"- "+map.get(integer));
        }
    }

    /*using level order*/
    public static void bottomViewOfBtLevel(TreeNode node){
        Queue<TreeNodeH> queue = new LinkedList<>();
        TreeMap<Integer,Integer> hMap = new TreeMap<>();
        int horizontalDis = 0;

        TreeNodeH treeNodeH = new TreeNodeH(node,horizontalDis);
        queue.add(treeNodeH);
        while(!queue.isEmpty()){
            TreeNodeH temp = queue.poll();
            TreeNode tempNode = temp.node;
            int h = temp.height;
            hMap.put(h,tempNode.data);

            if(tempNode.left != null)
                queue.add(new TreeNodeH(tempNode.left,h-1));

            if(tempNode.right != null)
                queue.add(new TreeNodeH(tempNode.right,h+1));

        }

        System.out.println("hmap is "+ hMap);
        for(Integer integer: hMap.keySet()){
            System.out.println("level - "+ integer+" "+hMap.get(integer));
        }

    }

   /* public static void main(String[] args) {
       *//* TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);*//*


    }*/


    /*
     TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        topViewOfBt(root);
    hmap is {-2=5, -1=10, 0=4, 1=14, 2=25}
level - -2 5
level - -1 10
level - 0 4
level - 1 14
level - 2 25
*/
    //bottom view should be implemented by level order not pre order

    public static void topViewOfBt(TreeNode node){
        TreeMap<Integer,ArrayList<Integer>> hashMap = new TreeMap<>();
        Queue<TreeNodeH> treeNodeHS = new LinkedList<>();
        TreeNodeH treeNodeH = new TreeNodeH(node,0);
        treeNodeHS.add(treeNodeH);
        ArrayList<Integer> arrayList;
        while (!treeNodeHS.isEmpty()){
            TreeNodeH tmp = treeNodeHS.remove();
            int h = tmp.height;
            if(hashMap.containsKey(h)){
                hashMap.get(h).add(tmp.node.data);
            }
            else {
                arrayList = new ArrayList<>();
                arrayList.add(tmp.node.data);
                hashMap.put(h,arrayList);
            }
            if(tmp.node.left!= null){
                treeNodeHS.add(new TreeNodeH(tmp.node.left,h-1));
            }
            if(tmp.node.right!= null){
                treeNodeHS.add(new TreeNodeH(tmp.node.right,h+1));
            }
        }

        System.out.println("top view map is "+ hashMap);
        for(Integer integer : hashMap.keySet()){
            System.out.print(" "+ hashMap.get(integer).get(0));
        }
    }

   /* public static void main(String[] args) {

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.right.left.right = new TreeNode(8);
            root.right.right.right = new TreeNode(9);
           // root.right.right.left= new TreeNode(10);
           // root.right.right.left.right= new TreeNode(11);
           // root.right.right.left.right.right= new TreeNode(12);
        verticalTraversalOfBtLevel(root);
        verticalTraversalOfBtpreOrder(root);

    }*/

   public static ListNode reverseIterative(ListNode node){
       ListNode current = node;
       ListNode prev = null;
        ListNode next = null;
       if(current == null)
           return null;
       else{
           while(current!= null){
               next = current.next;
               current.next = prev;
               prev = current;
               current = next;
           }
       }
       return  prev;
   }

   public static ListNode prev = null;
   public static ListNode next = null;
   public static void reverseRec(ListNode node){
       if(node == null)
           return ;
       else
       {
           ListNode current = node;
            next = current.next;
           current.next = prev;
            prev = current;
           current = next;
           reverseRec(current);
       }
   }


    public static ListNode reverseKelementRec(ListNode node,int count){

        int numOfElements = populateCount(node);
        if(numOfElements < count)
            return node;
        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;
        int c = 0;
        if(node == null)
            return null;
        else
            while (current != null && c<count)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            c++;
        }
        if(next != null) {
            node.next = reverseKelementRec(next, count);
        }
        return prev;
    }
    public static ListNode reverseKelementIte(ListNode node,int count){
        ListNode head = node;
        while(head!= null) {
            ListNode current = head;
            ListNode prev = null;
            ListNode next = null;
            int c = 0;
            if (current == null)
                return null;
            else
                while (current != null && c < count) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                    c++;
                }

        }
        return head;
    }

    private static int populateCount(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    private static ListNode rr(ListNode head) {
        ListNode current = head, previous = null, next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
   /* public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
       // System.out.println("mid is "+midElement(listNode));
       // ListNode listNode2 = listNode;
        ListNode kReversed = reverseKelementRec(listNode,4);
        printList(kReversed);
       *//* reverseRec(listNode2);  //  recursive reverse
        printList(prev);

        ListNode resultNode = rr(listNode);
        printList(resultNode);

        System.out.println("new size is "+populateCount(resultNode));

        printList(resultNode);
        printList(listNode);*//*
      //  System.out.println(""+populateCount(listNode));

    }*/
    public static int midElement(ListNode node){
       ListNode slow = node;
       ListNode fast = node;

       while(fast!= null && fast.next != null ){
           slow = slow.next;
           fast = fast.next.next;
       }

       return slow.data;

    }

    public static void  printList(ListNode resultNode){
        while(resultNode!= null) {
            System.out.println("" + resultNode.data);
            resultNode = resultNode.next;
        }

    }

    public static boolean removeExtra(){
        ArrayList<String> A = new ArrayList<>();
        String str = "A man, a plan, a canal: Panamaa";
        String str2 = str.toLowerCase().replaceAll("\\W+","");
        System.out.println(str2);
        String[] strList = str.trim().split("\\W+");
        String result="";
        for(String string : strList)
            result+=string.toLowerCase();

        System.out.println(result);

        int size = result.length();
        int i = 0, j= size-1;
        while(i< size/2){
            if(result.charAt(i) == result.charAt(j)) {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }

   /* public static void main(String[] args) {
        System.out.println(""+removeExtra());
    }*/



    public String longestCommonPrefix(ArrayList<String> A) {

        int size = A.size();
        if(size == 0)
            return "";

        String commonStr = A.get(0);
        A.remove(commonStr);

        Integer.toString(1);

        for(String s : A){
            int i = 0;
            int len = s.length();
            int lenC = commonStr.length();
            for(i = 0 ; i< len && i <lenC ; i++){
                //  System.out.println(commonStr +" "+i +" "+ s);


                if(commonStr.charAt(i)!= s.charAt(i))
                    break;
            }
            //System.out.println(commonStr +" -"+i +" -"+ s);
            commonStr = commonStr.substring(0,i);
        }
        return commonStr;

    }
    /*[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
] - solution = a*/

/*The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.*/
    public String countAndSay(int A) {
        if(A==1)
            return "1";

        String firstStr = "11";
        String finalStr ="11";
        String curr = firstStr;

        for(int i = 0 ; i<A-2; i++ ){
            // System.out.println("finalstr "+finalStr +" curr is "+curr);
            curr = finalStr;
            finalStr="";
            char prev = curr.charAt(0);
            int count=1;
            //  System.out.println("prev "+prev +" curr is "+curr);
            for(int j =1 ; j<curr.length(); j++){
                if(curr.charAt(j) == prev){
                    count++;
                }else{
                    finalStr = finalStr + Integer.toString(count)+prev;
                    count =1;
                    prev = curr.charAt(j);
                }
            }
            finalStr = finalStr + Integer.toString(count)+prev;
            //   System.out.println("finalstr- "+finalStr +" curr is- "+curr);

        }
        return finalStr;
    }

    /*matrix questions*/
/*1 - search in sorted matrix*/

    public static void searchElement(int[][] m, int n, int e){
        int i = 0, j = n-1;

        while (i < n && j >=0){
            if(e == m[i][j]){
                System.out.println("element found at "+ i+" , "+j);
                return;
            }
            else if(e < m[i][j])
                j--;
            else
                i++;
        }
        System.out.println("element "+e+" not found");
    }

   /* public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        searchElement(m,4,16);
    }*/


   /*graph - BFS*/
   static class Graph{
       private int vertex;
       private LinkedList<Integer> adj[];

       Graph(int v){
           vertex = v;
           adj = new LinkedList[v];
           for(int i = 0 ; i<v;i++)
               adj[i]= new LinkedList<>();
       }

       void addEdge(int v,int e){
           adj[v].add(e);
       }

       public void BFS(int start){

           Queue queue = new LinkedList();
           boolean[] visited = new boolean[vertex];

           visited[start] = true;
           queue.add(start);

           while (!queue.isEmpty()){
               int tmp = (int)queue.poll();
               System.out.print(" "+tmp);

               for(int n: adj[tmp]){
                   if(!visited[n]){
                       visited[n] = true;
                       queue.add(n);
                   }
               }

           }
       }
   }

    /*public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }*/

    static class MatrixItem{
       int row;
       int col;
       int dis;

       MatrixItem(int row,int col,int dis){
           this.row = row;
           this.col = col;
           this.dis = dis;
       }
    }

    public static int getMinDistance(char[][] mat, int n, int m){
       boolean[][] visited = new boolean[n][m];
       MatrixItem source = new MatrixItem(0,0,0);
       for(int i = 0 ; i< n;i++){
           for(int j =0; j<m ; j++){
               if(mat[i][j]==('0'))
                   visited[i][j] = true;
               else
                   visited[i][j] = false;
               if(mat[i][j]==('s')) {
                   source.row = i;
                   source.col = j;
               }
           }
       }
       Queue<MatrixItem> queue = new LinkedList<>();
        queue.add(source);
        visited[source.row][source.col] = true;
       while (!queue.isEmpty()){
           MatrixItem tmp = queue.poll();
           if(mat[tmp.row][tmp.col]=='d')
               return tmp.dis;
            //up
           if(tmp.row-1 >= 0 && !visited[tmp.row -1][tmp.col]){
               MatrixItem up = new MatrixItem(tmp.row-1,tmp.col,tmp.dis+1);
               queue.add(up);
               visited[tmp.row -1][tmp.col] = true;
           }
           //down
            if(tmp.row+1 < n && !visited[tmp.row +1][tmp.col]){
               MatrixItem down = new MatrixItem(tmp.row+1,tmp.col,tmp.dis+1);
               queue.add(down);
               visited[tmp.row +1][tmp.col] = true;
           }
           //left
            if(tmp.col-1 >= 0 && !visited[tmp.row][tmp.col-1]){
               MatrixItem left = new MatrixItem(tmp.row,tmp.col-1,tmp.dis+1);
               queue.add(left);
               visited[tmp.row][tmp.col-1] = true;
           }
           //right
            if(tmp.col+1 < m && !visited[tmp.row][tmp.col+1]){
               MatrixItem right = new MatrixItem(tmp.row,tmp.col+1,tmp.dis+1);
               queue.add(right);
               visited[tmp.row][tmp.col+1] = true;
           }

       }
       return -1;
    }

   /* public static void main(String[] args) {
        char[][] strings = { { '0', '*', '0', 's' },
                { '*', '0', '*', '*' },
                { '0', '*', '*', '*' },
                { '*', 'd', '*', '*' } };

        System.out.println("dis is "+getMinDistance(strings,4,4));
    }*/

   public static void printInZigZagForm(int[][] mat,int n,int m){
       int i =0;
       int j = 0;
       while(i< n){
           if(i%2 == 0){
               for(j=0 ; j<m ;j++)
                   System.out.print(" "+mat[i][j]);
           }
           if(i%2 == 1){
               for(j=m-1 ; j>=0 ;j--)
                   System.out.print(" "+mat[i][j]);
           }
           i++;
       }

   }

   /* public static void main(String[] args) {
        int r = 3, c = 5;

        int mat[][] = { {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };
        printInZigZagForm(mat , 3, 5);
    }*/

   public static void printInSpiralForm(int[][] mat, int m, int n){
       int k=0; //row
       int l = 0; //col
       int i =0;
       while(k < m && l<n ){
           for(i = l ; i < n; i++ ){
               System.out.print(" "+mat[k][i]);
           }
           k++;
           for(i = k ;i < m ;i++ )
               System.out.print(" "+mat[i][n-1]);
           n--;
           if(k<m){
               for(i = n-1; i >= l ; i--)
                   System.out.print(" "+mat[m-1][i]);
               m--;
           }

           if(l<n){
               for(i = m-1; i >= k ;i--)
                   System.out.print(" "+mat[i][l]);
               l++;
           }
       }
   }

    /*public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        printInSpiralForm(a,R,C);
    }
*/


    /*rotation 90 degree*/

    public static void rotateMatrix(int[][] mat,int m ,int n){
        for(int i = 0 ; i< m/2 ;i++ ){
            for(int j = i; j < n-i-1 ; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][n-i-1];
                mat[j][n-i-1] = mat[n-i-1][m-j-1];
                mat[n-i-1][m-j-1] = mat[m-j-1][i];
                mat[m-j-1][i] = tmp;
            }
        }
    }
    public static void transposeMatrix(int[][] mat,int m,int n){

        for(int i = 0;i < m;i++){
            for(int j = i+1; j< n ;j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                System.out.print(" "+mat[i][j]);
            }
            System.out.println();
        }
    }

   /* public static void main(String[] args) {
        int a[][] = { {1,  2,  3,4},
                {7,  8,  9,6},
                {13, 14, 15,3},
                {45,56,67,78}
        };
        for(int i = 0;i<4;i++){
            for(int j= 0;j<4;j++){
                System.out.print(" "+a[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
        rotateMatrix(a,4,4);
        for(int i = 0;i<4;i++){
            for(int j= 0;j<4;j++){
                System.out.print(" "+a[i][j]);
            }
            System.out.println();
        }
    }*/

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int data = stack.pop();
        reverseStack(stack);
        inserAtTheEndOfTheStack(stack,data);
    }

    private static void inserAtTheEndOfTheStack(Stack<Integer> stack,int data){
        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int tmp = stack.pop();
        inserAtTheEndOfTheStack(stack,data);
        stack.push(tmp);
    }

   /* public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("stack is b "+stack);

        reverseStack(stack);

        System.out.println("stack is "+stack);
    }*/


   /*permutation of string*/

   public static void printPermutation(String string,int start,int end){
       if(start == end){
           System.out.println("String is "+string);
       }
       else {
           for (int i = start; i <= end; i++) {
               string = swap(string, i, start);
               printPermutation(string, start + 1, end);
               string = swap(string, i, start);

           }
       }

   }

   private static String swap(String string,int i , int j){
       char tmp = string.charAt(i);
       char[] chars = string.toCharArray();
       chars[i] = chars[j];
       chars[j] = tmp;
       return String.valueOf(chars);
   }

   /* public static void main(String[] args) {
        String string = "ABC";
       // printPermutation(string,0,2);
        combination("",string);
    }*/

    public static void combination(String output,String string){
       int len = string.length();

       System.out.println(output);

       for(int i = 0; i<len;i++) {
         //  System.out.println(output +" - "+string+ " and i is "+i);
           combination(output + string.charAt(i), string.substring(i + 1));
       }

    }

    static void combo(String prefix, String s)
    {
        int N = s.length();
        System.out.println(prefix +" - "+s);

        for (int i = 0 ; i < N ; i++) {
            System.out.println(prefix +" - "+s+ " and i is "+i);
            combo(prefix + s.charAt(i), s.substring(i + 1));
        }
    }

    public static void printPythagoruosTriplet(int[] arr){
        Arrays.sort(arr);

        int size = arr.length;

        for(int x = size-1; x>=0;x-- ){
            int i = 0;
            int j = x-1;
            int sumx = x*x;
            while( j>i){
                int sumi = i*i;
                int sumj = j*j;

                if(sumi+sumj == sumx){
                    System.out.println(x +" , "+i+" , "+j);
                    break;
                }
                if(sumi+sumj> sumx)
                    j--;
                if(sumi+sumj< sumx)
                    i++;
            }
        }
    }

  /*  public static void main(String[] args) {
        int[] arr = {3,2,5,6,7,8,3};
        printNextGreaterElement(arr);
    }*/

    public static void printNextGreaterElement(int[] arr){

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int current;
        int next;
        for(int i =1; i< arr.length; i++){
            next = arr[i];
            if(!stack.isEmpty()) {
                current = stack.pop();
                if((current < next)) {
                    while (current < next) {
                        System.out.println(current + " - " + next);
                        if (!stack.isEmpty())
                            current = stack.pop();
                        else
                            break;
                    }
                }
                else
                    stack.push(current);
            }
            stack.push(next);
        }
        while (!stack.isEmpty()){
            current = stack.pop();
            System.out.println(current +" -> -1");
        }
    }
    static ListNode node1;
    static ListNode node2;
    static ListNode resultNode;
    static ListNode current;
    static int carry;

    private static void push(int data, int list){
        ListNode listNode = new ListNode(data);
        if(list == 1){
            listNode.next = node1;
            node1 = listNode;
        }
        else if(list == 2){
            listNode.next = node2;
            node2 = listNode;
        }
        else {
            listNode.next = resultNode;
            resultNode = listNode;
        }
    }
    private static int sizeOfList(ListNode node){
        ListNode head = node;
        int size =0;
        if(head == null)
            return size;
        else{
            while(head!= null){
                size++;
                head = head.next;
            }
        }
        return size;
    }

    private static void addSameLists(ListNode head1, ListNode head2){
        if(head1 == null)
            return;

        addSameLists(head1.next,head2.next);
        int sum = 0;
        sum = head1.data + head2.data + carry;
        push(sum%10 , 0);
        carry = sum /10;

    }

    private static void addProgatedToSum(ListNode node){
        if (node != current){

            addProgatedToSum(node.next);
            int sum = carry +node.data;
            carry = sum/10;
            sum = sum%10;
            push(sum,0);

        }


    }

    private static void addLists(){
        int size1 = sizeOfList(node1);
        int size2 = sizeOfList(node2);

        if(size1 == 0) {
            resultNode = node2;
            return;
        }

        if(size2 == 0) {
            resultNode = node1;
            return;
        }
        if(size1 == size2)
            addSameLists(node1,node2);
        else {
            int diff = 0;
            if(size1 > size2){
               diff = size1 - size2;
            }
            else {
                diff = size2 -size1;
                ListNode tmp = node1;
                node1 = node2;
                node2 = tmp;
            }
            current = node1;
            while (diff >0){
                current = current.next;
                diff--;
            }

            addSameLists(current,node2);
            addProgatedToSum(node1);
            if(carry >0)
                push(carry,0);
        }

    }

   /* public static void main(String[] args) {
        int[] arr1 = {9,7,8};
        int[] arr2 = {10,9,2,1};

        for (int i = arr1.length - 1; i >= 0; --i)
            push(arr1[i], 1);

        for (int i = arr2.length - 1; i >= 0; --i)
            push(arr2[i], 2);

        addLists();
        printList(resultNode);
    }*/

    static void printlist(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Tree node class
    static class Node
    {
        int data; //data of the node
        int hd; //horizontal distance of the node
        Node left, right; //left and right references

        // Constructor of tree node
        public Node(int key)
        {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    //Tree class
   static class Tree
    {
        Node root; //root node of tree

        // Default constructor
        public Tree() {}

        // Parameterized tree constructor
        public Tree(Node node)
        {
            root = node;
        }

        // Method that prints the bottom view.
        public void bottomView()
        {
            if (root == null)
                return;

            // Initialize a variable 'hd' with 0 for the root element.
            int hd = 0;

            // TreeMap which stores key value pair sorted on key value
            Map<Integer, Integer> map = new TreeMap<>();

            // Queue to store tree nodes in level order traversal
            Queue<Node> queue = new LinkedList<Node>();

            // Assign initialized horizontal distance value to root
            // node and add it to the queue.
            root.hd = hd;
            queue.add(root);

            // Loop until the queue is empty (standard level order loop)
            while (!queue.isEmpty())
            {
                Node temp = queue.remove();

                // Extract the horizontal distance value from the
                // dequeued tree node.
                hd = temp.hd;

                // Put the dequeued tree node to TreeMap having key
                // as horizontal distance. Every time we find a node
                // having same horizontal distance we need to replace
                // the data in the map.
                map.put(hd, temp.data);

                // If the dequeued node has a left child add it to the
                // queue with a horizontal distance hd-1.
                if (temp.left != null)
                {
                    temp.left.hd = hd-1;
                    queue.add(temp.left);
                }
                // If the dequeued node has a left child add it to the
                // queue with a horizontal distance hd+1.
                if (temp.right != null)
                {
                    temp.right.hd = hd+1;
                    queue.add(temp.right);
                }
            }

            // Extract the entries of map into a set to traverse
            // an iterator over that.
            for(Integer integer: map.keySet()){
                System.out.println("level - "+ integer+" "+map.get(integer));
            }
        }
    }
   /* public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Tree tree = new Tree(root);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }*/

   public static void tryCatchTest(){
       try{
           int i = 3;
           try{
               int j = 4/0;
           }catch (Exception e){
               System.out.println("here inner");
           }
       }catch (Exception e){
           System.out.println("here upper");
       }
   }

    /*public static void main(String[] args) throws Throwable {
       // tryCatchTest();
        File geoipCountryFile = new File("/data/db/geodb/GeoIP2-Country.mmdb");

        //FileUtils.copyURLToFile(url, geoipCountryFile);
        downloadFileFromURL("https://s3-ap-southeast-1.amazonaws.com/bsy/maxmind/GeoIP2-Country.mmdb",geoipCountryFile);

    }*/

    private static Path download(String sourceURL, String targetDirectory) throws IOException
    {
        URL url = new URL(sourceURL);
        String fileName = sourceURL.substring(sourceURL.lastIndexOf('/') + 1, sourceURL.length());
        Path targetPath = new File(targetDirectory + File.separator + fileName).toPath();
        Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        return targetPath;
    }

    public static void downloadFileFromURL(String urlString, File destination) throws Throwable {

        URL website = new URL(urlString);
        try(
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(destination);
        ){
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }

    }

    public static int saveUrl(final Path file, final URL url,
                              int secsConnectTimeout, int secsReadTimeout) throws IOException {
        Files.createDirectories(file.getParent()); // make sure parent dir exists , this can throw exception
        URLConnection conn = url.openConnection(); // can throw exception if bad url
        if( secsConnectTimeout > 0 ) conn.setConnectTimeout(secsConnectTimeout * 1000);
        if( secsReadTimeout > 0 ) conn.setReadTimeout(secsReadTimeout * 1000);
        int ret = 0;
        boolean somethingRead = false;
        try (InputStream is = conn.getInputStream()) {
            try (BufferedInputStream in = new BufferedInputStream(is); OutputStream fout = Files
                    .newOutputStream(file)) {
                final byte data[] = new byte[8192];
                int count;
                while((count = in.read(data)) > 0) {
                    somethingRead = true;
                    fout.write(data, 0, count);
                }
            }
        } catch(java.io.IOException e) {
            int httpcode = 999;
            try {
                httpcode = ((HttpURLConnection) conn).getResponseCode();
            } catch(Exception ee) {}
            if( somethingRead && e instanceof java.net.SocketTimeoutException ) ret = 1;
            else if( e instanceof FileNotFoundException && httpcode >= 400 && httpcode < 500 ) ret = 2;
            else if( httpcode >= 400 && httpcode < 600 ) ret = 3;
            else if( e instanceof java.net.SocketTimeoutException ) ret = 4;
            else if( e instanceof java.net.ConnectException ) ret = 5;
            else if( e instanceof java.net.UnknownHostException ) ret = 6;
            else throw e;
        }
        return ret;
    }

    public static void findFrequency(int[] arr){

        int size = arr.length;
        int i = 0;
        int elementIndex = 0;
        while(i<size){
            if(arr[i] <= 0){
                i++;
                continue;
            }
            elementIndex = arr[i] -1;

            if(arr[elementIndex] > 0){
                arr[i] = arr[elementIndex];
                arr[elementIndex] = -1;
            }
            else {
                arr[elementIndex] -= 1;
                arr[i] = 0;
                i++;
            }
        }

        for(int j = 0 ; j<size ; j++){
            System.out.println("freq of "+(j+1)+" is "+ Math.abs(arr[j]));
        }
    }


   /* public static void main(String[] args) {

        int[] arr = {1,2,2,3,3};
        findFrequency(arr);
    }
    *//*freq of 1 is 1
freq of 2 is 2
freq of 3 is 2
freq of 4 is 0
freq of 5 is 0
*/

 /*stock span problem*/

 public static int[] stockSpanProblem(int[] arr){
     int size = arr.length;
     int[] count = new int[size] ;
     count[0] = 1;
     int counter =0;
     for(int i = 1; i< size; i++){
         counter = 1;
         while(i-counter>=0 && arr[i] > arr[i-counter]){
             counter += count[i-counter];
         }
         count[i]= counter;

     }
     return count;
 }

   /* public static void main(String[] args) {

     int[] arr = {100,85,70,60,65,86,90};

     System.out.println("stock span is ");

     int[] count = stockSpanProblem(arr);
     for(Integer integer: count){
         System.out.print(" "+integer);
     }

    }*/
    /*stock span is
 1 1 1 1 2 5 6*/


/*Swap Kth node from beginning with Kth node from end in a Linked List*/

public static void swapKthNodeFromBegToEnd(LinkNode linkedListP,int k){
    printList(linkedListP);
    LinkNode first = linkedListP;
    LinkNode firstP;
    LinkNode firstN;
    LinkNode second, secondP = linkedListP, secondN;
    LinkNode tmp = linkedListP;

    for(int i =1 ; i<k-1;i++)
        tmp = tmp.next;

    firstP = tmp;
    first = tmp.next;
    firstN = first.next;
    tmp = tmp.next;

    while (tmp.next.next!= null) {
        secondP = secondP.next;
        tmp = tmp.next;
    }

    second = secondP.next;
    secondN = second.next;

    first.next = secondN;
    second.next = firstN;

    firstP.next = second;
    secondP.next = first;
    printList(linkedListP);


}

private static void printList(LinkNode node){

    while (node!= null) {
        System.out.print(" " + node.data);
        node = node.next;
    }
    System.out.println(" ");
}

   /* public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(3);
        head.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(5);
        head.next.next.next.next.next = new LinkNode(6);
       // printList(head);
        swapKthNodeFromBegToEnd(head,3);

    }*/

    public int maxSubArray(final List<Integer> A) {
        int max_continuous = 0;
        int max_so_far = Integer.MIN_VALUE;

        if(A== null)
            return 0;

        int size = A.size();
        if(size == 0)
            return 0;
        if(size == 1)
            return A.get(0);

        for(Integer integer : A){
            max_continuous += integer;
            if(max_continuous > max_so_far)
                max_so_far = max_continuous;
            if(max_continuous < 0){
                max_continuous = 0;
            }
        }
        return max_so_far;
    }

    /*Find subarray with given sum*/

    public static void findSubArrWithGivenSum(int[] arr, int sum){
        int size = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int curr_sum =0 ;
        int start=-1;
        int end= -1;

        for(int i = 0 ; i <size;i++){
            curr_sum+=arr[i];

            if(curr_sum-sum == 0){
                start = 0;
                end = i;
                break;
            }

            if(map.containsKey(curr_sum-sum)){
                start = map.get(curr_sum-sum)+1;
                end = i;
                break;
            }
            else map.put(curr_sum,i);

        }

        System.out.println("start is "+ start+" end is "+end);

    }

    /*public static void main(String[] args) {

        *//*int[] arr = {-10, 0, 2, -2, -20, 10};
        int sum = -20;
        findSubArrWithGivenSum(arr,sum);*//*

        int[] Heights = {5, 3, 2, 6, 1, 4};
        int[] InFronts=  {0, 1, 2, 0, 3, 2};
        orderStandingQueue(Heights,InFronts);
       // matricMultiplication();
    }*/

        public static void orderStandingQueue(int[] heights, int[] infronts) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i=0; i<heights.length; i++) {
            map.put(heights[i], infronts[i]);
        }

        System.out.println("map is "+map);
        boolean sorted = false;
        while(sorted == false) {
            int height = map.lastKey();
            int taller = map.get(height);
            map.remove(height);
            System.out.println("after removing h "+height+" list is "+result.toString());


            if (result.isEmpty()){
                result.add(height);
            } else if (taller == 0) {
                result.add(0,height);
            } else {
                result.add(taller,height);
            }
            if (map.isEmpty()) sorted = true;
        }
        System.out.println(result.toString());
    }

    public static void matricMultiplication(){
        int[][] matA ={{1,2},{3,4}};
        int[][] matB = {{2,0},{1,2}};
        int m =2;
        int n =2;
        int[][] result = new int[m][n];
        for(int i =0; i<m;i++){
            for(int j =0;j<n;j++){
                for(int k =0;k<n;k++){
                    result[i][j] += matA[i][k]*matB[k][j];
                }
            }
        }
        for(int i =0; i<m;i++){
            for(int j =0;j<n;j++){
                System.out.print(" "+result[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static ArrayList<Integer> findMaxPair(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> maxPair = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);

        int prevSum;
        int size = A.size();
        int maxArrayEle = A.get(size-1)> B.get(size-1) ? 1:2;
        int sum;


        for(int i = size-1; i>0;i--){
            if(maxArrayEle ==1)
                prevSum = A.get(i-1)+B.get(i);
            else
                prevSum = A.get(i)+B.get(i-1);

            sum = A.get(i)+B.get(i);
           // maxPair.add(sum);
            int j = i;
            while(sum >= prevSum && j>0 ){
                if(maxPair.size() >= size)
                    break;
                maxPair.add(sum);

                if(maxArrayEle ==1)
                    sum = A.get(i)+B.get(j-1);
                else
                    sum = A.get(j-1)+B.get(i);
                System.out.println("Sum is "+sum );
                j--;
            }
            if(maxPair.size() >= size)
                break;
            maxPair.add(prevSum);

        }
        System.out.println("array is "+ maxPair);
        return maxPair;

    }
    //not submitted in interviewbit as one of the test cases couldnt pass

   /* public static void main(String[] args) {
        ArrayList A = new ArrayList();
        A.add(1);
      //  A.add(4);
        A.add(2);
     //   A.add(3);

        ArrayList B = new ArrayList();
      *//*  B.add(2);
        B.add(5);
        B.add(1);
        B.add(6);*//*
        B.add(3);
        B.add(4);
        findMaxPair(A,B);

    }*/


    /*Chocolate Distribution Problem*/

    public static int chocolateDistributionProblem(int[] arr,  int m){
       Arrays.sort(arr);

       int size = arr.length;
       int minDiff = Integer.MAX_VALUE;
       int i = 0;
       System.out.println("sorted arr is ");
       for(Integer integer:arr){
           System.out.print(" "+integer);
       }
        System.out.println("");
       for( ; i<=(size-m); i++){
           if((arr[i+m-1]- arr[i]) < minDiff)
               minDiff = (arr[i+m-1]- arr[i]);
           System.out.println("min diff is arr "+ minDiff+ " i is "+arr[i] + " and m is "+arr[(i+m-1)]);
       }
       /* ArrayList<Integer> resultArray = new ArrayList<>();

        for(int j = i ; j< m;j++){
            resultArray.add(j);
        }*/
        return minDiff;
    }

   /* public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};

        int m = 7;  // Number of students

        int n = arr.length;
        System.out.println("Minimum difference is "
                + chocolateDistributionProblem(arr, m));
    }*/

    /*Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7*/

    public static int nOfChoc(int A, ArrayList<Integer> B){

        long totalCocolates = 0L;
        PriorityQueue<Long> queue = new PriorityQueue(A, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return  (long)o1 < (long)o2  ? 1:-1;
            }
        });

        for (Integer geek : B) {
            queue.add(Long.valueOf(geek));
        }

        System.out.println("q is "+ queue);

        for(int i = 0 ; i< A ;i++){
            totalCocolates+= (long)queue.peek();
            System.out.println("queue is "+queue);
            long l = (long)queue.remove()/2; //129.
            queue.add(l);
        }
        System.out.println("queue is "+queue +" and size "+queue.size() + " totalCocolates "+ totalCocolates%1000000007);
        Long ans = new Long(totalCocolates%1000000007);
        return  ans.intValue();
    }

   /* public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2147483647);
        B.add(2000000014);
        B.add(2147483647);
        int[] arr = { 78, 46, 53, 43, 79, 46, 79, 80, 65, 81, 39, 84, 63, 24, 54, 42, 99, 15, 86, 45, 51, 47, 94, 35, 15, 30, 23 };
        ArrayList<Integer> al =
                new ArrayList<Integer>();

        for (Integer geek : arr)
            al.add(geek);
        System.out.println("arr is "+ al.size());
        System.out.print(" "+nOfChoc(45,al));
    }*/


   /*Merge sort*/

   public static void mergeSort(int[] arr,int l, int r){
       if( l<r ){
           int mid = (r+l)/2; ;
           mergeSort(arr,l,mid);
           mergeSort(arr,mid+1,r);
           merge(arr,l,mid,r);
       }

   }

   private static void merge(int[] arr, int l, int mid, int r){
       int i=0,j=0,k=l;
       int size1 = mid -l+1;
       int size2 = r-mid;

       int[] L = new int[size1];
       int[] R = new int[size2];

       for(int a =0 ; a<size1; a++){
           L[a] = arr[l+a];
       }
       for(int a =0 ; a<size2; a++){
           R[a] = arr[mid+1+a];
       }

       while (i<size1 && j<size2){
           if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
           }
           else {
               arr[k] = R[j];
               j++;
           }
           k++;
       }

       while (i<size1){
           arr[k]=L[i];
           k++;
           i++;
       }
       while (j<size2){
           arr[k]=R[j];
           k++;
           j++;
       }
   }
    public static void printArray(int A[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(" "+ A[i]);
        System.out.print("\n");
    }

    /*public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};
        int arr_size = arr.length;

        System.out.print("Given array is \n");
        printArray(arr, arr_size);

        mergeSort(arr, 0, arr_size - 1);

        System.out.print("\nSorted array is \n");
        printArray(arr, arr_size);
    }*/

    /*longest increasing subseq*/

    public static int lIS(int[] arr){
        int size = arr.length;
        int[] tailTable = new int[size];
        tailTable[0] = arr[0];
        int len = 1;
        for(int i =1; i<size;i++){
            if(arr[i] < tailTable[0])
                tailTable[0] = arr[i];
            else if( arr[i] > tailTable[len-1]){
                tailTable[len] = arr[i];
                len++;
            }
            else {
                tailTable[ceilIndex(arr,-1,len-1,arr[i])] = arr[i];
            }
        }
        return len;
    }

    private static int ceilIndex(int[] arr, int l,int r, int key){
        while (r-l>1){
            int mid = l+(r-l)/2;
            if(arr[mid] >= key)
                r= mid;
            else
                l = mid;
        }
        return  r;
    }
    /*public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 0, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is " + lIS(A));
    }*/

    public static void printAllpossiblePaths(int[][] mat){

    }
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(int hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

    // Driver program to test above function
    public static void main(String[] args)
    {
       /* int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));*/

        int mat[][] = { { 1, 1, 0, 0, 0 },
        { 0, 1, 0, 0, 1 },
        { 1, 0, 0, 1, 1 },
        { 0, 0, 0, 0, 0 },
        { 1, 0, 1, 0, 1 } };

        System.out.println("num of islands are "+numberOfIslands(mat,5,5) );

    }

    /*number of islands in a matrix*/
    public static class MatrixElement{
        private int row;
        private int col;

        MatrixElement(int row, int col){
            this.row = row;
            this.col = col;
        }

    }
    public static int numberOfIslands(int[][] mat, int m, int n){
        boolean[][] boolVisited = new boolean[m][n];

        int res = 0;
        for(int i =0; i< m ; i++){
            for(int j = 0 ; j<n; j++){
                if(mat[i][j] == 0 )
                    boolVisited[i][j] = true;
                else
                    boolVisited[i][j] = false;
            }
        }
        for(int i =0; i< m ; i++){
            for(int j = 0 ; j<n; j++){
                if(mat[i][j] == 1 && !boolVisited[i][j] ) {
                    findIslands(mat, i, j, boolVisited,m,n);
                    res++;
                }
            }
        }
        return res;
    }
    private static boolean isSafe(int i, int j , int m , int n, boolean[][] booleans,int num){
        return  ((i >= 0 && i< m)&&(j>=0 && j<n) && !booleans[i][j] && num ==1);

    }

    private static void findIslands(int[][] mat, int m, int n, boolean[][] boolVisited,int R, int C){

        Queue<MatrixElement> queue = new LinkedList<>();
        MatrixElement matrixElement = new MatrixElement(m,n);

        int[] row = {-1,-1,-1,0,0,1,1,1};
        int[] col = {-1,0,1,-1,1,-1,0,1};
        queue.add(matrixElement);
        boolVisited[m][n] = true;

        while (!queue.isEmpty()){
            MatrixElement matrixElement1 = queue.poll();
            int i = matrixElement1.row;
            int j = matrixElement1.col;

            for(int k =0; k<8;k++){
                if(isSafe(i+row[k],j+col[k],R,C,boolVisited,mat[i][j])) {
                    boolVisited[i+row[k]][j+col[k]] = true;
                    queue.add(new MatrixElement(i + row[k], j + col[k]));
                }
            }
        }
    }

}
