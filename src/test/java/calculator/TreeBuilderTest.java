package calculator;

import static org.junit.Assert.assertEquals;

import com.peoplemerge.calculator.NonTermExpression;
import com.peoplemerge.calculator.TermExpression;
import com.peoplemerge.calculator.TreeBuilder;
import com.peoplemerge.calculator.TreeNode;
import com.peoplemerge.calculator.operations.Add;
import com.peoplemerge.calculator.operations.Multiply;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davethomas on 9/6/16.
 */
public class TreeBuilderTest {

    TreeBuilder sut = new TreeBuilder();

    @Test
    public void testTokenize(){
        String input = "3+4 * 7";
        List<String> expected = new ArrayList<String>();
        expected.add("3");
        expected.add("+");
        expected.add("4");
        expected.add("*");
        expected.add("7");
        assertEquals(expected, sut.tokenize(input));
    }

    @Test
    public void testSimpleExpr(){
        TreeNode node = sut.build("3");
        TreeNode expected = new TermExpression(3);
        assertEquals(expected, node);

    }


    @Test
    public void testAddExpr(){
        TreeNode node = sut.build("3+4");
        TreeNode three = new TermExpression(3);
        TreeNode four = new TermExpression(4);
        TreeNode expected = new NonTermExpression(Add.instance, three, four);
        assertEquals(expected, node);
        int value = node.evaluate();
        assertEquals(7, value);
    }

    @Test
    public void testMultExpr(){
        TreeNode node = sut.build("4*7");
        TreeNode four = new TermExpression(4);
        TreeNode seven = new TermExpression(7);
        TreeNode expected = new NonTermExpression(Multiply.instance, four, seven);
        assertEquals(expected, node);
        int value = node.evaluate();
        assertEquals(28, value);
    }

    @Test
    public void testOrderedExpr(){
        TreeNode node = sut.build("3+4*7");
        TreeNode three = new TermExpression(3);
        TreeNode four = new TermExpression(4);
        TreeNode seven = new TermExpression(7);
        TreeNode bottomTree = new NonTermExpression(Multiply.instance, four, seven);
        TreeNode expected  = new NonTermExpression(Add.instance, three, bottomTree);
        assertEquals(expected, node);
        int value = node.evaluate();
        assertEquals(31, value);

    }
}
