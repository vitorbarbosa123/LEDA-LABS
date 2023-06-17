package problems;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BSTSumLeavesImpl implements BSTSumLeaves{
    public int sumLeaves(BST<Integer> bst){
        int result = 0;
        if(!bst.isEmpty()) {
            result = sumLeaves((BSTNode<Integer>) bst.getRoot());
        }
        return result;
    }

    private int sumLeaves(BSTNode<Integer> node) {
        int result = 0;
        if(node.isLeaf()) {
            result += node.getData();
        } else {
            result += sumLeaves((BSTNode<Integer>) node.getLeft());
            result += sumLeaves((BSTNode<Integer>) node.getRight());
        }
        return result;
    }

    public static void main(String args[]) {
        BST<Integer> bst = new BSTImpl<>();
        
    }
}

