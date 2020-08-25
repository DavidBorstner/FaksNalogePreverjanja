
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class PrioritetnaVrsta<Tip extends Comparable> implements Seznam<Tip> {

    private Object[] heap;
    private int end = 0;
    public List<Object> vrni = new ArrayList<Object>();
    
    
    public PrioritetnaVrsta() {
        this(100);
    }

    public PrioritetnaVrsta(int maxSize) {
        heap = new Object[maxSize];
    }

    private void bubbleUp() {
        int eltIdx = end - 1;
        while (eltIdx >= 0) {
            Tip elt = (Tip) heap[eltIdx];
            int childIdx = eltIdx * 2 + 1;
            if (childIdx < end) {
                Tip child = (Tip) heap[childIdx];
                if (childIdx + 1 < end && child.compareTo(heap[childIdx + 1]) < 0) {
                    child = (Tip) heap[++childIdx];
                }
                if (elt.compareTo(child) >= 0) {
                    return;
                }
                swap(eltIdx, childIdx);
            }
            eltIdx = eltIdx % 2 == 1 ? (eltIdx - 1) / 2 : (eltIdx - 2) / 2;
        }
    }

    @Override
    public void add(Tip e) {
        if (end == heap.length) {
            resize();
        }
        heap[end++] = e;
        bubbleUp();
    }

    private void resize() {
        Object[] tmp = heap;
        heap = new Object[2 * heap.length];
        for (int i = 0; i < end; i++) {
            heap[i] = tmp[i];
        }
    }

    private void bubbleDown(int start) {
        int eltIdx = start;
        int childIdx = eltIdx * 2 + 1;
        while (childIdx < end) {
            Tip elt = (Tip) heap[eltIdx];
            Tip child = (Tip) heap[childIdx];
            if (childIdx + 1 < end && child.compareTo(heap[childIdx + 1]) < 0) {
                child = (Tip) heap[++childIdx];
            }else{
              if (elt.compareTo(child) >= 0) {
                return;
              }  
            }
            
            swap(eltIdx, childIdx);
            eltIdx = childIdx;
            childIdx = eltIdx * 2 + 1;
        }
    }

    @Override
    public Tip removeFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Tip elt = (Tip) heap[0];
        swap(0, --end);
        bubbleDown(0);
        return elt;
    }

    private void swap(int a, int b) {
        Object tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    @Override
    public Tip getFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return (Tip) heap[0];
    }

    @Override
    public int depth() {
        if (end == 0) {
            return 0;
        }
        return (int) (Math.log(end) / Math.log(2)) + 1;
    }

    @Override
    public boolean isEmpty() {
        return end == 0;
    }

    @Override
    public int size() {
        return end;
    }

    @Override
    public Tip remove(Tip e) {
       
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
            
        }else{
            Tip elt = null;
            for(int i = 0; i< heap.length;i++){
                if(heap[i] == e){
                    elt = (Tip) heap[i];
                    swap(i, --end);
                    bubbleDown(i);
                    break;
                }
            }
            return elt;
        }
    }

    @Override
    public boolean exists(Tip e) {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        for(int i = 0; i< heap.length;i++){
            System.out.println(heap.length);
            if(heap[i] == e){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List asList(){
        List<Object> seznam = new ArrayList<Object>();
        if (this.isEmpty()) { 
            return seznam;
        }
        
        for(int i=0;i<size()+1;i++){
            for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<size()+1;j++){
                Object primer =heap[j+(int)Math.pow(2,i)-1];
                
                
                if(primer != null){
                   seznam.add(heap[j+(int)Math.pow(2,i)-1]); 
                }
            }
        }
        return seznam;
    }
    
    
    
    
    @Override
    public void print() {
        List<Tip> seznam = this.asList();
        
        for(int i=0;i<size()+1;i++){
            for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<size()+1;j++){
                Object primer =heap[j+(int)Math.pow(2,i)-1];
                int globina = this.depth();
                
                
                if(primer != null){
                   if(j+(int)Math.pow(2,i)-1 == 0){
                       if(globina == 2){
                         System.out.print("  ");  
                       }else{
                           System.out.print("   ");
                       }
                       
                   }
                   System.out.print(heap[j+(int)Math.pow(2,i)-1]);
                   if(j+(int)Math.pow(2,i)-1 != 0){
                       if(globina == 2){
                           System.out.print("  ");
                       }else{
                           System.out.print("   ");
                       }
                   }
                }
            }
            System.out.println();
        }
    }

    @Override
    public void save(OutputStream outputstream) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(outputstream);
        out.writeInt(this.size());
        if(this.isEmpty()){
            return;
        }else{
            for(int i=0;i<size()+1;i++){
            for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<size()+1;j++){
                Object primer =heap[j+(int)Math.pow(2,i)-1];
                if(primer != null){
                    out.writeObject(heap[j+(int)Math.pow(2,i)-1]);
                }
            }
        }
        }
        
    }

    @Override
    public void restore(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(inputStream);
        int count = in.readInt();
        
        for(int i = 0; i < count; i++){
            this.add((Tip) in.readObject());
        }
        
    }
}
