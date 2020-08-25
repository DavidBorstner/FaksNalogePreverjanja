package labirint;

public class Node {
	public int value;
	public double cost;
	public boolean visited;
	public Point location;
	public double distanceToNearestFinish;
	public Node previous;
	
	public Node(int value, double cost, boolean visited, Point location) {
		this.value = value;
		this.cost = cost;
		this.visited = visited;
		this.location = location;
		this.distanceToNearestFinish = 0;
	}
}
