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
		// Loads table in and tells the program it has a header and to skip that line.
		//
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
		//area for text
		float textBox = width * 0.20f;
		//vertical area for text 
		float textBoxHeight = height * 0.5f;
		int numOfDays = 31;
		//for HSB
		float colorGap = 255 / (float) tasks.size();
		//float daySpace = map(0, 0, numOfDays, textBox, width - border);


		
		pushMatrix();
		background(0);
		stroke(255);
		textAlign(CENTER, CENTER);
		// Draws the horizontal grid 
		for(int i = 1; i < numOfDays; i++){
			float x = map(i, 0, numOfDays, textBox, width - border);
			line( x, border, x, height - border);
			fill(255);
        	textSize(10);
			text(i , x, border - 10);
		}
		popMatrix();

		//find gap

		//print out the names of the tasks
		//
		
		for(int i = 0; i < tasks.size() ; i ++){
			//print the names of each task
			float y = map(i , 0, tasks.size(), textBoxHeight / 3, textBoxHeight * 1.5f );
			fill(255);
			textSize(15);
			text(tasks.get(i).getTaskName(), border + 50, y);

			// draw the boxes for days
			//
			for(int j = 0; j < numOfDays; j++){
				if (tasks.get(i).getStartTime() == j )
				{
					//first set HSB colours for boxes
					//
					pushMatrix();

					colorMode(HSB);
					fill(i * colorGap,255, 255);
					noStroke();
					float x = map(j, 0, numOfDays, textBox, width - border);
					//double days =  ( tasks.get(i).getEndTime() - tasks.get(i).getStartTime()) ;
					//rect(x , y -15 , x + (days * daySpace) , 30, 4);
					rect(x , y -15 ,map(j, i,  30, tasks.get(i).getStartTime(), tasks.get(i).getEndTime()) ,30, 4);
					popMatrix();

					// spare part of the rect distance
					// I had trouble getting the end point of the rect() function.
					// I was able to get the correct starting point on the gantt but was unable to get
					// a terminating x coordinate that matched up. above is the best way I could show
					// that I could achieve the first part of plotting the days. However it doesnt work 
					// and the gap between the days is incremented each loop throwing off the spacing.
					//
					// I also tried to get the gap between the days and simply find out how many days
					// the period was, multiply the gap by the amount of days and add it to the starting x.
					// This led to an error involving using doubles in rect() that requires only floats.
					// This left me unable to pin down an accurate lengt of the rectangle.
					// I did however achive being able to print the names out and determine the start
					// point for each day on the gantt chart.

				}
			}
		}
	}
	
	public void setup() 
	{
		loadTasks();
		printTasks();
		displayTasks();
	}
	
	public void draw()
	{			
		//background(255);
	}
}
