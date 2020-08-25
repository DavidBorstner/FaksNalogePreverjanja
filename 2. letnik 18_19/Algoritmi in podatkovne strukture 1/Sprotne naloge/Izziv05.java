package izziv05;

public class Izziv05 {

interface Comparable{
  public int compareTo(Object o);
  
  
}    
 
    
public static class Oseba implements Comparable{
    final String[] imena = {"Alja","Maja","Ela","Janez","Miha","Andrej","Mojca","Ana"};
    final String[] priimki = {"Kovač","Cerar","Pahor","Doncic","Novak","Marko"};
    final int[] leta = {1998,1991,1957,1974,1982,1987,2001,1963,2004};
    static int stevecI = 0;
    static int stevecP = 0;
    static int stevecL = 0;
    
    String priimek;
    String ime;
    int letoR;
    
    static int atr = 0;
    static int smer = 0; // 0 = od spredi naprej, 1 = od zadi naprej 
        
    public Oseba(String priimek, String ime, int leto){
        this.priimek = priimek;
        this.ime = ime;
        this.letoR = leto;
    }
    
    public Oseba(){
        if(stevecI == imena.length){
            stevecI = 0;
        }
        if(stevecP == priimki.length){
            stevecP = 0;
        }
        if(stevecL == leta.length){
            stevecL = 0;
        }
        ime = imena[stevecI];
        priimek = priimki[stevecP];
        letoR = leta[stevecL];
        stevecI++;
        stevecP++;
        stevecL++;
    }
    
    public String izpis(){
        return ("Ime osebe je: " + this.ime + " ,priimek: " + this.priimek + " ,leto rojstva: " + this.letoR);
    }
    
    @Override
    public String toString() {
        switch(atr){
            case 0: return (this.ime);
            case 1: return (this.priimek);
            case 2: return (Integer.toString(this.letoR));
            default: return null;
        }
    }

    @Override
    public int compareTo(Object o) {
        Oseba os = (Oseba) o;
        switch(atr){
            case 0: return (this.ime.compareTo(os.ime));
            case 1: return (this.priimek.compareTo(os.priimek));
            case 2: return (this.letoR - os.letoR);
            default: return 0;
        }
    }   
    
    public static void setAtr(int a){
        if(a < 3 && a > -1){
          atr = a;  
        }
        
    }
    
    public static int getAtr(){
        return(atr);
    }
    
    public static void setSmer(int a){
        if(a == 1 || a == 0){
          smer = a;  
        }
        
    }
    
    public static int getSmer(){
        return(smer);
    }
}



public static void BubbleSort(Comparable[] a){
    
}

    public static void main(String[] args) {
        Oseba[] t = new Oseba[10];
        Oseba ja = new Oseba("ja","ne",1234);
        for(int i = 0; i< 10;i++){
            t[i] = new Oseba();
        }
        for(int i = 0; i<t.length;i++){
        System.out.println(t[i].izpis());
        }
        t[0].setAtr(2);
        t[0].setSmer(0);
        
        BubbleSort(t);
    }
    
}
