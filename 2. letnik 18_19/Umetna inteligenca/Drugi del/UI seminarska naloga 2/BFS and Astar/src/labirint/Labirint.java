package labirint;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Labirint {
	ArrayList<String> podatki = new ArrayList<String>();
	public Node labirint[][];
	public Point zacetek;
	public LinkedList<Point> konec = new LinkedList<Point>();
	
    Labirint(String vhodnaDatoteka) {
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(vhodnaDatoteka)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		String vrstica = "";
		int steviloVrstic = 0;
		int steviloStolpcev = 0;
		while(scanner.hasNextLine()){
			vrstica =  scanner.nextLine();
			podatki.add(vrstica);
			steviloVrstic++;
		}
		scanner.close();
		if (steviloVrstic > 0) {
			String[] tokens = vrstica.split(",");
			steviloStolpcev = tokens.length;
		}
	    labirint = new Node[steviloVrstic][steviloStolpcev];
	    int i = 0;
	    for (String v:podatki) {
			String[] elementi = v.split(",");
		    int j = 0;
	    	for (String e:elementi) {
	    		int ei = Integer.parseInt(e.trim());
	    		if (ei == -2) {
	    			zacetek = new Point(j,i);
	    			labirint[i][j] = new Node(ei, Integer.MAX_VALUE, false, zacetek);
	    		}
	    		else if (ei == -3) {
	    			konec.add(new Point(j,i));
	    			labirint[i][j] = new Node(ei, Integer.MAX_VALUE, false, konec.getLast());
	    		}
	    		else {
	    			labirint[i][j] = new Node(ei, Integer.MAX_VALUE, false, new Point(j,i));
	    		}
	    		j++;
	    	}
	    	i++;
	    }
	}		
}

