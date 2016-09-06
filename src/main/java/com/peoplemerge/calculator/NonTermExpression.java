package com.peoplemerge.calculator;

/**
 * Created by davethomas on 9/6/16.
 */
public class NonTermExpression implements TreeNode {

    public NonTermExpression(Operation op, TreeNode left, TreeNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    private Operation op;

    private TreeNode left, right;

    public Operation getOp() {
        return op;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public boolean equals(Object in){
        if(in instanceof NonTermExpression) {
            NonTermExpression inT = ((NonTermExpression) in);
            return inT.getOp().equals(op) &&
                    inT.getLeft().equals(left) &&
                    inT.getRight().equals(right);
        }
        return false;
    }

    public int hashCode(){
        int hash = 23;
        hash = hash * 31 + op.hashCode();
        hash = hash * 31 + left.hashCode();
        hash = hash * 31 + right.hashCode();
        return hash;
    }


    @Override
    public int evaluate() {
        return op.evaluate(left, right);
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
