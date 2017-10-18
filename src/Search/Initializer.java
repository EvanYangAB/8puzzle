package Search;
import java.util.*;
import Search.Grid.Value;
import Search.Node;
import Search.Node.Move;

class Initializer{
	static Stack<Move> steps = new Stack<>();
	private final static List<Move> MOVES = Collections.unmodifiableList(
			Arrays.asList(Move.UP, Move.DOWN, Move.LEFT, Move.RIGHT));
	private final static Random RANDOM = new Random();
	private final static int SIZE = MOVES.size();

	public static void initialize(int randomTimes) throws Exception{
		Value[][]  goal = new Value[3][3] ;
		goal[0][0] = Value.EMPTY;	 
		goal[0][1] = Value.ONE;
		goal[0][2] = Value.TWO;
		goal[1][0] = Value.THREE;
		goal[1][1] = Value.FOUR;
		goal[1][2] = Value.FIVE;
		goal[2][0] = Value.SIX;
		goal[2][1] = Value.SEVEN;
		goal[2][2] = Value.EIGHT;

		Node.goal = goal;
		Grid start = new Grid(goal);
		System.out.println(start);
		//randomize grid
		for(int i = 0; i < randomTimes; i ++){
			System.out.println("selecting random step:" + i);
			start = randomizeStep(start);
		}
		System.out.println("random grid initialized.");
		System.out.println(start);

		Node root = new Node(start, 0, Move.EMPTY, null);
		Node.addToQue(root);
		Node.operator();
	}

	static Grid randomizeStep(Grid recipient) throws Exception{
		Move temp;
		Grid modified = null;
		int i = 0;
		do{
			//System.out.println(i++);
			temp = MOVES.get(RANDOM.nextInt(4));
			System.out.println("step:" + temp.name());
			modified = recipient.change(temp);
			System.out.println("changed grid:\n" + modified);
			if(modified == null)
				System.out.println("randoming again for invalid step");
		} while(modified == null);
		if(modified != null){
			steps.push(temp);
			return modified;
		}
		System.out.println("------------------------------");
		return recipient;

	}

	public static void main(String[] args) throws Exception {
		initialize(40);
	}
}