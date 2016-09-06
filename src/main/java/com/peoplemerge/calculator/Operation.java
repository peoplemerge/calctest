package com.peoplemerge.calculator;

/**
 * Created by davethomas on 9/6/16.
 */
public interface Operation<T>  {
    int evaluate(TreeNode first, TreeNode second);
    int compareTo(Operation o);

}
