package com.peoplemerge.calculator;

/**
 * Created by davethomas on 9/6/16.
 */
public class TermExpression implements TreeNode {

    public TermExpression(int expression) {
        this.expression = expression;
    }

    public int getExpression() {
        return expression;
    }

    private final int expression;

    public boolean equals(Object in){
        if(in instanceof TermExpression) {
            return ((TermExpression) in) .getExpression() == expression;
        }
        return false;
    }

    public int hashCode(){
        return expression;
    }

    @Override
    public int evaluate() {
        return expression;
    }
}
