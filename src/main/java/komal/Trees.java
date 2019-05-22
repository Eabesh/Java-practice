package komal;

import utilities.TreeNode;

import java.util.*;

public class Trees {

    /*Practice ques 1*/
    public static void printRootToleaf(TreeNode node,String path){
        if( node!= null){
            if(isLeaf(node))
                System.out.println(path+node.data);
            else {
                printRootToleaf(node.left, path + node.data+ "->");
                printRootToleaf(node.right,path +node.data+ "->");
            }

        }
    }
    /*practice ques 2 - LCA of BST (iterative)*/
    public static int LCABstIterative(TreeNode node, int n1, int n2){
        while(node!= null){
            if(node.data > n1 && node.data > n2)
                node = node.left;
            else if(node.data < n1 && node.data < n2)
                node = node.right;
            else
                break;
        }
        return node.data;
    }

    /*practice ques 2 - LCA of BST (Resursive)*/
    public static int LCABstRecursive(TreeNode node, int n1, int n2){
       if(node != null){
           if(node.data > n1 && node.data > n2)
               return LCABstRecursive(node.left,n1,n2);
           else if(node.data < n1 && node.data < n2)
               return LCABstRecursive(node.right,n1,n2);
           else return node.data;
       }
       return -1;
    }

    public static int LCABtRecursive(TreeNode node,int n1, int n2){
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        if(pathExist(node,n1,path1) && pathExist(node,n2,path2)){
            int i = 0;
            for(; i < path1.size();i++){
                if(path1.get(i)!= path2.get(i))
                    break;
            }
            return path1.get(i-1);
        }
        else return -1;
    }

    private static boolean pathExist(TreeNode node,int n, List<Integer> path){
        if(node == null)
            return  false;

        path.add(node.data);

        if(node.data == n)
            return true;

        if(pathExist(node.left,n,path))
            return true;

        if(pathExist(node.right,n,path))
            return true;

        path.remove(path.size()-1);

        return false;

    }

    /*Practice question - in order traversal using recursion*/
    public void inOrderTraversalRec(TreeNode node){
        if(node == null)
            return;
        inOrderTraversalRec(node.left);
        System.out.print(node.data+" ");
        inOrderTraversalRec(node.right);
    }
    /*Practice question - pre order traversal using recursion*/
    public void preOrderTraversalRec(TreeNode node){
        if(node == null)
            return;
        System.out.print(node.data+" ");
        inOrderTraversalRec(node.left);
        inOrderTraversalRec(node.right);
    }

    /*Practice question - pre order traversal using iteration*/
    public void preOrderTraversalIte(TreeNode node){
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(node);

        while(!treeNodeQueue.isEmpty()){
            TreeNode tmp = treeNodeQueue.poll();
            //treeNodeQueue.remove(tmp);
            System.out.print(tmp.data+" ");
            if(tmp.left != null)
                treeNodeQueue.add(tmp.left);
            if(tmp.right != null)
                treeNodeQueue.add(tmp.right);
        }
    }

    public static void leftView(TreeNode node){
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(node);
        treeNodeQueue.add(null);
        int count = 0;
        while (!treeNodeQueue.isEmpty()){
            TreeNode tmp = treeNodeQueue.poll();
            if(tmp == null){

            }


        }
    }
    /*Practice question -size of tree using recursion*/
    public static int sizeOfTree(TreeNode node){
        if(node == null)
            return 0;
        else return (sizeOfTree(node.left) + sizeOfTree(node.right)+1);
    }

    public static int sizeOfTree2(TreeNode node){
        if(node == null)
            return 0;
        int lSize = sizeOfTree(node.left);
        int rSize = sizeOfTree(node.right);
        return lSize +rSize + 1;
    }

    public static boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null)
            return true;
        return false;
    }

    /*Max element in tree*/
    public static int maxInTree(TreeNode node){
        if(node == null)
            return 0;
        int res = node.data;
        int lMax = maxInTree(node.left);
        int rMax = maxInTree(node.right);

        if(res < lMax )
            res = lMax;
        if( res < rMax)
            res = rMax;
        return res;
    }
    /*Level order traversal in spiral form.*/
    public static void printSpiralForm(TreeNode node){
        Stack<TreeNode> treeNodeQueue1 = new Stack<>();
        Stack<TreeNode> treeNodeQueue2 = new Stack<>();
        treeNodeQueue1.add(node);
        while(!treeNodeQueue1.isEmpty() || !treeNodeQueue2.isEmpty()){
            while (!treeNodeQueue1.isEmpty()){
                TreeNode tmp = treeNodeQueue1.pop();
                System.out.println(tmp.data);
                if(tmp.right != null)
                    treeNodeQueue2.add(tmp.right);
                if(tmp.left != null)
                    treeNodeQueue2.add(tmp.left);
            }
            while (!treeNodeQueue2.isEmpty()){
                TreeNode tmp = treeNodeQueue2.pop();
                System.out.println(tmp.data);
                if(tmp.left != null)
                    treeNodeQueue1.add(tmp.left);
                if(tmp.right != null)
                    treeNodeQueue1.add(tmp.right);
            }
        }
    }
    public static int heightOfBT(TreeNode node){
        if(node == null)
            return 0;
        int lh = heightOfBT(node.left);
        int rh = heightOfBT(node.right);
        return Math.max(lh,rh)+1;
    }

    /*Diameter of a Binary Tree*/
    public static int diameterOfBinaryTree(TreeNode node){
        if(node == null)
            return 0;
        int lh = heightOfBT(node.left);
        int rh = heightOfBT(node.right);
        int ld = diameterOfBinaryTree(node.left);
        int rd = diameterOfBinaryTree(node.right);
        return Math.max(lh+rh+1,Math.max(ld,rd));

    }

    public static int dia = Integer.MIN_VALUE;
    public static int diameterOfBinaryTreeN1(TreeNode node){
        if(node == null)
            return 0;
        int lh = diameterOfBinaryTreeN1(node.left);
        int rh = diameterOfBinaryTreeN1(node.right);
        dia = Math.max(lh+rh+1,dia);
        return Math.max(lh,rh)+1;

    }
