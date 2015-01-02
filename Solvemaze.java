/*============================================================================
 * Project I  : A Graphical Implementation of the Maze Solver 
 * Group  7   : Bandara W.G.N (E/10/049)
				Kanchana H.A.G.M (E/10/170)  
=============================================================================
 * Solvemaze class: 
=============================================================================*/

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Solvemaze extends GraphicsProgram{
	
	public void run() {
		
		/* size of a cell in pixels*/
		int cell_size=20;
		
		/* Dialog program to get user inputs*/
		DialogProgram dialog = new DialogProgram(){};
		
		int raws=dialog.readInt("Enter number of raws needed");
		int columns=dialog.readInt("Enter number of columns needed");
		
		/* create a new maze */
		maze Maze = new maze(raws,columns,cell_size);
		add(Maze,cell_size,cell_size);
		
		/* get the wall umbers from user */
		String walls=dialog.readLine("Enter comma seperated wall numbers");
		
		/* mark the given cells as walls */
		Maze.mark_walls(walls.split(","));
		
		int start=dialog.readInt("Enter the starting cell");
		int end=dialog.readInt("Enter the ending cell");
		Maze.remove_labels();
		
		/* create robot object and put it in start location*/
		robot myrobot=new robot(Maze,start);
		/* tell the robot to find the path to end location*/
		myrobot.findpath(end);

	}

}

