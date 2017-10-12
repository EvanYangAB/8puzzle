package Search;
import java.util.*;
import Search.*;
import Search.Node.Move;

class Grid {
	public enum Value{
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, EMPTY
	}
	Value[][] grid = new Value[3][3];
	class Point{
		int col, row;
		Value piece = Value.EMPTY;

		public Point(int colIn, int rowIn, Value pieceIn){
			col = colIn;
			row = rowIn;
			piece = pieceIn;
		}
	}
	
	public Grid(Value[][] data){
		grid = copy(data);
	}

	public Value[][] getGrid(){
		return grid;
	}

	Value[][] copy(Value[][] data){
		Value[][] temp = new Value[3][3]; 
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				temp[i][j] = data[i][j];
		return temp;
	}

	// maybe require a safe check of returning an empty grid
	// assuming the input step is valid:means need to be checked outside
	Grid change(Move step) throws Exception{
		Grid temp = null;
		int i = 0, j = 0;
		while(i < 3){
			if(grid[i][j] != Value.EMPTY)
				if(j == 2){
					j = 0;
					i ++;
				}
				else
					j++;
			else
				switch (step) {
					case UP:
						if(i - 1 < 0)
							throw new Exception("error in grid change method: wrong step");
						temp = new Grid(swap(i, j, i - 1, j));
						break;
					case DOWN:
						if(i + 1 > 2)
							throw new Exception("error in grid change method: wrong step");
						temp = new Grid(swap(i, j, i + 1, j));
						break;
					case LEFT:
						if(j - 1 < 0)
							throw new Exception("error in grid change method: wrong step")
						temp = new Grid(swap(i, j, i, j + 1));
						break;
					case RIGHT:
						if(j + 1 > 2)
							throw new Exception("error in grid change method: wrong step")
						temp = new Grid(swap(i, j, i, j - 1));
						break;
					default:
						throw new Exception("error in grid change method: empty step input");
				}
		}
		if(temp == null)
			throw new Exception("error in grid change method: grid has not changed");
		return temp;
	}

	// a and b is a pair of col and row(a is col and b is row),
	// similar with the other group cd.
	Value[][] swap(int a, int b, int c, int d){
		Value[][] tempG = copy(grid);
		Value tempV;
		tempV = tempG[a][b];
		tempG[a][b] = tempG[c][d];
		tempG[c][d] = tempV;
		return tempG;
	}

	boolean sameAs(Grid anotherGrid){
		return sameAs(anotherGrid.getGrid());
	}

	boolean sameAs(Value[][] otherArray){
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(grid[i][j] != otherArray[i][j])
					return false;
		return true;
	}
}
