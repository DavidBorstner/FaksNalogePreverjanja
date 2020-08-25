/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package izziv01;

import java.util.Random;

/**
 *
 * @author David
 */
public class Izziv01 {

    public static int[] generateTable(int n){
			int[] tabela = new int[n];
			for(int a = 0; a < n; a++){
				tabela[a] = a+1;
			}
			return(tabela);
	}
	
	private static int findLinear(int[] a, int v){ //linearni
		for(int i = 0; i< a.length; i++){
			if(a[i] == v){
				return(i);
			}
		}
		return(-1);
	}
	
	private static int findBinary(int[] a, int l, int r, int v){ // logaritemski
		if(l > v){
			return(-1);
		}
		int m = (l+r)/2;
		if(a[m] == v){
			return m;
		}else{
			if(a[m] > v){
				return findBinary(a,l,m-1,v);
			}else{
				return findBinary(a,m+1,r,v);
			}
		}
	}
	
	private static long timeLinear(int n){
                int[] tabela = generateTable(n);          
                Random ran = new Random();
                long startTime = System.nanoTime(); 
                for(int i = 0; i< 1000; i++){
                    int x = ran.nextInt(n) +1;
                    findLinear(tabela,x);                    
                }
                
                long execution = System.nanoTime() - startTime;
                return (execution/1000);
	}
        
        private static long timeBinary(int n){
                int[] tabela = generateTable(n);          
                Random ran = new Random();
                long startTime = System.nanoTime(); 
                for(int i = 0; i< 1000; i++){
                    int x = ran.nextInt(n) +1;
                    findBinary(tabela,0,n,x);                    
                }
                long execution = System.nanoTime() - startTime;
                return (execution/1000);
	}
        
        
        
    public static void main(String[] args) {
		int[] nekaj = generateTable(10);
		System.out.println("     n     |     linearno  |   dvojisko  |");
                System.out.println("-----------+---------------+-------------+");
                for(double i = Math.pow(10, 5); i<Math.pow(10, 6); i= i+ Math.pow(10,4)){
                    int vrednost = (int) i;
                    System.out.printf("%10d |", vrednost);
                    long linearni = timeLinear(vrednost);
                    System.out.printf("%14d |", linearni);
                    long binarni = timeBinary(vrednost);
                    System.out.printf("%12d |\n", binarni);
                    
                }
    }
    
}
