package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by salil on 14/7/16.
 */
public class Node1 {
    private final String name;
    private boolean connectedToSelf;
    private List<Node1> nodeList;

    public Node1(String name) {
        this.name = name;
        nodeList = new ArrayList<>();
    }

    public boolean isConnectedToSelf(Node1 node1) {
        if (this.equals(node1)) {
            return true;
        }

        return false;
    }

    public boolean isConnectedToOther(Node1 otherNode) {
        if (isConnectedToSelf(otherNode)) {
            return true;
        }
        
        return nodeList.contains(otherNode);
    }

    public void connectTo(Node1 node) {
        nodeList.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Node1 node1 = (Node1) o;

        return name != null ? name.equals(node1.name) : node1.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
