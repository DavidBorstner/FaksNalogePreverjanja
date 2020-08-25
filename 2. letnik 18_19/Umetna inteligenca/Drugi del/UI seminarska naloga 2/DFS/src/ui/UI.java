/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David
 */


class Node {
    private int x;
    private int y;
    
    private int dolzina = 0;

    Node(int x, int y, int dolzina){
        this.x = x;
        this.y = y;
        this.dolzina = dolzina;
    }


    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    @Override
    public int hashCode(){
        return this.getX()+this.getY()+31;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false; 
        Node tmp = (Node) obj; 
        return tmp.getX() == this.getX() && this.getY() == tmp.getY();
    }

    @Override 
    public String toString(){
        return "x: " + this.getX() + " y: " + this.getY();
    }
    
    public void povecaj(){
        this.dolzina++;
    }
    public void zmanjsaj(){
        this.dolzina--;
    }
    
    public int dol(){
        return dolzina;
    }
}


public class UI {
    public int dol = 0;

    public static List<int[]> tocke = new ArrayList<int[]>();
    
    private int[][] labirint;
    private Node[][] prejsnja;

    private int X;
    private int Y;

    private Node zadnjiNode;

    public UI(int[][] maze, int sizeY, int sizeX) {
        this.labirint = maze;
        this.Y = sizeY;
        this.X = sizeX;

        prejsnja = new Node[sizeY][sizeX];
    }

    private boolean inBoundsX(int n){
        return n >= 0 && n < X;
    }

    private boolean inBoundsY(int n){
        return n >= 0 && n < Y;
    }

    
    public int[] zacetek(int[][] maze){
        int[] zac = new int[2];
        
        for(int i = 0; i< maze.length;i++){
            for(int j = 0; j< maze[i].length;j++){
                if(maze[i][j] == -2){
                    zac[0] = i;
                    zac[1] = j;
                }
            }
        }
        return(zac);
    }
    
    public void isci(Node start){
        Stack<Node> stack = new Stack<>();
        HashSet<Node> obiskano = new HashSet<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            Node tmp = stack.pop();
            obiskano.add(tmp);
            dol = tmp.dol();

            
            if (labirint[tmp.getY()][tmp.getX()] == -3) {
                zadnjiNode = tmp;
                break;
            }

            for(Node node : this.SosednjeKoordinate(tmp)) {
                if (!obiskano.contains(node)) {
                    stack.push(node);
                    prejsnja[node.getY()][node.getX()] = tmp;
                }
            }
        }
    }

    public void izpis() {
        List<int[]> koo = new ArrayList<int[]>();
        int stevec = 0;
        System.out.println("Koordinate: ");
        while(true){
            zadnjiNode = prejsnja[zadnjiNode.getY()][zadnjiNode.getX()];

            if (zadnjiNode == null) {
                break;
            }
            int [] k = {zadnjiNode.getX(),zadnjiNode.getY()};
            koo.add(k);
            tocke.add(k);
            int vrednost = labirint[zadnjiNode.getY()][zadnjiNode.getX()];
            if(vrednost > 0){
                stevec = stevec + vrednost;  
            }
        }    
        Collections.reverse(koo);
        for(int[] e: koo){
            System.out.println("x: " + e[0] + " y: " + e[1]);
        }
        System.out.print("Cena: ");
        System.out.println(stevec);
        System.out.print("Globina: ");
        System.out.println(dol);
    }

    private List<Node> SosednjeKoordinate(Node tmp) {
        List<Node> sosedi = new ArrayList<Node>();
        if(this.inBoundsY(tmp.getY()+1)){
            if(this.labirint[tmp.getY()+1][tmp.getX()] != -1){
                sosedi.add(new Node(tmp.getX(), tmp.getY()+1, tmp.dol()+1));
            }
        }
        if(this.inBoundsX(tmp.getX()+1)){
            if(this.labirint[tmp.getY()][tmp.getX()+1] != -1){
                sosedi.add(new Node(tmp.getX()+1, tmp.getY(), tmp.dol()+1));
            }
        }
        if(this.inBoundsX(tmp.getX()-1)){
            if(this.labirint[tmp.getY()][tmp.getX()-1] != -1){
                sosedi.add(new Node(tmp.getX()-1, tmp.getY(), tmp.dol()+1));
            }
        }
        if(this.inBoundsY(tmp.getY()-1)){
            if(this.labirint[tmp.getY()-1][tmp.getX()] != -1){
                sosedi.add(new Node(tmp.getX(), tmp.getY()-1, tmp.dol()+1));
            }
        }
        return sosedi;
    }
    
    
    
    public static void main(String[] args) {
      
        
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\David\\Documents\\NetBeansProjects\\UI\\src\\labyrinth_12.txt"));
            
            
            int st_vrstic = 0;
            int st_stolpcev = 0;
            while(sc.hasNext()){               
                String lab = sc.next();
                st_vrstic++;
                
                String[] delitev = lab.split(",");
                st_stolpcev = delitev.length;
                
            }
            
            int[][] labirint  = new int[st_vrstic][st_stolpcev];
            
            sc = new Scanner(new File("C:\\Users\\David\\Documents\\NetBeansProjects\\UI\\src\\labyrinth_12.txt"));
            int stevec =0;
            while(sc.hasNext()){               
                String lab = sc.next();                
                String[] delitev = lab.split(",");
                for(int i = 0; i< labirint.length;i++){
                    labirint[stevec][i] = Integer.parseInt(delitev[i]);
                }
                stevec++;
            }
            

            
            UI m = new UI(labirint, labirint.length,labirint[1].length);
            
            int[] zacetek = m.zacetek(labirint);
            m.isci(new Node(zacetek[1], zacetek[0],0));
            
            m.izpis();
            
            for(int i = 0; i<labirint.length;i++){
                for(int j = 0; j<labirint[i].length;j++){
                    System.out.print(labirint[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            
            for(int i = 0; i<labirint.length;i++){
                for(int j = 0; j<labirint[i].length;j++){
                    for(int[] e: tocke){
                        int iks = e[0];
                        int ips = e[1];
                        if(iks == j && ips == i){
                            labirint[i][j] = -5;
                        }
                    }
                }
            }
            
            String vrstica ="";
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex); 
        }
       
    }
    
}
