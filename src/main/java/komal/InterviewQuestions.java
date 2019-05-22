package komal;

import utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestions {

    /*Given a binary search tree in which data of 2 nodes is swapped, print the swapped nodes.*/
    public void printTheSwappedNodes(TreeNode node){
        inOrder(node);
        System.out.println("list is "+inOrderList);

    }


    public static List<Integer> inOrderList = new ArrayList();
    public void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            inOrderList.add(node.data);
            inOrder(node.right);
        }

    }
}

