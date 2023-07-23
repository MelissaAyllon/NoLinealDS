package ggm.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(E content) {
        this.root = new BinaryTreeNode<>(content);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public E getRoot() {
        if (!this.isEmpty()) {
            return root.getContent();
        }
        return null;
    }

    public boolean setLeft(BinaryTree<E> t) {
        if (!this.isEmpty()) {
            root.setLeft(t);
            return true;
        }
        return false;
    }
    
    public boolean setRight(BinaryTree<E> t) {
        if (!this.isEmpty()) {
            root.setRight(t);
            return true;
        }
        return false;
    }
    
    public BinaryTree<E> getLeft() {
        if (!this.isEmpty()) {
            return root.getLeft();
        }
        return null;
    }

    public BinaryTree<E> getRight() {
        if (!this.isEmpty()) {
            return root.getRight();
        }
        return null;
    }

    public List<E> inOrderTraversal() {

        List<E> results = new LinkedList<>();

        if (!this.isEmpty()) {

            if (this.getLeft() != null) {
                results.addAll(this.getLeft().inOrderTraversal());
            }

            results.add(root.getContent());

            if (this.getRight() != null) {
                results.addAll(this.getRight().inOrderTraversal());
            }
        }

        return results;

    }

    public boolean isLeaf() {
        if (!this.isEmpty()) {
            return this.root.getLeft() == null && this.root.getRight() == null;
        }
        return false;
    }

    public int countNodesRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int nodes = 1;

            if (this.getLeft() != null) {
                nodes += this.getLeft().countNodesRecursive();
            }

            if (this.getRight() != null) {
                nodes += this.getRight().countNodesRecursive();
            }

            return nodes;
        }

    }

    public int countNodesIterative() {
        Stack<BinaryTree<E>> s = new Stack<>();
        int cont = 0;
        if (this.isEmpty()) {
            return cont;
        } else {
            s.push(this);
            while (!s.isEmpty()) {
                BinaryTree<E> t = s.pop();
                cont++;
                if (t.getLeft() != null) {
                    s.push(t.getLeft());
                }
                if (t.getRight() != null) {
                    s.push(t.getRight());
                }
            }
        }
        return cont;
    }

}
