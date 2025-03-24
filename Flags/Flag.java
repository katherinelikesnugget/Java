import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/**
 * Write a description of class Flag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flag
{
    public static final double X = 300.0;
    public static final double Y = 100.0;
    
    public Flag(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Clear", UI::clearGraphics);
    }
    
    /** Draw flag Côte d'Ivoire */
    
    private void drawFlag() {
        UI.setColor(Color.orange);
        UI.setLineWidth(150);
        UI.drawLine(70, 300, 70, 100);
        UI.setColor(Color.white);
        UI.setLineWidth(150);
        UI.drawLine(220, 300, 220, 100);
        UI.setColor(Color.green);
        UI.setLineWidth(150);
        UI.drawLine(370, 300, 370, 100);
    }
    public static void main(String[] args){
        Flag obj = new Flag();
        obj.drawFlag();
    }
}
