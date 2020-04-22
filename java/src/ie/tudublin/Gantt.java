// Labtest 22/04/2020
// Daniel Foley
// c17335606
// compiled using shell scripts
// https://github.com/FunsizeEvil/OOP-LabTest-2020-Starter

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

	public void displayTasks()
	{
		//create a border to work off
		float border = width * 0.05f;
		int numOfDays = 30;


		pushMatrix();
		stroke(0, 0 ,255);
		textAlign(CENTER, CENTER);
		for(int i = 0; i < numOfDays; i++){
			// Draws the grid 
			float x = map(i, 0, 30, border, width - border);
			line( x, border, x, height - border);
			fill(0);
        	textSize(10);
        	text(i + 1, x, 5);

		}
		popMatrix();
	}
	
	public void setup() 
	{
		loadTasks();
		printTasks();
		displayTasks();
	}
	
	public void draw()
	{			
		background(255);
		stroke(0);
	}
}
