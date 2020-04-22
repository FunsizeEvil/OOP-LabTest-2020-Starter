package ie.tudublin;

import processing.data.TableRow;

public class Task 
{
    //create private fields for the three coloums in tasks.csv
    //
    private String taskName;
    private int startTime;
    private int endTime;

    public Task(String taskName, int startTime, int endTime)
    {
        this.taskName = taskName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"),tr.getInt("Start"), tr.getInt("End"));
    }

    //Auto genrated setters and getters
    //
    
    /**
     * @return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return the startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    //toString method that returns sentence with data
    //
    @Override
    public String toString()
    {
        return "Task " + taskName + " Starts at " + startTime + " and ends at " + endTime + ".";
    }   

}