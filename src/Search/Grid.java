package Search;

public class Grid {
	public enum Value{
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, EMPTY;
	}
	class Point{
		int col, row;
		Value piece = EMPTY;

	}
}
