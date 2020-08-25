
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class Element<Tip> {
public Tip vrednost;
public Element<Tip> vezava;
public Element(Tip e) {
vrednost = e;
}
}
public class Sklad<Tip> {
private Element<Tip> vrh;
    private int stevec = 0;
public Sklad() {
}

public void push(Tip e)
{
Element<Tip> novVrh = new Element<Tip>(e);
novVrh.vezava = vrh;
vrh = novVrh;
this.stevec++;
}

public boolean isEmpty()
{
return (null == vrh);
}

public Tip top(){
    if(isEmpty()){
        throw new EmptyStackException();
    }
    return vrh.vrednost;
}

public int size(){
	if(isEmpty()){
        throw new EmptyStackException();
    }
    return this.stevec;
}

public Tip pop() {            
    if (null == vrh) {
        throw new java.util.NoSuchElementException();
    }
            
    Tip e = vrh.vrednost;
    vrh = vrh.vezava;
    stevec--;
    return e;

}
}
