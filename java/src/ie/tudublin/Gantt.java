package ie.tudublin;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;
import processing.core.PApplet;

public class Gantt extends PApplet
{	
	//Create arraylist for task
	//
	public ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv","header");
		//reads for each row in tasks and adds the row data to as a new 
		// part of the ArrayList instnace of tasks
		//
		for(TableRow row:table.rows()){
			Task t = new Task(row);
			tasks.add(t);
		}
	}

	public void printTasks()
	{
		System.out.println("tasks to be completed \n");
		// prints out each row of the ArrayList to terminal
		//
		for(Task t:tasks){
			System.out.println(t);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(255);
	}
}
