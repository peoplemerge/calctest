package com.peoplemerge.calculator;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by davethomas on 9/6/16.
 */
public class TreeBuilder {

    public List<String> tokenize(String in){
        List<String> found = new ArrayList<String>();
        boolean lastWasNumber=false;
        String token = "";
        char[] chars = in.toCharArray();
        for ( int i = 0 ; i < chars.length ; i ++ ){
            if(!Character.isWhitespace(chars[i])){
                if(Character.isDigit(chars[i])) {
                    lastWasNumber=true;
                    token += chars[i];
                }else {
                    if(lastWasNumber){
                        found.add(token);
                    }
                    lastWasNumber = false;
                    token = "";
                    found.add(String.valueOf(chars[i]));
                }
            }
        }
        if(lastWasNumber){
            found.add(String.valueOf(chars[chars.length-1]));
        }
        return found;

    }



    private TreeNode buildRecurse(List<String> in, TreeNode root){
        if(in.isEmpty()){
            return root;
        }else{
            TreeNode node = NodeBuilder.buildNode(in.get(0));
            if(root instanceof TermExpression){
                ((NonTermExpression )node).setLeft(root);
                root = node;
            }else{
                NonTermExpression rootNt = (NonTermExpression) root;
                if(node instanceof NonTermExpression) {
                    NonTermExpression nodeNt = (NonTermExpression) node;

                    if (rootNt.getOp().compareTo(nodeNt.getOp() ) < 0) {
                        nodeNt.setLeft(root);
                    }else {
                        if(rootNt.getLeft() == null){
                            rootNt.setLeft(root);
                        }else if(rootNt.getRight() == null){
                            rootNt.setRight(root);
                        }
                    }
                }
            }
           return buildRecurse(in.subList(1,in.size()), root);
        }
    }

    public TreeNode build(String in){
        List<String> tokens = tokenize(in);
        buildRecurse(tokens.subList(1,tokens.size()), NodeBuilder.buildNode(tokens.get(0)));
        return null;
    }


}
