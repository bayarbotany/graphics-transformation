package com.bayar;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
   

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
       

        // System.out.println("Welcome, please create a shape");
        // System.out.println("Enter the number of points");
        // int n = scanner.nextInt();
        // scanner.nextLine();
        // double[][] points = new double[n][2];
        // for (int i = 0; i < n; i++) {
        //     System.out.println("Enter the x and y coordinate of point " + (i + 1));
        //     points[i][0] = scanner.nextDouble();
        //     scanner.nextLine();
        //     points[i][1] = scanner.nextDouble();
        //     scanner.nextLine();
        // }

        //SQUARE SHAPE
        // double[][] points = {
        //     {100, 100},     // x----------
        //     {200, 100},     //-----------x
        //     {200, 200},      //-----------x
        //     {100, 200},     //x----------
        //     {100, 100}      //x----------
        // };
        //A circle shape
        double[][] points = {
           {100,100},
           {110,110},
           {120,120},
           {130,130},
           {140,140},
           {150,150},
           {140,160},
           {130,170},
           {120,180},
           {110,190},
           {100,200},
           {90,190},
           {80,180},
           {70,170},
           {60,160},
           {50,150},
           {60,140},
           {70,130},
           {80,120},
           {90,110},
           {100,100},
            {100, 100},     // x----------
            {200, 100},     //-----------x
            {200, 200},      //-----------x
            {100, 200},     //x----------
            {100, 100},      //x----------
            
            {200, 100},    
            {300, 100},     
            {300, 200},     
            {200, 200},     
            {200, 100},

            {200,100},
            {210,110},
            {220,120},
            {230,130},
            {240,140},
            {250,150},
            {240,160},
            {230,170},
            {220,180},
            {210,190},
            {200,200},
            {190,190},
            {180,180},
            {170,170},
            {160,160},
            {150,150},
            {160,140},
            {170,130},
            {180,120},
            {190,110},
            {200,100},
            {200, 100},     // x----------
            {300, 100},     //-----------x
            {300, 200},      //-----------x
            {200, 200},     //x----------
            {200, 100},      //x----------
            
            {300, 100},    
            {400, 100},     
            {400, 200},     
            {300, 200},     
            {300, 100},

            {300,100},
            {310,110},
            {320,120},
            {330,130},
            {340,140},
            {350,150},
            {340,160},
            {330,170},
            {320,180},
            {310,190},
            {300,200},
            {290,190},
            {280,180},
            {270,170},
            {260,160},
            {250,150},
            {260,140},
            {270,130},
            {280,120},
            {290,110},
            {300,100},
            
        };

        //shift the shape to the center of the screen
        for (int i = 0; i < points.length; i++) {
            points[i][0] += 300;
            points[i][1] += 300;
        }

        CanvaDrawer shape = new CanvaDrawer(points);
        shape.draw();
        shape.showGUI();
    //  int option = -1;
    //     while(option != 0) {
    //         System.out.println("Enter the option to transform the shape");
    //         System.out.println("1. Translate");
    //         System.out.println("2. Scale");
    //         System.out.println("3. Rotate");
    //         System.out.println("4. Shear");
    //          option = scanner.nextInt();
    //     scanner.nextLine();

    //     switch (option) {
    //         case 1:
    //             System.out.println("Enter the x and y coordinate to translate");
    //             double x = scanner.nextDouble();
    //             scanner.nextLine();
    //             double y = scanner.nextDouble();
    //             scanner.nextLine();
    //             shape.translate(x, y);
    //             shape.draw();
    //             break;
    //         case 2:
    //             System.out.println("Enter the x and y coordinate to scale");
    //             x = scanner.nextDouble();
    //             scanner.nextLine();
    //             y = scanner.nextDouble();
    //             scanner.nextLine();
    //             shape.scale(x, y);
    //             shape.draw();
    //             shape.getGraphics().setColor(Color.red);
            
    //             break;
    //         case 3:
    //             System.out.println("Enter the angle to rotate");
    //             double theta = scanner.nextDouble();
    //             scanner.nextLine();
    //             shape.rotateAroundPoint(theta);
    //             shape.draw();
    //             break;
    //         case 4:
    //             System.out.println("Enter the x and y coordinate to shear");
    //             x = scanner.nextDouble();
    //             scanner.nextLine();
    //             y = scanner.nextDouble();
    //             scanner.nextLine();
    //             shape.shear(x, y);
    //             shape.draw();
    //             break;
    //         default:
    //             System.out.println("Invalid option");
    //             break;

    //     }
    //     }

    }
 

}
