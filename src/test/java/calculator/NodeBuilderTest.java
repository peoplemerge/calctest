package calculator;

import com.peoplemerge.calculator.NodeBuilder;
import com.peoplemerge.calculator.NonTermExpression;
import com.peoplemerge.calculator.TermExpression;
import com.peoplemerge.calculator.TreeNode;
import com.peoplemerge.calculator.operations.Add;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by davethomas on 9/6/16.
 */
public class NodeBuilderTest {

    @Test
    public void testTermOperation(){
        TreeNode actual = NodeBuilder.buildNode("34");
        Assert.assertEquals(new TermExpression(32), actual);
    }

    @Test
    public void testNonTermOperation(){
        TreeNode actual = NodeBuilder.buildNode("+");
        Assert.assertEquals(new NonTermExpression(Add.instance, null,null), actual);
    }
}
