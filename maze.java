/*============================================================================
 * Project I  : A Graphical Implementation of the Maze Solver 
 * Group  7   : Bandara W.G.N (E/10/049)
				Kanchana H.A.G.M (E/10/170)  
=============================================================================
 * mace class: 
=============================================================================*/

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class maze extends GCompound{
	
	int raws,columns,cell_size;
	Path[][] grid;
	
	public maze(int raws,int columns,int cell_size)
	{
		this.raws=raws;
		this.columns=columns;
		grid=new Path[raws+2][columns+2];
		
		for(int i=0;i<raws+2;i++){
			for(int j=0;j<columns+2;j++){
				
				grid[i][j]=new Path(cell_size);
				add(grid[i][j],cell_size*j,cell_size*i);
				grid[i][j].set_label(columns*i+j-columns);
				
				if(i*j==0 || i==(raws+1) || j==(columns+1)){	
					grid[i][j].make_wall();
				}
			}
		}
	}
		
	/* mark the given cels as walls */
	public void mark_walls(String[] walls)
	{
		int temp,x,y;
		int n=walls.length;
		for(String s: walls){	
			temp=Integer.parseInt(s);
			x=(temp-1)%columns+1;
			y=(temp-1)/columns+1;
			grid[y][x].make_wall();
		}	
	}
	
	/* remove the numbered labels from maze */
	public void remove_labels()
	{
		for(int i=1;i<raws+1;i++){
			for(int j=1;j<columns+1;j++){
				grid[i][j].remove_label();
			}
		}
	}
	
	/* check weather the given location is a wall */
	public boolean is_unvisited_path(int x,int y)
	{
		if(grid[y][x].free_to_go==1)
			return true;
		else
			return false;
		
	}	
	
	/* mark the already visited path cells */
	public void mark_visited(int n)
	{
		grid[(n-1)/columns+1][(n-1)%columns+1].free_to_go=0;
		grid[(n-1)/columns+1][(n-1)%columns+1].set_label(0);
	}
	
	
}
	
