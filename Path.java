/*============================================================================
 * Project I  : A Graphical Implementation of the Maze Solver 
 * Group  7   : Bandara W.G.N (E/10/049)
				Kanchana H.A.G.M (E/10/170)  
=============================================================================
 * Path class : 
=============================================================================*/

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Path extends GCompound{
	
	int free_to_go=1;
	GRect rect;
	GLabel label;
	
	/* constructor*/
	public Path(double cell_size)
	{	
		rect = new GRect(cell_size,cell_size);
		rect.setFilled(true);
		rect.setFillColor(Color.white);
		rect.setColor(Color.gray);
		add(rect);
		label = new GLabel("");
		add(label,cell_size/2-10,cell_size/2+5);
	}
	
	/* method to set the label of a path */
	public void set_label(int n)
	{
		label.setLabel(Integer.toString(n));
	}
	
	/* method to remove the numbered label from cell*/
	public void remove_label()
	{
		remove(label);	
	}
		
	/* metod to change the path to a wall */
	public void make_wall()
	{
		free_to_go=0;
		rect.setFillColor(Color.black);
		remove(label);
	}
	
	/* method to highlight the cell in green */
	public void highlight()
	{
		rect.setFillColor(Color.green);
	}
	
	/*method to remove any highlight from cell */
	public void remove_highlight()
	{
		rect.setFillColor(Color.white);
	}
	
	/* method to hilight the cell in red */
	public void mark_end()
	{
		rect.setFillColor(Color.red);
	}
	
}



