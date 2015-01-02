/*============================================================================
 * Project I  : A Graphical Implementation of the Maze Solver 
 * Group  7   : Bandara W.G.N (E/10/049)
				Kanchana H.A.G.M (E/10/170)  
=============================================================================
 * robot class: 
=============================================================================*/

import java.util.Stack;

public class robot{
	
	int location;
	Stack  paths=new Stack();
	Stack junctions=new Stack();
	maze gmaze;
	
	public robot(maze gmaze,int start){
		
		this.gmaze=gmaze;
		location=start;
		junctions.push(start);
	}
		
	 /* method to find the path from current location to given location */
	public void findpath(int end)
	{
		int x,y;
		
		while(location!=end)
		{
			
		/* sleep the process so we can see the robot's moves as an animation*/
			try{ Thread.sleep(50); } 
			catch(InterruptedException ex)
          { Thread.currentThread().interrupt(); }
        
        /* save the current location in the stack */
			paths.push(location);
		/* hilight the current location */
			highlight_cell(location);
		/* mark the current location as visited so robot will not check this cell again */
			gmaze.mark_visited(location);
		
		/* if the current position is a junction, then save it in the junction stack */
			if(is_junction(location)>1){
				junctions.push(location);
			}
		
		/* if atleast one path is free, move the robot to one of that direction*/
			if(is_junction(location)>=1){
				
				x=getx(location);
				y=gety(location);
			
				if(gmaze.is_unvisited_path(x-1,y)){location--;}
				else if(gmaze.is_unvisited_path(x,y-1)){location-=gmaze.columns;}
				else if(gmaze.is_unvisited_path(x+1,y)){location++;}
				else if(gmaze.is_unvisited_path(x,y+1)){location+=gmaze.columns;}
				
			}	
			
			/* if there are no free paths to go, then com back to the last junction */
			else{
				while(location!=(int)junctions.peek()){
					/* remove the highlight from the location */
					remove_highlight(location);
					/* come to the last location */
					location=(int)paths.pop();
					
					/* sleep the process so we can see the robot's moves as an animation */
					try{ Thread.sleep(50); } 
					catch(InterruptedException ex)
						{ Thread.currentThread().interrupt(); }
				}
				
				/* if last junction is also blocked, remove it from the junction stack*/
				if(is_junction(location)==0){
					junctions.pop();
				}
				
			}	
		}
		
		/* mark the end position in red */
		mark_end(location);	
		
	}
	
	/* check weatheer the given location is a junction and return the number of free paths*/
	public int is_junction(int location)
	{
		int x,y,n=0;
		x=getx(location);
		y=gety(location);
		
		if(gmaze.grid[y+1][x].free_to_go==1){n++;}
		if(gmaze.grid[y][x+1].free_to_go==1){n++;}
		if(gmaze.grid[y-1][x].free_to_go==1){n++;}
		if(gmaze.grid[y][x-1].free_to_go==1){n++;}
		return n;
	}
	
	/* return the raw number for a given loacation*/
	public int gety(int n)
	{	
		return (n-1)/gmaze.columns+1;
	}
		
	/* return the column number for a given loacation*/
	public int getx(int n)
	{
		return ((n-1)%gmaze.columns+1);
	}
	
	/* highlight the cell in given location*/
	public void highlight_cell(int location){
			
		gmaze.grid[gety(location)][getx(location)].highlight();	
	}
	
	/* remove the highlight in given location*/
	public void remove_highlight(int location){
			
		gmaze.grid[gety(location)][getx(location)].remove_highlight();	
	}
	
	/* mark the cell as end location */
	public void mark_end(int location){
			
		gmaze.grid[gety(location)][getx(location)].mark_end();	
	}
    
}
