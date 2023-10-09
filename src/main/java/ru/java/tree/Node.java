package ru.java.tree;

public class Node {

    private String value;
    private Node positive;
    private Node negative;

    public Node(String value) {
        this.value = value;
        positive = null;
        negative = null;
    }

    public Node() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getPositive() {
        return positive;
    }

    public void setPositive(Node positive) {
        this.positive = positive;
    }

    public Node getNegative() {
        return negative;
    }

    public void setNegative(Node negative) {
        this.negative = negative;
    }
}
