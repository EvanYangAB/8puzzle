package Search;
import java.util.*;
import Search.Grid.Value;

class Initializer{
	public void initialize(){
		HValue[][]  goal = new Value[3][3] ;
		goal[0][0] = Value.EMPTY;
		goal[0][1] = Value.ONE;
		goal[0][2] = Value.TWO;
		goal[1][0] = Value.THREE;
		goal[1][1] = Value.FOUR;
		goal[1][2] = Value.FIVE;
		goal[2][0] = Value.SIX;
		goal[2][1] = Value.SEVEN;
		goal[2][2] = Value.EIGHT;


	}
}