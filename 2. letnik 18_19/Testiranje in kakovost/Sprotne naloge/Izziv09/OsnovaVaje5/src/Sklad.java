
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


class Element<Tip> {

    public Tip vrednost;
    public Element<Tip> vezava;

    public Element(Tip e) {
        this.vrednost = e;
    }
}

public class Sklad<Tip> implements Seznam<Tip> {

    private Element<Tip> vrh;

    public Sklad() {
    }

    public void push(Tip e) {
        Element<Tip> novVrh = new Element<>(e);
        novVrh.vezava = vrh;
        vrh = novVrh;
    }

    public Tip pop() {
        if (vrh == null) {
            throw new java.util.NoSuchElementException();
        }
        Tip e = vrh.vrednost;
        vrh = vrh.vezava;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return (vrh == null);
    }

    public Tip top() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return vrh.vrednost;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int stElementov = 0;
        Element<Tip> tmp = vrh;
        while (tmp != null) {
            stElementov++;
            tmp = tmp.vezava;
        }
        return stElementov;
    }

    public boolean isTop(Tip e) {
        if (vrh == null) {
            throw new java.util.NoSuchElementException();
        }
        return vrh.vrednost.equals(e);
    }

    public int search(Tip e) {
        Element<Tip> tmp = vrh;
        int i = 0;
        while (null != tmp) {
            if (tmp.vrednost.equals(e)) {
                return i;
            }
            i++;
            tmp = tmp.vezava;
        }
        return -1;
    }

    @Override
    public void add(Tip e) {
        this.push(e);
    }

    @Override
    public Tip removeFirst() {
        return this.pop();
    }

    @Override
    public Tip getFirst() {
        return top();
    }

    @Override
    public int depth() {
        return this.size();
    }

    @Override
    public Tip remove(Tip e) {
        Sklad<Tip> novo = new Sklad<Tip>();
        
        boolean pog = false;
        while(!this.isEmpty()){
            Tip zac = this.pop();
            if(zac == e){
                pog = true;
            }else{
                novo.push(zac);
            }
        }

        while(!novo.isEmpty()){
            Tip zac = novo.pop();
            this.push(zac);
        }

        if(pog == true){
            return e;
        }
        return null;
    }

    @Override
    public boolean exists(Tip e) {
        Sklad<Tip> novo = new Sklad<Tip>();
        
        boolean pog = false;
        
        while(!this.isEmpty()){
            Tip zac = this.pop();
            if(zac == e){
                pog = true;
            }
            novo.push(zac);
        }
        
        while(!novo.isEmpty()){
             Tip zac = novo.pop();
            this.push(zac);
        }
        
        return pog;
    }

    public List asList(){
        List<Tip> seznam = new ArrayList<Tip>();
        Sklad<Tip> novo = new Sklad<Tip>();
        
        while(!this.isEmpty()){  
            Tip zac = this.pop();
            seznam.add(zac);
            novo.push(zac);
        }
        
        while(!novo.isEmpty()){
            Tip zac = novo.pop();
            this.push(zac);
        }
        return(seznam);
    }
    
    
    @Override
    public void print() {
        if(vrh == null){
            return;
        }
        
        Sklad<Tip> novo = new Sklad<Tip>();
        
        while(!this.isEmpty()){  
            Tip zac = this.pop();
            System.out.print(zac + "\n");
            novo.push(zac);
        }
        
        while(!novo.isEmpty()){
            Tip zac = novo.pop();
            this.push(zac);
        }
    }

    @Override
    public void save(OutputStream outputstream) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(outputstream);
        out.writeInt(this.size());
        if(vrh == null){
            return;
        }
        Sklad<Tip> novo = new Sklad<Tip>();
        
        while(!this.isEmpty()){  
            Tip zac = this.pop();
            out.writeObject(zac);
            novo.push(zac);
        }
        
        while(!novo.isEmpty()){
            Tip zac = novo.pop();
            this.push(zac);
        }
        
    }

    @Override
    public void restore(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(inputStream);
        int count = in.readInt();
        while(!this.isEmpty()){
            this.pop();
        }
        Sklad<Tip> novo = new Sklad<Tip>();
        for(int i = 0; i< count; i++){
           novo.push((Tip) in.readObject());  
        }
        
        while(!novo.isEmpty()){
            this.push(novo.pop());
        }
          
    }
}
