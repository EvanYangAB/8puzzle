package Search;
import java.util.*;
import Search.*;
class Node {
	static Value[][] goal;
	Value[][] status;
	double h, g;
	Move lastmove = Move.EMPTY;
	Node fatherNode = null;
	
	public enum Move{
		UP, DOWN, LEFT, RIGHT, EMPTY;
	}

	public Node(HashMap<String, Integer> data, double stepsIn){
		status.putAll(data);
		h = stepsIn;
	}

	//set g of this current node and return g value
	public double gOfx(){

	}
}
