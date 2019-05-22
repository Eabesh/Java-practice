package komal.comapnyInterviews;

import komal.Trees;
import utilities.TreeNode;

import java.util.ArrayList;

public class code {

    class event{
        String event;
        int count;

    }


    public static ArrayList<Integer> list= new ArrayList<>();
    public static void inOrder(TreeNode node){

        if(node!=null){
            inOrder(node.left);
            list.add(node.data);
            inOrder(node.right);
        }

    }

    public static boolean isBST(TreeNode node){
        inOrder(node);
        int prev = list.get(0);
        for(int i =1; i< list.size(); i++){
            if(list.get(i)<prev)
            {
                return false;
            }
            prev =list.get(i);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

