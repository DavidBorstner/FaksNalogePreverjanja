package labirint;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class Main {

	static String vhodnaDatoteka;
	
	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}
		vhodnaDatoteka = new String(args[0]);
		Labirint labirint = new Labirint(vhodnaDatoteka);
		BFSandA bfs = new BFSandA(labirint, 0);
		Result bfsResult = bfs.getShortestPath();
		System.out.println("BFS RESULT:");
		System.out.println("Number of steps: " + bfsResult.result.size());
		System.out.println("Cost: " + bfsResult.result.getLast().cost);
		System.out.println("Number of checks: " + bfsResult.numberOfCheckNodes);
		System.out.println("Number of nodes added to visited List: " + bfsResult.numberOfAddedNodesToVisitedList);
		System.out.println("Number of nodes added to next Nodes List: " + bfsResult.numberOfAddedNodesToNextNodeList);
		for(int i = 0; i < bfsResult.result.size(); i++) {
			System.out.println(bfsResult.result.get(i).location.x + ", " + bfsResult.result.get(i).location.y);
		}
		BFSandA a = new BFSandA(labirint, 1);
		Result aResult = a.getShortestPath();
		System.out.println("A* RESULT:");
		System.out.println("Number of steps: " + aResult.result.size());
		System.out.println("Cost: " + aResult.result.getLast().cost);
		System.out.println("Number of checks: " + aResult.numberOfCheckNodes);
		System.out.println("Number of nodes added to visited List: " + aResult.numberOfAddedNodesToVisitedList);
		System.out.println("Number of nodes added to next Nodes List: " + aResult.numberOfAddedNodesToNextNodeList);
		for(int i = 0; i < aResult.result.size(); i++) {
			System.out.println(aResult.result.get(i).location.x + ", " + aResult.result.get(i).location.y + "  distance to finish: " + aResult.result.get(i).distanceToNearestFinish);
		}
	}
}
