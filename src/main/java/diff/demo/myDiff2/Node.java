package diff.demo.myDiff2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node<T> implements Serializable {

    private Node parentNode;
    private String name;
    private T nodeEntity;
    private boolean flag;//标志子属性是否是一个基本对象类型
    private List<Node> childNodes;

    public Node(String name, T nodeEntity, boolean flag) {
        this.name = name;
        this.nodeEntity = nodeEntity;
        this.flag = flag;
    }

    public Node(String name, T nodeEntity) {
        this.name = name;
        this.nodeEntity = nodeEntity;
        this.flag = false;
    }


    public Node() {
    }

    public void addChildNode(Node childNode) {
        childNode.setParentNode(this);
        if (this.childNodes == null) {
            this.childNodes = new ArrayList<Node>();
        }
        this.childNodes.add(childNode);
    }

    public void removeChildNode(Node childNode) {
        if (this.childNodes != null) {
            this.childNodes.remove(childNode);
        }
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public T getNodeEntity() {
        return nodeEntity;
    }

    public void setNodeEntity(T nodeEntity) {
        this.nodeEntity = nodeEntity;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}