package Search;
import java.util.*;
import Search.Grid.Value;
import static Search.Node.Move;

class Initializer{
	static Stack<Move> steps = new Stack<>();
	private final static List<Move> MOVES = Collections.unmodifiableList(
			Arrays.asList(Move.UP, Move.DOWN, Move.LEFT, Move.RIGHT));
	private final static Random RANDOM = new Random();
	private final static int SIZE = MOVES.size();

	public static void initialize() throws Exception{
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
		for(int i = 0; i < 11; i ++){
			System.out.println("initialize function:" + i);
			start = randomizeStep(start);
		}
		System.out.println("11111");
		System.out.println(start);
	}

	static Grid randomizeStep(Grid recipient) throws Exception{
		Move temp;
		Grid modified = null;
		int i = 0;
		do{
			System.out.println(i++);
			temp = MOVES.get(RANDOM.nextInt(4));
			modified = recipient.change(temp);
		} while(modified == null);
		steps.push(temp);
		return modified;
	}

	public static void main(String[] args) throws Exception {
		initialize();
	}
}