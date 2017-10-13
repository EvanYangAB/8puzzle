package Search;
import java.util.*;
import Search.*;
class Node {
	static Value[][] goal;
	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> searchedQueue = new ArrayList<Node>();
	Grid status;
	double f, h;
	Move lastmove = Move.EMPTY;
	Node fatherNode = null;
	
	public enum Move{
		UP, DOWN, LEFT, RIGHT, EMPTY;
	}

	public Node(Grid data, double stepsIn, Move lastmoveIn, Node fatherNodeIn){
		fatherNode = fatherNodeIn;
		this(data, stepsIn, lastmoveIn);
	}

	public Node(Grid data, double stepsIn, Move lastmoveIn){
		lastmove = lastmoveIn;
		this(data, stepsIn);
	}

	public Node(Grid data, double stepsIn){
		status = data;
		f = stepsIn;
		h = hOfx();
	}

	//set h of this current node and return h value
	public double hOfx(){
		return status.manhattanDistance();
	}

	public double gofX(){
		return h + f;
	}

	public boolean isGoal(){
		return h == 0;
	}


	// remove current node from the queue to
	// searched queue
	static public void operator(){
		while(!queue.isEmpty()){
			Node current = queue.get(0);
			queue.remove(0);

			//check goal

			//optimization

			int i = 0, j = 0;
			while(i < 3)
				if(current.status.grid[i][j] != Value.EMPTY){
					if(j == 2){
						j = 0;
						i++;
					}
					else
						j++;
				}
				else 
					break;
			if(i - 1 >= 0)
				search.add(current.displacement(LEFT), current);
			if(i + 1 <= 2)
				search.add(current.displacement(RIGHT), current);
			if(j - 1 >= 0)
				search.add(current.displacement(UP), current);
			if(j + 1 <= 2)
				search.add(current.displacement(DOWN), current);
			sortQueue();
		}
	}
	// return a new node moving the white
	// block to other locations
	Node displacement(Move direction, Node fatherNode){}

	// sort the search queue
	public void sortQueue(){

	}
}
