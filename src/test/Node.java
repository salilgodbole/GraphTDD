package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by salil on 9/6/16.
 */
public class Node {
    private String name;
    private Node other;
    private List<Node> nodeList;

    public Node(String name) {
        this.name = name;

        nodeList = new ArrayList<>();
    }

    public boolean isConnectedTo(Node node) {
        if (this.equals(node) || nodeList.contains(node)) {
            return true;
        } else {
            boolean connected = false;
            for (Node node1 : nodeList) {
                if (node1.isConnectedTo(node)) {
                    connected = true;
                    break;
                }
            }

            return connected;
        }
    }

    public void connectTo(Node other) {
        nodeList.add(other);
    }

    public int getNoOfHops(Node other) {
        if (this.equals(other)) {
            return 0; // If Self Node return 0
        } else if (this.isConnectedTo(other)) {
            int noOfHops = 1;
            for (Node node : nodeList) {
                noOfHops += node.getNoOfHops(other);
            }
            return noOfHops; // If connected then return 1
        } else {
            return -1; // If not self and not connected return -1
        }
    }
}