package test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by salil on 14/7/16.
 */
public class NodeTest1 {

    @Test
    public void testNodeConnectedToItself() {
        Node1 node1 = new Node1("A");
        Assert.assertTrue(node1.isConnectedToSelf(node1));
    }

    @Test
    public void testTwoDisjoinedNodesNotConnected() {
        Node1 nodeA = new Node1("A");
        Node1 nodeB = new Node1("B");

        Assert.assertFalse(nodeA.isConnectedToOther(nodeB));
    }

    @Test
    public void testTwoJoinedNodesConnected() {
        Node1 nodeA = new Node1("A");
        Node1 nodeB = new Node1("B");

        nodeA.connectTo(nodeB);
        Assert.assertTrue(nodeA.isConnectedToOther(nodeB));
    }

    @Test
    public void testNodeConnectedToSelf() {
        Node1 nodeA = new Node1("A");
//        Node1 nodeB = new Node1("A");

//        nodeA.connectTo(nodeB);
        Assert.assertTrue(nodeA.isConnectedToOther(nodeA));
    }
}
