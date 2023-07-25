/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SearchTreeTDA;

/**
 *
 * @author melis
 */
public class BSTNode<E,K> {
    private E content;
    private K key;
    BSTree<E,K> right;
    BSTree<E,K> left;
    
    public BSTNode(E content, K key){
        this.content = content;
        this.key = key;
        this.right = null;
        this.left = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BSTree<E, K> getRight() {
        return right;
    }

    public void setRight(BSTree<E, K> right) {
        this.right = right;
    }

    public BSTree<E, K> getLeft() {
        return left;
    }

    public void setLeft(BSTree<E, K> left) {
        this.left = left;
    }
    
    
}
