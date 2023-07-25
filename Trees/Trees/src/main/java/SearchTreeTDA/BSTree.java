/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SearchTreeTDA;

import java.util.Comparator;

/**
 *
 * @author melis
 */
public class BSTree<E,K> {
    private BSTNode<E,K> root;
    private Comparator<K> cmp;
    
    public BSTree(E content,K key, Comparator cmp){
        this.root = new BSTNode<>(content,key);
        this.cmp = cmp;
    }
    
    public void setCmp(Comparator<K> cmp){
        this.cmp = cmp;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public boolean isLeaf(){
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    
    //Anadir un elemento a mi arbol binario
    public boolean insert(E content, K key){
        //se crea nueva hoja
        BSTNode<E,K> hoja = new BSTNode(content,key);
        if(this.isEmpty()){
            this.root = hoja;
            return true;
        }
        else{
            //Hay que buscar donde colocarla
            int i = cmp.compare(this.root.getKey(), key);
            
            if( i == 0){
                this.root.setContent(content);
                return true;
            }
            
            //Vamos a ver de que lado avanza
            if(i > 0){
                //Vamos a ir avanzando del lado izquierdo porque el root es mayor
                if(this.root.getLeft() == null){
                    this.root.setLeft(new BSTree(content,key,this.cmp));
                    return true;
                }
                else{
                    return this.root.getLeft().insert(content, key);
                }
            }
            
            else{
                if(this.root.getRight() == null){
                    this.root.setRight(new BSTree(content,key,this.cmp));
                    return true;
                }
                else{
                    return this.root.getRight().insert(content, key);
                }
            }
            
        }
    }
    
    public E search(K key){
        E found = null;
        if(this.isEmpty()){
            return found;
        }
        else{
            //Buscar nodo
            int i = cmp.compare(this.root.getKey(), key);
            
            if(i == 0){
                found = this.root.getContent();
                return found;
            }
            
            else if (i > 0){
                //Buscamos en el hijo izquierdo hasta que se encuentre  i == 0 o que no exista y sea nulo
                if(this.root.getLeft() != null){
                    return this.root.getLeft().search(key);
                }
                else{
                    return null;
                }
            }
            
            else{
                
                if(this.root.getRight() != null){
                    return this.root.getRight().search(key);
                }
                else{
                    return null;
                }
            }
        }
    }
    
    public boolean delete(K key){
        //Buscar el nodo
        if(this.isEmpty()){
            return false;
        }
        else{
            int i = cmp.compare(this.root.getKey(), key);
            if( i == 0 ){
                //encontre el nodo a eliminar
                //Ver cuantos hijos tiene
                
                //probar
                if(this.isLeaf()){
                    //desenlazar a este hijo;
                    this.root = null;
                    this.cmp = null;
                    return true;
                }
                else if(this.root.getLeft() != null && this.root.getRight() != null){
                    //Buscar el nodo menor con la clave mayor
                    
                    //vamos a obtener el mayor de los izquierdos
                    BSTree<E,K> mayorDelIzquierdo = this.root.getLeft().getMax();
                    this.root.setContent(mayorDelIzquierdo.root.getContent());
                    //debo eliminarlo
                    this.delete(mayorDelIzquierdo.root.getKey());
                    return true;
                }
                
                else{
                    //uno de los dos 
                    if(this.root.getLeft() != null){
                        this.root.setContent(this.root.getLeft().root.getContent());
                        return true;
                    }
                    else{
                        this.root.setContent(this.root.getRight().root.getContent());
                        return true;
                    }
                            
                }
                
            }
            
            //sino busca en los hijos
            else if(i >0 ){
                return this.root.getLeft().delete(key);
            }
            else{
                return this.root.getRight().delete(key);
            }
            
        }
    }
   

    private BSTree<E,K> getMax() {
        BSTree<E,K> maximo = null;
        //si es una hoja ya nomas retorna ese
        if(this.isLeaf()){
            maximo = this;
            return maximo;
        }
        else{
            //Comparar los hijos
            BSTree<E,K> max1 = null;
            BSTree<E,K> max2 = null;
            if(this.root.getLeft()!=null){
               max1 = this.root.getLeft().getMax();
             
            }
            if(this.root.getRight() != null){
                max2 = this.root.getRight().getMax();
            }
            
            if(this.root.getLeft()!=null && this.root.getRight() != null){
                int i =cmp.compare(max1.root.getKey(), max2.root.getKey());
                   if(i < 0 ){
                       maximo = max2;
                   }
                   else{
                       maximo = max1;
                   }
                   //hay que comparar con el root
                   //No creo que sea necesario pero aun asi
                   int j = cmp.compare(this.root.getKey(), maximo.root.getKey());
                   if (j >= 0 ){
                       maximo = this;
                   }

                   return maximo;
            }
            else{
                maximo = this;
                if(this.root.getLeft() == null){
                    int j = cmp.compare(this.root.getLeft().root.getKey(), maximo.root.getKey());
                    if (j >= 0 ){
                       maximo = this.root.getLeft();
                    }
                   return maximo;
                }
                else{
                    int j = cmp.compare(this.root.getRight().root.getKey(), maximo.root.getKey());
                    if (j >= 0 ){
                       maximo = this.root.getRight();
                    }
                   return maximo;
                }
            }
        }
        
    }
    
    public String toString(){
        String arbolContenido = "";
        
        //PreOrde
        if(this.isEmpty()){
            return arbolContenido;
        }
        //si es hoja
        else if(this.isLeaf()){
            return this.root.getContent().toString();
        }
        else{
            arbolContenido += this.root.getContent() + ", ";
            if(this.root.getLeft() != null){
                arbolContenido += this.root.getLeft().toString() + ", ";
            }
            if(this.root.getRight() != null){
                arbolContenido += this.root.getRight().toString() + ", ";
            }
        }
        
        return arbolContenido;
    }
}
