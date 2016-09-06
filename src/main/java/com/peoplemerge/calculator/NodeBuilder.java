package com.peoplemerge.calculator;

import com.peoplemerge.calculator.operations.Add;
import com.peoplemerge.calculator.operations.Divide;
import com.peoplemerge.calculator.operations.Multiply;
import com.peoplemerge.calculator.operations.Subtract;

import sun.awt.SunToolkit;

/**
 * Created by davethomas on 9/6/16.
 */
public class NodeBuilder {


    public static TreeNode buildNode(String s) {
//        if (s.matches("^-?\\d+$")) {
        if (s.matches("^\\d+$")) {
            return new TermExpression(Integer.valueOf(s));
        }
        else{
            Operation op = null;
            switch(s.charAt(0)){
                case '+':
                    op = Add.instance;
                    break;
                case '-':
                    op = Subtract.instance;
                    break;
                case '*':
                    op = Multiply.instance;
                    break;
                case '/':
                    op = Divide.instance;
                    break;
                default:
                    throw new RuntimeException("No support for :" + s.charAt(0));
            }
            return new NonTermExpression(op, null,null);
        }
    }
}
