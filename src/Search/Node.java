package Search;
import java.util.*;
import Grid.*
public class Node {
	static HashMap<String, Integer> goal;
	HashMap<String, Integer> status;
	double h, g;
	Move lastmove = EMPTY;
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
