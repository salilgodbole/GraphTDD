package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by salil on 9/6/16.
 */
public class NodeTest {

    @Test
    public void canReachItself() {
        Node node = new Node("A");
        boolean connected = node.isConnectedTo(node);

        assertTrue(connected);
    }

    @Test
    public void twoDisjointNotConnected() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        nodeA.isConnectedTo(nodeB);

//
//        boolean connected = nodeA.isConnectedTo(nodeB);
//        assertFalse(connected);
    }

    @Test
    public void connectedToOther() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        nodeA.connectTo(nodeB);
        boolean connected = nodeA.isConnectedTo(nodeB);

        assertTrue(connected);
    }

    @Test
    public void areThreeNodesConnected() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.connectTo(nodeB);
        nodeA.connectTo(nodeC);

        assertTrue(nodeA.isConnectedTo(nodeB));
        assertTrue(nodeA.isConnectedTo(nodeC));
        assertFalse(nodeC.isConnectedTo(nodeB));
    }

    @Test
    public void canReachToIndirectNode() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");

        nodeA.connectTo(nodeB);
        nodeA.connectTo(nodeC);
        nodeB.connectTo(nodeD);

        assertTrue(nodeA.isConnectedTo(nodeB));
        assertTrue(nodeA.isConnectedTo(nodeC));
        assertTrue(nodeB.isConnectedTo(nodeD));
        assertTrue(nodeA.isConnectedTo(nodeD));
        assertFalse(nodeC.isConnectedTo(nodeB));
    }

    @Test
    public void canReachToIndirectNode2() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.connectTo(nodeB);
        nodeA.connectTo(nodeC);
        nodeB.connectTo(nodeD);
        nodeC.connectTo(nodeE);
        nodeD.connectTo(nodeF);
        nodeC.connectTo(nodeG);

        assertTrue(nodeA.isConnectedTo(nodeB));
        assertTrue(nodeA.isConnectedTo(nodeC));
        assertTrue(nodeB.isConnectedTo(nodeD));
        assertTrue(nodeA.isConnectedTo(nodeD));
        assertTrue(nodeA.isConnectedTo(nodeE));
        assertFalse(nodeC.isConnectedTo(nodeB));

        assertTrue(nodeA.isConnectedTo(nodeF));
        assertTrue(nodeA.isConnectedTo(nodeG));
    }

    @Test
    public void noOfHopesBetweenSelf() {
        Node node = new Node("A");

        assertEquals(0, node.getNoOfHops(node));
    }

    @Test
    public void noOfHopsBetweenNonConnectedNodes() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        assertEquals(-1, nodeA.getNoOfHops(nodeB));
    }

    @Test
    public void noOfHopsBetweenTwoConnectedNodes() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");

        nodeA.connectTo(nodeB);

        assertEquals(1, nodeA.getNoOfHops(nodeB));
    }

    @Test
    public void noOfHopsBetweenMoreThanTwoConnectedNodes() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");

        nodeA.connectTo(nodeB);
        nodeB.connectTo(nodeC);
        nodeC.connectTo(nodeD);

        assertEquals(1, nodeA.getNoOfHops(nodeB));
        assertEquals(2, nodeA.getNoOfHops(nodeC));
        assertEquals(3, nodeA.getNoOfHops(nodeD));

        assertEquals(1, nodeB.getNoOfHops(nodeC));
        assertEquals(2, nodeB.getNoOfHops(nodeD));
        assertEquals(1, nodeC.getNoOfHops(nodeD));
    }
}
