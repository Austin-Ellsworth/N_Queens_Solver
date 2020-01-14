
//File: Queen.java
//This class represents queens on a chess board and will contain x and y coordinates for them.

/******************************************************************************
* Queen.java is a reference to a queen on a chess board.
*
* @author Austin Ellsworth
*
* @version
*   November 2019
******************************************************************************/
public class Queen 
{
	// Invariant of the Queen class:
	//   1. Each Queen has a row value
	//   2. Each Queen has a column value
	private int row;
	private int column;
	
	
	/**
	* Initialize a Queen with a specified row and column.
	* @param row
	*   the value of this Queens row.
	* @param column
	*   the value of this Queens column.
	* @postcondition
	*   This Queen contains the specified row and column values
	**/
	public Queen(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	/**
	* Accessor method to get the value of row. 
	* @param - none
	* @return
	*   value of this row.
	**/
	public int getRow() {
		return row;
	}

	/**
	* Modification method to set the row. 
	* @param row
	*   value to be set.
    * @postcondition
    *   this row is set to row.
	**/	
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	* Accessor method to get the value of column. 
	* @param - none
	* @return
	*   value of this column.
	**/
	public int getColumn() {
		return column;
	}
	
	/**
	* Modification method to set the column. 
	* @param column
	*   value to be set.
    * @postcondition
    *   this column is set to column.
	**/	
	public void setColumn(int column) {
		this.column = column;
	}
	
	/**
	* Check if there are conflicts between Queens.  
	* @param - a Queen object.
	* @return
	*   A boolean value is returned based on whether or not there is a conflict.
	**/
	public boolean conflict(Queen candidate) {
		int difference = this.row - candidate.row; //with diagonals, difference is the same for
		if (difference < 0) difference *= -1;	   //rows and columns
		boolean flag = false;
		if(this.row == candidate.row || this.column == candidate.column)
			return true;
		if(this.column < candidate.column) //if to the left of candidate
			flag = (candidate.column - this.column == difference && this.row - candidate.row == difference);
		if (this.column > candidate.column) //if to the right of candidate
			flag = (this.column - candidate.column == difference && this.row - candidate.row == difference);
		return flag;
	}
	
	/**
	* Output values of row and column for Queen. 
	* @param - none
	* @return
	* 	A string is returned with the values of row and column.
	**/
	@Override
	public String toString() {
		return "[row=" + row + ", column=" + column + "]   ";
	}

}
