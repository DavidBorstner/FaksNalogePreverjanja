/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teorija01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author David
 */
public class Teorija01 {

    
    static void stack_push(Stack<Object> stack) 
    { 
        
        Stack<Object> obrni = new Stack<Object>();
        Iterator<Object> iter = stack.iterator();

        while (iter.hasNext()){
            obrni.add(stack.pop());
        }
        System.out.println(obrni);
    } 
    

    
    static void preuredi(Stack<Object> stack){
        Stack<Double> decimalke = new Stack<Double>();
        Stack<Integer> stevila = new Stack<Integer>();
        Stack<Boolean> bul = new Stack<Boolean>();
        Stack<Character> crke = new Stack<Character>();
        
        Iterator<Object> iter = stack.iterator();

        while (iter.hasNext()){
            Object test = stack.pop();
            if(test instanceof Integer){
                 stevila.add((int)test);
            }else{
                if(test instanceof Double){
                    decimalke.add((Double) test);
                }else{
                    if(test instanceof Boolean){
                        bul.add((Boolean) test);
                    }else{
                        crke.add((Character)test);
                    }
                }
            }
        }
        
        Double[] decimalkeSeznam = decimalke.toArray(new Double[decimalke.size()]);
        Integer[] stevilaSeznam = stevila.toArray(new Integer[stevila.size()]);
        Boolean[] bulSeznam = bul.toArray(new Boolean[bul.size()]);
        Character[] crkeSeznam = crke.toArray(new Character[crke.size()]);
        Collections.reverse(Arrays.asList(decimalkeSeznam));
        Collections.reverse(Arrays.asList(stevilaSeznam));
        Collections.reverse(Arrays.asList(bulSeznam));
        Collections.reverse(Arrays.asList(crkeSeznam));
        
        
        Object[][] seznam = { decimalkeSeznam, stevilaSeznam, bulSeznam, crkeSeznam };
       for(int i = 0;i<seznam.length;i++){
           for(int j = 0; j<seznam[i].length;j++){
               System.out.println(seznam[i][j]);
           }
       }
        
    }
    
    public static void main(String[] args) {
       
        
        Stack<Object> testiranje = new Stack<Object>();
        testiranje.add('a');
        testiranje.add(false);
        testiranje.add(888);
        testiranje.add(3.4);
        testiranje.add('e');
        testiranje.add(10);
        testiranje.add(true);
        testiranje.add('c');
        preuredi(testiranje);
    }
    
}
