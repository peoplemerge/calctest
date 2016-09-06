package com.peoplemerge.calculator.operations;

import com.peoplemerge.calculator.Operation;
import com.peoplemerge.calculator.TreeNode;

/**
 * Created by davethomas on 9/6/16.
 */
public enum Multiply implements Operation {
    instance;
    @Override
    public int evaluate(TreeNode first, TreeNode second) {
        return first.evaluate() * second.evaluate();
    }

    public int compareTo(Operation t){
        return 1;
    }
}
