// Labtest 22/04/2020
// Daniel Foley
// c17335606
// compiled using shell scripts
// https://github.com/FunsizeEvil/OOP-LabTest-2020-Starter

package ie.tudublin;

public class Main
{

    public void gant()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Gantt());
    }
    
    public static void main(String[] arg)
    {
        Main main = new Main();
		main.gant();        
    }
}