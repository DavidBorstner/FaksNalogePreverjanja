/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package izziv02;

import java.util.Arrays;


public class Izziv02 {
    
public static class CollectionException extends Exception {
    public CollectionException(String msg) {
         super(msg);
    }
}

interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();
    boolean isFull();
    int count();
    String toString();
}


interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}


interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}


interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}
  

public static class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;

    private T[] t;
    private int front,back, size;
    
    private int next(int i){
        return (i+1)%DEFAULT_CAPACITY;
    }
    private int prev(int i){
        return (i>0 ? i-1: DEFAULT_CAPACITY-1);
    }
    
    private int index(int i){
       try{
        if(i<0 || i>= size){
            
            throw new CollectionException(ERR_MSG_INDEX);
        }
       }catch(CollectionException err){
           
       }
        return(front +1)%DEFAULT_CAPACITY;
    }
    
    public ArrayDeque(){
        
        this.t = (T[])new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }
    
    
        // return front
        @Override
        public T front() throws CollectionException {
            if(isEmpty()){
                throw new CollectionException(ERR_MSG_EMPTY);
            }
            return(t[0]);
        }

        //back vrne zadnji element, je isto kot top... return top
        @Override
        public T back() throws CollectionException {
            if(isEmpty()){
                throw new CollectionException(ERR_MSG_EMPTY);
            }
            return t[prev(back)];
        }

        //dodajanje elementa na koncu... kličeš push()
        @Override
        public void enqueue(T x) throws CollectionException {
            if(isFull()){
                throw new CollectionException(ERR_MSG_FULL);
            }
            push(x);
        }

        // preveri če je full, premakne front +1 poveča size,..
        @Override
        public void enqueueFront(T x) throws CollectionException {
            if(isFull()){
                throw new CollectionException(ERR_MSG_FULL);
            }
            
            front ++;
            size ++;
            push(x);
            
        }

        
        //izločanje prvega elementa, pogleda če je kaj na začetku, prestavi na začetek zmanjša size,...
        @Override
        public T dequeue() throws CollectionException {
            if(isEmpty()){
                throw new CollectionException(ERR_MSG_EMPTY);
            }           
            T bottom = t[front];
            front = next(front);
            size --;
            return bottom;
            
        }

        //isto kot pop
        @Override
        public T dequeueBack() throws CollectionException {
            if(isEmpty()){
                 throw new CollectionException(ERR_MSG_EMPTY);
            }
            back = prev(back);
            T top = t[back];
            t[back] = null;
            size -= 2;
            
            return top;
        }

        @Override
        public boolean isEmpty() {
            return size==0;
        }

        @Override
        public boolean isFull() {
            return size==DEFAULT_CAPACITY;
        }

        //count?
        public int size(){
            System.out.print(size);
            return size;
        }
        
        @Override
        public String toString(){
            
            String s = "(";
            for(int i = 0; i<size;i++){
                if(i!=0){
                    s+=",";
                }
                s+=t[index(i)] + " ";
            }
            return s+")";
        }
        
        
        @Override
        public int count() {
            return size;
        }

        @Override
        public T top() throws CollectionException {
            if(isEmpty()){
                throw new CollectionException(ERR_MSG_EMPTY);
            }
            return t[prev(back)];
        }

        @Override
        public void push(T x) throws CollectionException {
            if(isFull()){
                 throw new CollectionException(ERR_MSG_FULL);
            }
            t[back] = x;
            back = next(back);
            size++;
        }

        @Override
        public T pop() throws CollectionException {
            if(isEmpty()){
                 throw new CollectionException(ERR_MSG_EMPTY);
            }
            back = prev(back);
            T top = t[back];
            t[back] = null;
            size --;
            return top;
        }

        //vrni element na poziciji i, ugotovi napačen index, ali pa vrni konkreten element
        @Override
        public T get(int i) throws CollectionException {
            if(i > DEFAULT_CAPACITY || i < 0){
                throw new CollectionException(ERR_MSG_INDEX);
            }
            return (t[i]);
        }

        // isto kot push()
        @Override
        public void add(T x) throws CollectionException {
            if(isFull()){
                 throw new CollectionException(ERR_MSG_FULL);
            }
            t[back] = x;
            back = next(back);
            size++;
        }

        
    
}

    public static void main(String[] args) throws Exception{
        Stack<String> stak = new ArrayDeque<>();
        Deque<String> deq = new ArrayDeque<>();
        Sequence<String> seq = new ArrayDeque<>();
        Sequence<String> seq2 = new ArrayDeque<>();
        stak.push("ABC");stak.push("def");stak.push("att");stak.push("cmd");stak.push("123");stak.push("hehe");
        
        System.out.print("Izpiše elemente z stacka, jih odstrani ter prestavi v deque \n");
        System.out.print("Stack: \n");
        while(!stak.isEmpty()){
            System.out.print(stak.top() +" \n");
            deq.enqueueFront(stak.pop());
        }
        deq.enqueue("jaja");deq.enqueue("test1");
        System.out.print("Vsebuje vrednosti z stacka z dvema dodatnima, ter jih prestavi v sequence \n");
        System.out.print("\nDequeue: \n");
        
        while(!deq.isEmpty()){
            System.out.print(deq.back()+" \n");
            seq.add(deq.dequeueBack());
        }
        
        seq2.add("test1"); seq2.add("test2");
        
        System.out.print("Izpiše vrednosti, ki smo jih v sequence pridobili z dequea \n");
        System.out.print("\nSequence: \n");
        for(int i = 0; i < seq.count();i++){
            System.out.print((i+1)+" . "+seq.get(i)+" \n" );
        }
        
        System.out.print("\nSequence2: \n");
        for(int i = 0; i < seq2.count();i++){
            System.out.print(seq2.get(i)+" \n" );
        }
    }
    
}
