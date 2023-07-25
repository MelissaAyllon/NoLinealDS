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
public class NewClass {

    public static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
            
        };
        
        BSTree<Integer, Integer> arbol = new BSTree(5, 5,cmp);
        System.out.println(arbol.insert(3, 3));
        System.out.println(arbol.insert(8, 8));
        System.out.println(arbol.search(8));
        
        System.out.println(arbol.delete(5));
        System.out.println(arbol.toString());
        
        arbol.insert(1,1);
        System.out.println(arbol.toString());
               
             

    }
}