/*above has complexity of n2 */

    static int width =0;
    public static int width(TreeNode node){
        depth(node);
        return width;
    }
    public static int depth(TreeNode node){
        if(node == null)
            return 0;
        int lh = depth(node.left);
        int rh = depth(node.right);
        width = Math.max(width,lh+rh+1);
        return Math.max(lh,rh)+1;

    }

    static int preStart = 0;
    public static TreeNode buildTree(Integer[] in, Integer[] pre, int inStart,int inEnd){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(inStart>inEnd)
            return null;
        TreeNode node = new TreeNode(pre[preStart++]);
        if(inEnd == inStart)
            return node;
        int indexOfElementInInorder = searchIndex(in,node.data);
        node.left = buildTree(in,pre,inStart,indexOfElementInInorder-1);
        node.right = buildTree(in,pre,indexOfElementInInorder+1,inEnd);

        return node;
    }

    private static int searchIndex(Integer[] array, int element){
        if(array.length == 0 || array == null)
            return -1;
        int count = 0;
        for(Integer integer : array)
        {
            if(integer == element)
                return count;
            count++;
        }
        return -1;
    }
    public  void printLevelOrder(TreeNode node){
        int height = heightOfBT(node);
        for(int i = 1; i<= height; i++){
            printNodesAtGivenLevel(node,i);
        }
    }

    private  void printNodesAtGivenLevel(TreeNode node, int level){
        if(node == null)
            return;
        if(level == 1)
            System.out.println("At level "+ level+ "node is "+ node.data);
        else {
            printNodesAtGivenLevel(node.left,level-1);
            printNodesAtGivenLevel(node.right,level-1);
        }
    }

    /*binary tree to DLL*/

    static TreeNode prev = null;
    static TreeNode headOfDll;
    public static void BtToDll(TreeNode node){
        if(node == null)
            return;

        BtToDll(node.left);
        if(prev == null)
            headOfDll = node;
        else{
            node.left = prev;
            prev.right = node;
        }
        prev = node;

        BtToDll(node.right);

    }

    public static TreeNode BtToDllDriver(TreeNode node){
        BtToDll(node);
        return headOfDll;
    }

    public static void printList(TreeNode node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public TreeNode flatten(TreeNode a) {
        flattenUtil(a);
        return a;

    }

    private void flattenUtil(TreeNode node){
        if(node == null || node.left == null&& node.right == null)
            return;


        if(node.left != null){
            flattenUtil(node.left);
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = null;

            TreeNode t = node.right;
            while(t.right != null){
                t = t.right;
            }
            t.right = tmp;
        }
        flattenUtil(node.right);

    }
    private void printNodesDownFromTarget(TreeNode target,int dist , int k){
        if(dist == k)
        {
            System.out.println("data is "+ target.data);
            return;
        }
        printNodesDownFromTarget(target.right,dist+1,k);
        printNodesDownFromTarget(target.left,dist+1,k);

    }

    public int printNodesAtKDistanceFromGivenNode(TreeNode root, TreeNode target, int k ){

        if(root == null)
            return -1;

        if(root == target)
        {
            System.out.println("found the target");
            printNodesDownFromTarget(target,0,k);
            return 0;
        }

        int dl = printNodesAtKDistanceFromGivenNode(root.left,target,k);
        if(dl!= -1){

            if(dl+1 == k){
                System.out.println("data is "+ root.data);
            }
            else {
                printNodesAtKDistanceFromGivenNode(root.right,target,k-dl-2);
            }

            return dl+1;
        }

        int dr = printNodesAtKDistanceFromGivenNode(root.right,target,k);
        if(dr!= -1){

            if(dr+1 == k){
                System.out.println("data is "+ root.data);
            }
            else {
                printNodesAtKDistanceFromGivenNode(root.right,target,k-dr-2);
            }

            return dr+1;
        }
        return -1;


    }


}
