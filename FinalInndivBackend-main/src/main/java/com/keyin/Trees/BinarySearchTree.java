package com.keyin.Trees;

public class BinarySearchTree {
    private BinaryNode root;
    public void insert(int value) {
        root = insert(root, value);
    }
    private BinaryNode insert(BinaryNode currentNode ,int value) {
        if (currentNode == null) {
            return new BinaryNode(value);
        } else if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(BinaryNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
            return;
        }

        sb.append("{");
        sb.append("\"value\":").append(node.value).append(",");
        sb.append("\"left\":");
        serializeHelper(node.left, sb);
        sb.append(",");
        sb.append("\"right\":");
        serializeHelper(node.right, sb);
        sb.append("}");
    }
}

