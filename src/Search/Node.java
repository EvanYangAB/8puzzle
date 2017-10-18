package Search;
import java.util.*;
import Search.*;
import Search.Grid.Value;
class Node {
	static Value[][] goal;
	static ArrayList<Node> queue = new ArrayList<Node>();
	static ArrayList<Node> searchedQueue = new ArrayList<Node>();
	Grid status;
	int f, h;
	Move lastmove = Move.EMPTY;
	Node fatherNode = null;
	
	public enum Move{
		UP, DOWN, LEFT, RIGHT, EMPTY;
	}

	public Node(Grid data, int stepsIn, Move lastmoveIn, Node fatherNodeIn) 
															throws Exception{
		this(data, stepsIn, lastmoveIn);
		fatherNode = fatherNodeIn;
	}

	public Node(Grid data, int stepsIn, Move lastmoveIn) throws Exception{
		this(data, stepsIn);
		lastmove = lastmoveIn;
	}

	public Node(Grid data, int stepsIn) throws Exception{
		status = data;
		f = stepsIn;
		h = hOfx();
	}

	//set h of this current node and return h value
	public int hOfx() throws Exception{
		return status.manhattanDistance();
	}

	public int gofX(){
		return h + f;
	}

	public boolean isGoal(){
		return h == 0;
	}

	static public void addToQue(Node toBeAdded){
		queue.add(toBeAdded);
	}

	// remove current node from the queue to
	// searched queue
	static public void operator() throws Exception{
		while(!queue.isEmpty()){
			Node current = queue.get(0);
			queue.remove(0);

			// check goal
			if(current.isGoal()){
				System.out.println("Goal reached!");
				current.printGoal();
				return;
			}
			// optimization

			queue.add(current.displacement(Move.LEFT));
			queue.add(current.displacement(Move.RIGHT));
			queue.add(current.displacement(Move.UP));
			queue.add(current.displacement(Move.DOWN));

			// ensure there is no duplicates and remove nulls
			Set<Node> nodeSet = new HashSet<>();
			nodeSet.addAll(queue);
			queue.clear();
			queue.addAll(nodeSet);
			queue.remove(null);

			queue.sort(Comparator.comparing(Node::gofX, 
				Comparator.nullsLast(Comparator.naturalOrder())));
		}
	}

	// return a new node moving the white
	// block to other locations
	Node displacement(Move direction) throws Exception{
		Grid temp = status.change(direction);
		if(temp == null)
			return null;
		return new Node(status.change(direction), f + 1, direction, this);
	}

	void printGoal() throws Exception{
		if(fatherNode != null){
			fatherNode.printGoal();
			System.out.println(lastmove.name());
		}
		System.out.println(this);
	}

	Move reverse(Move blank) throws Exception{
		switch (blank) {
			case DOWN:
				return Move.UP;
			case UP:
				return Move.DOWN;
			case LEFT:
				return Move.RIGHT;
			case RIGHT:
				return Move.LEFT;
			default:
				throw new Exception("error in reverse method: empty step input");
		}
	}

	public String toString(){
		String result;
		try {
			result =  hOfx() + "\n" + status.toString();
		} catch (Exception e) {
			result = "error in calculating h";
		}
		return result;
	}
}
