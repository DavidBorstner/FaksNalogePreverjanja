package izziv04;

public class Izziv04 {

class CollectionException extends Exception {
    public CollectionException(String msg) {
         super(msg);
    }
}

interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";

    boolean isEmpty();
    int size();
    String toString();
}

interface Queue<T> extends Collection {
    T front() throws CollectionException;
    void enqueue(T x);
    T dequeue() throws CollectionException;
}

interface PriorityQueue<T extends Comparable> extends Queue<T> {
    static void compareTo(){
        
    }
}

abstract class AbstractArrayPQ<T extends Comparable> implements PriorityQueue<T>{
        private int DEFAULT_CAPACITY = 64;

        private T[] t;
        private int front = 0,size = 0,back = 0;
    
    
        public void Resize(){
            DEFAULT_CAPACITY = DEFAULT_CAPACITY * 2;
        }
        
        @Override
        public T front() throws CollectionException {
            if(isEmpty()){
                throw new CollectionException(ERR_MSG_EMPTY);
            }
            return(t[front]);
        }

        @Override
        public void enqueue(T x) {
            if(size == DEFAULT_CAPACITY){
                Resize();
            }
            t[back] = x;
            back++;
            
        }

        @Override
        public T dequeue() throws CollectionException {
            if(isEmpty()){
                throw new CollectionException(ERR_MSG_EMPTY);
            }           
            T[] zacasno = null;
            int stevec = 0;
            T vrni;
            vrni = t[0];
            for(int i = 1; i<t.length;i++){
                zacasno[stevec] = t[i];
            }
            size--;
            t = zacasno;
            return vrni;       
        }

        @Override
        public boolean isEmpty() {
            return this.size==0;
        }

        @Override
        public int size() {
            System.out.print(size);
            return size;
        }
    
}

public abstract class LinkedHeapPQ<T extends Comparable> implements PriorityQueue<T>{
    
}




    public static void main(String[] args) {
            
    }
    
}
