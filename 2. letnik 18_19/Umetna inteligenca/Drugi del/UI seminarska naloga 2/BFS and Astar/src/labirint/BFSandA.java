package labirint;

import java.util.LinkedList;

public class BFSandA {
	private LinkedList<Node> nextNodes = new LinkedList<Node>();
	private LinkedList<Node> visitedNodes = new LinkedList<Node>();
	private Node[][] labirint;
	private LinkedList<Point> finishPoints = new LinkedList<Point>();
	private int bfsOrA;
	private int numberOfAddedNodesToNext = 0;
	private int numberOfCheckedNodes = 0;
	
	public BFSandA(Labirint lab, int bfsOrA) {
		labirint = new Node[lab.labirint.length][lab.labirint[0].length];
		for(int i = 0; i < lab.labirint.length; i++) {
			for(int j = 0; j < lab.labirint[i].length; j++) {
				Node n = new Node(lab.labirint[i][j].value, lab.labirint[i][j].cost, false, lab.labirint[i][j].location);
				this.labirint[i][j] = n;
			}
		}
		this.labirint[lab.zacetek.y][lab.zacetek.x].visited = true;
		this.labirint[lab.zacetek.y][lab.zacetek.x].cost = 0;
		visitedNodes.addLast(this.labirint[lab.zacetek.y][lab.zacetek.x]);
		this.bfsOrA = bfsOrA;
		if(bfsOrA == 1) {
			for(int i = 0; i < lab.konec.size(); i++) {
				Point p = new Point(lab.konec.get(i).x, lab.konec.get(i).y);
				finishPoints.add(p);
			}
			this.labirint[lab.zacetek.y][lab.zacetek.x].distanceToNearestFinish = getShortestDistance(this.labirint[lab.zacetek.y][lab.zacetek.x]);
			this.labirint[lab.zacetek.y][lab.zacetek.x].cost = 0;
		}
	}
	
	private void addNeighbourToNextNodes(Node neighbour) {
		numberOfAddedNodesToNext++;
		for(int i = 0; i < nextNodes.size(); i++) {
			if(nextNodes.get(i).cost + nextNodes.get(i).distanceToNearestFinish > neighbour.cost + neighbour.distanceToNearestFinish) {
				nextNodes.add(i, neighbour);
				return;
			}
		}
		nextNodes.add(neighbour);
	}
	
	private double getShortestDistance(Node node) {
		double min = (double) Integer.MAX_VALUE;
		for(int i = 0; i < finishPoints.size(); i++) {
			int deltaX = finishPoints.get(i).x - node.location.x;
			int deltaY = finishPoints.get(i).y - node.location.y;
			double dist = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
			if(min > dist) {
				min = dist;
			}
		}
		return min;
	}
	
	private void changeCostAndAddItToListIfNeeded(Point point, Node node, Node neighbour) {
		double nextCost;
		numberOfCheckedNodes++;
		nextCost = node.cost;
		if(neighbour.value >= 0) {
			nextCost += neighbour.value;
		}
		if(bfsOrA == 1) {
			if(neighbour.distanceToNearestFinish == 0) {
				neighbour.distanceToNearestFinish = getShortestDistance(neighbour);
			}
		}
		if(!neighbour.visited && (neighbour.value >= 0 || neighbour.value == -3) && neighbour.cost > nextCost) {
			if(neighbour.cost != Integer.MAX_VALUE) {
				nextNodes.remove(neighbour);
			}
			neighbour.cost = nextCost;
			neighbour.previous = node;
			addNeighbourToNextNodes(neighbour);
		}
	}
	
	private void checkNeighbours(Point point, Node node) {
		Node neighbour = labirint[point.y][point.x-1];
		changeCostAndAddItToListIfNeeded(point, node, neighbour);
		neighbour = labirint[point.y-1][point.x];
		changeCostAndAddItToListIfNeeded(point, node, neighbour);
		neighbour = labirint[point.y][point.x+1]; 
		changeCostAndAddItToListIfNeeded(point, node, neighbour);
		neighbour = labirint[point.y+1][point.x]; 
		changeCostAndAddItToListIfNeeded(point, node, neighbour);
	}
	
	public Result getShortestPath() {
		Result res = new Result();
		LinkedList<Node> result = new LinkedList<Node>();
		while(visitedNodes.getLast().value != -3) {
			Node lastVisited = visitedNodes.getLast();
			checkNeighbours(lastVisited.location, lastVisited);
			visitedNodes.addLast(nextNodes.getFirst());
			visitedNodes.getLast().visited = true;
			nextNodes.removeFirst();
		}
		result.addFirst(visitedNodes.getLast());
		while(result.getFirst().value != -2) {
			result.addFirst(result.getFirst().previous);
		}
		res.result = result;
		res.numberOfAddedNodesToNextNodeList = numberOfAddedNodesToNext;
		res.numberOfCheckNodes = numberOfCheckedNodes;
		res.numberOfAddedNodesToVisitedList = visitedNodes.size();
		return res;
	}
}
