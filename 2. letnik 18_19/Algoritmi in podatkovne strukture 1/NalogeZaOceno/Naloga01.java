import java.util.*;

@SuppressWarnings("unchecked")
public class Naloga1{
public static class CollectionException extends Exception {
    public CollectionException(String msg) {
         super(msg);
    }
}
@SuppressWarnings("unchecked")
interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();
    boolean isFull();
    int count();
    @SuppressWarnings("override")
    String toString();
}

@SuppressWarnings("unchecked")
interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}

@SuppressWarnings("unchecked")
interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}

@SuppressWarnings("unchecked")
interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}
  
@SuppressWarnings("unchecked")
public static class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 512;

    @SuppressWarnings("FieldMayBeFinal")
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

public static boolean isNumeric(String str){
    try{
        int i = Integer.parseInt(str);
    }catch(NumberFormatException nfe){
        return false;
    }
    return true;
}

    public static void main(String[] args) throws Exception{
        
        Sequence<Stack> seq = new ArrayDeque<>();   
        for(int i = 0; i<42; i++){   
            Stack<String> stek = new ArrayDeque<>();
            seq.add(stek);
        }
        Scanner scan = new Scanner(System.in);
        String vsebuje = "echo dup pop dup2 swap char even odd ! len <> < <= == > >= + - * / % . rnd then else print clear run loop fun  move reverse";
        
        while(scan.hasNextLine()){
           
            for(int i = 0; i< 42;i++){
                while(!seq.get(i).isEmpty()){
                    seq.get(i).pop();
                }
            }
            
            boolean pogoj = false;
            boolean pogoj_fun = false;
            int spremenljivka_fun = 0;
            int stevilo_fun =0;
            
            String a = scan.nextLine();
            String[] deli = a.split(" ");
            while(!seq.get(0).isEmpty()){
                seq.get(0).pop();
            }
            
            
            String[] razdeli = new String[100];
            for(int i = 0; i<razdeli.length;i++){
                razdeli[i] = "";
            }
            for(int i = 0; i<deli.length;i++){
                razdeli[i] = (String)deli[i];
            }
           
            for(int i = deli.length-1; i>-1;i--){
                seq.get(20).push((String)deli[i]);
            }
            
            while(!seq.get(20).isEmpty()){
                String preberi = (String)seq.get(20).pop();
                
                
                if(pogoj_fun == true){
                       if(stevilo_fun>0){
                         seq.get(spremenljivka_fun).push(preberi);  
                       }
                       if(stevilo_fun == 1){
                           pogoj_fun = false;
                           
                       }
                       stevilo_fun --;
                       continue;
                }
                
                if(preberi.startsWith("?")){
                        if(pogoj == true){
                            preberi = preberi.substring(1);
                        }
                        else{
                            continue;
                            
                        }
                   }
                
                
                if(isNumeric(preberi) || !vsebuje.contains(preberi)){
                    seq.get(0).push(preberi);
                }else{
                    
                    if(preberi.toLowerCase().equals("echo")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        System.out.print(seq.get(0).top() + "\n");
                    }
                    if(preberi.toLowerCase().equals("pop")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        seq.get(0).pop();
                    }
                    if(preberi.toLowerCase().equals("dup")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        String top_vrednost = (String)(seq.get(0).pop());
                        seq.get(0).push(top_vrednost);
                        seq.get(0).push(top_vrednost);
                    }
                    if(preberi.toLowerCase().equals("dup2")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        String top_vrednost = (String)seq.get(0).pop();
                        String top_vrednost2 = (String)seq.get(0).pop();
                        seq.get(0).push((String)top_vrednost2);
                        seq.get(0).push((String)top_vrednost);
                        seq.get(0).push((String)top_vrednost2);
                        seq.get(0).push((String)top_vrednost);
                    }
                    if(preberi.toLowerCase().equals("swap")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        String top_vrednost = (String)seq.get(0).pop();
                        String top_vrednost2 = (String)seq.get(0).pop();
                        seq.get(0).push(top_vrednost);
                        seq.get(0).push(top_vrednost2);
                    }
                    if(preberi.toLowerCase().equals("print")){                        
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        
                        int indeks = Integer.parseInt((String)seq.get(0).pop());
                        int drugi_indeks = 31;
                        if(indeks == drugi_indeks){
                            drugi_indeks++;
                        }
                            
                        
                        while(!seq.get(indeks).isEmpty()){
                            seq.get(drugi_indeks).push(seq.get(indeks).pop());
                        }
                        while(!seq.get(drugi_indeks).isEmpty()){
                            String vrednost = (String)(seq.get(drugi_indeks).pop());
                            seq.get(indeks).push(vrednost);
                            System.out.print(vrednost + " ");
                        }
                        System.out.println();
                    }
                    if(preberi.toLowerCase().equals("char")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int vrednost = Integer.parseInt((String)seq.get(0).pop());
                        char aski = (char)(vrednost);
                        seq.get(0).push(String.valueOf(aski));
                    }
                    if(preberi.toLowerCase().equals("even")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int vrednost = Integer.parseInt((String)seq.get(0).pop());
                        if(vrednost%2==0){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals("odd")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int vrednost = Integer.parseInt((String)seq.get(0).pop());
                        if(vrednost < 0){
                            vrednost = vrednost * -1;
                        }
                        if(vrednost%2==1){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals("!")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int vrednost = Integer.parseInt((String)seq.get(0).pop());
                        int fakulteta= 1;
                        for(int f = 1; f<=vrednost; f++){
                            fakulteta = f*fakulteta;
                        }
                        seq.get(0).push(String.valueOf(fakulteta));
                    }
                    if(preberi.toLowerCase().equals("len")){
                        if(seq.get(0).count() == 0){
                            System.out.print(1);
                            continue;
                        }
                        String dol = (String)seq.get(0).pop();
                        int vrednost = dol.length();
                        seq.get(0).push(String.valueOf(vrednost));
                    }
                    if(preberi.toLowerCase().equals("<>")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int top_vrednost = Integer.parseInt((String)seq.get(0).pop());
                        int top_vrednost2 = Integer.parseInt((String)seq.get(0).pop());
                        
                        if(top_vrednost != top_vrednost2){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals("<")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        
                        if(x < y){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals("<=")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        
                        if(x <= y){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals("==")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        
                        if(x == y){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals(">")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        
                        if(x > y){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals(">=")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        
                        if(x >= y){
                            seq.get(0).push(String.valueOf(1));
                        }else{
                            seq.get(0).push(String.valueOf(0));
                        }
                    }
                    if(preberi.toLowerCase().equals("+")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        int vsota = x + y;
                        seq.get(0).push(String.valueOf(vsota));
                    }
                    if(preberi.toLowerCase().equals("-")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        int razlika = x - y;
                        seq.get(0).push(String.valueOf(razlika));
                    }
                    if(preberi.toLowerCase().equals("*")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        int zmnozek = x * y;
                        seq.get(0).push(String.valueOf(zmnozek));
                    }
                    if(preberi.toLowerCase().equals("/")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        int kvocient = x / y;
                        seq.get(0).push(String.valueOf(kvocient));
                    }
                    if(preberi.toLowerCase().equals("%")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        int ostanek = x % y;
                        seq.get(0).push(String.valueOf(ostanek));
                    }
                    if(preberi.toLowerCase().equals(".")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        String y = (String)seq.get(0).pop();
                        String x = (String)seq.get(0).pop();
                        String skupaj = x + y;
                        seq.get(0).push(skupaj);
                    }
                    if(preberi.toLowerCase().equals("rnd")){
                        if(seq.get(0).count() < 2){
                            System.out.print("\n");
                            continue;
                        }
                        int y = Integer.parseInt((String)seq.get(0).pop());
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        
                        
                        seq.get(0).push(String.valueOf((int) (Math.random() * (y-x) +x)));
                        
                        
                    }
                    if(preberi.toLowerCase().equals("then")){
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        if(x != 0){
                            pogoj = true;
                        }else{
                            pogoj = false;
                        }
                    }
                    if(preberi.toLowerCase().equals("else")){
                        if(pogoj == false){
                            pogoj = true;
                        }else{
                            pogoj = false;
                        }
                    }
                    if(preberi.toLowerCase().equals("clear")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int x = Integer.parseInt((String)seq.get(0).pop());
                        while(!seq.get(x).isEmpty()){
                            seq.get(x).pop();
                        }
                    }
                    if(preberi.toLowerCase().equals("reverse")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int indeks = Integer.parseInt((String)seq.get(0).pop());
                        int indeks_dve = 28;
                        int indeks_tri = 29;

                        
                        
                        while(!seq.get(indeks).isEmpty()){
                            seq.get(indeks_dve).push((String)seq.get(indeks).pop());
                        }
             
                        
                        while(!seq.get(indeks_dve).isEmpty()){
                            seq.get(indeks_tri).push((String)seq.get(indeks_dve).pop());
                        }
                        while(!seq.get(indeks_tri).isEmpty()){
                            seq.get(indeks).push((String)seq.get(indeks_tri).pop());
                        }
                        
                    }
                    if(preberi.toLowerCase().equals("move")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        
                        int indeks_move = Integer.parseInt((String)seq.get(0).pop());
                        int stevilo_move = Integer.parseInt((String)seq.get(0).pop());
                        
                        for(int i = 0; i< stevilo_move;i++){
                            seq.get(indeks_move).push((String)seq.get(0).pop());
                        }

                    }
                    if(preberi.toLowerCase().equals("run")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int indeks_prestavi = Integer.parseInt((String)seq.get(0).pop());
                        int pomozni1 = 26;
                        int pomozni2 = 27;
                        
                        
                        while(!seq.get(indeks_prestavi).isEmpty()){
                            String ukaz = (String)seq.get(indeks_prestavi).pop();
                            seq.get(pomozni1).push((String)ukaz);
                            seq.get(20).push((String)ukaz);

                        }
                        
                        while(!seq.get(pomozni1).isEmpty()){
                            String ukaz = (String)seq.get(pomozni1).pop();
                            seq.get(indeks_prestavi).push((String)ukaz);        
                        }
                                             
                    }
                    if(preberi.toLowerCase().equals("loop")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        int indeks_prestavi = Integer.parseInt((String)seq.get(0).pop());
                         
                        int pomozni1 = 26;
                        int pomozni2 = 27;
                        
                        int ponovi = Integer.parseInt((String)seq.get(0).pop());
                        
                        for(int e = 0; e<ponovi;e++){
                           
                        
                        
                        while(!seq.get(indeks_prestavi).isEmpty()){
                            String ukaz = (String)seq.get(indeks_prestavi).pop();
                            seq.get(pomozni1).push((String)ukaz);
                            seq.get(20).push((String)ukaz);

                        }
                        
                        while(!seq.get(pomozni1).isEmpty()){
                            String ukaz = (String)seq.get(pomozni1).pop();
                            seq.get(indeks_prestavi).push((String)ukaz);        
                        }
                        }
                                             
                    }
                    if(preberi.toLowerCase().equals("fun")){
                        if(seq.get(0).count() == 0){
                            System.out.print("\n");
                            continue;
                        }
                        pogoj_fun = true;
                        spremenljivka_fun = Integer.parseInt((String)seq.get(0).pop());
                        stevilo_fun = Integer.parseInt((String)seq.get(0).pop());
                        
                    }
                }
            }
        }
    }
}
