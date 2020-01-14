//Author: Austin Ellsworth
//This class is intended to be the driver of the Queen class
//to demonstrate its logic and perform a solution to the N-Queens problem

import java.util.Scanner;

public class QueenSimulation {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Wecome to my Queens Simulation!");
		System.out.print("What size board are we solving? ");
		int sizeOfBoard = keyboard.nextInt(), solutions = 0, row = 1, column = 1;
		LinkedStack<Queen> solutionStack = new LinkedStack<Queen>();
		Queen ghostQueen = new Queen(row, column);
		boolean allSolutionsFound = false, queenSetSafe = true;
		System.out.println("Welcome to my N-Queens simulation");
		String solutionSet = "";
	
		while(!allSolutionsFound) {
		queenSetSafe = true;
		System.out.println("Current Queen: " + ghostQueen.toString());
		System.out.println("Current in stack: " + solutionStack.size());
				//is there a conflict?
				for(int i = 0; i < solutionStack.size(); i++) {
					
					if(ghostQueen.conflict((Queen)solutionStack.itemAt(i))) {
						System.out.println("Conflict with " + (Queen)solutionStack.itemAt(i) + "\n");
						queenSetSafe = false;
					}
				}	
				//no conflict set queen
				if(queenSetSafe) {
					solutionStack.push(new Queen(ghostQueen.getRow(), ghostQueen.getColumn()));
					System.out.print("ADDED a queen at " + ghostQueen.toString());
					ghostQueen.setColumn(1);
					
					ghostQueen.setRow(ghostQueen.getRow() + 1);
				}
					
			
			//backtrack
			if(ghostQueen.getColumn() >= sizeOfBoard && !queenSetSafe) {
				if(solutionStack.peek().getRow() == 1 && solutionStack.peek().getColumn() == sizeOfBoard) { //catch final pop
					allSolutionsFound = true;
				} else { 
					System.out.println("POPPED a queen at " + (solutionStack.peek()));
					ghostQueen = solutionStack.pop();
					if(ghostQueen.getColumn() == sizeOfBoard) {
						System.out.println("POPPED a queen at " + (solutionStack.peek()));
						ghostQueen = (solutionStack.pop());
					}
				}
			}
			
			if(!queenSetSafe && ghostQueen.getColumn() < sizeOfBoard) { //increment columns
				ghostQueen.setColumn(ghostQueen.getColumn() + 1);
			}
			
			if(solutionStack.size() == sizeOfBoard) { //each solution
				solutions++;
				solutionSet += "Soltuion #" + solutions + ": ";
				for(int m = sizeOfBoard - 1; m >= 0; m--) {
					solutionSet += (solutionStack.itemAt(m).toString());
				}	
				solutionSet += "\n";
				
				if(ghostQueen.getRow() == 1 && ghostQueen.getColumn() == sizeOfBoard) {
					allSolutionsFound = true;
				} else {
					System.out.println("POPPED a queen at " + (solutionStack.peek()));
					ghostQueen = solutionStack.pop();
					ghostQueen.setColumn(ghostQueen.getColumn() + 1);
				}
	
			}	
			if(allSolutionsFound) {
				System.out.print(solutionSet);
			}
		}
		System.out.println("There were " + solutions + " solutions\n\nThanks for using my program!");
		
		keyboard.close();
	}
}