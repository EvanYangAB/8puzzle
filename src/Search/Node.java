package Search;
import java.util.*;
import Search.*;
class Node {
	static Value[][] goal;
	Grid status;
	double h, g;
	Move lastmove = Move.EMPTY;
	Node fatherNode = null;
	
	public enum Move{
		UP, DOWN, LEFT, RIGHT, EMPTY;
	}

	public Node(Value[][] data, double stepsIn, Move lastmoveIn, Node fatherNodeIn){
		fatherNode = fatherNodeIn;
		this(data, stepsIn, lastmoveIn);
	}

	public Node(Value[][] data, double stepsIn, Move lastmoveIn){
		lastmove = lastmoveIn;
		this(data, stepsIn);
	}

	public Node(Value[][] data, double stepsIn){
		status = new Grid(data);
		h = stepsIn;
	}

	//set g of this current node and return g value
	public double gOfx(){

	}

	public boolean isGoal(){
		return status.sameAs(goal);
	}
}
