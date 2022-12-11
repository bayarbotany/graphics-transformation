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
        double[][] points = {
            {100, 100},     // x----------
            {200, 100},     //-----------x
            {200, 200},      //-----------x
            {100, 200},     //x----------
            {100, 100}      //x----------
        };

        CanvaDrawer shape = new CanvaDrawer(points);
        shape.draw();
     int option = -1;
        while(option != 0) {
            System.out.println("Enter the option to transform the shape");
            System.out.println("1. Translate");
            System.out.println("2. Scale");
            System.out.println("3. Rotate");
            System.out.println("4. Shear");
             option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter the x and y coordinate to translate");
                double x = scanner.nextDouble();
                scanner.nextLine();
                double y = scanner.nextDouble();
                scanner.nextLine();
                shape.translate(x, y);
                shape.draw();
                break;
            case 2:
                System.out.println("Enter the x and y coordinate to scale");
                x = scanner.nextDouble();
                scanner.nextLine();
                y = scanner.nextDouble();
                scanner.nextLine();
                shape.scale(x, y);
                shape.draw();
                shape.getGraphics().setColor(Color.red);
            
                break;
            case 3:
                System.out.println("Enter the angle to rotate");
                double theta = scanner.nextDouble();
                scanner.nextLine();
                shape.rotate(theta);
                shape.draw();
                break;
            case 4:
                System.out.println("Enter the x and y coordinate to shear");
                x = scanner.nextDouble();
                scanner.nextLine();
                y = scanner.nextDouble();
                scanner.nextLine();
                shape.shear(x, y);
                shape.draw();
                break;
            default:
                System.out.println("Invalid option");
                break;

        }
       
    
    

        }
           //in the frame 
    //add sliders to change the value of x and y
    //add inputs of x and y for translate, scale, rotate, and shear

    // JFrame frame = new JFrame();
 
    //     JButton button = new JButton("Draw");
    //     JTextField x_value_input = new JTextField("x");
    //     JTextField y_value_input = new JTextField("y");
    //     JSlider x_value_slider = new JSlider();
    //     JSlider y_value_slider = new JSlider();
    //     JRadioButton translate = new JRadioButton("Translate");
    //     JRadioButton scale = new JRadioButton("Scale");
    //     JRadioButton rotate = new JRadioButton("Rotate");
    //     JRadioButton shear = new JRadioButton("Shear");
    //     JRadioButton reflect = new JRadioButton("Reflect");
    //     ButtonGroup group = new ButtonGroup();
        
    //             group.add(translate);
    //             group.add(scale);
    //             group.add(rotate);
    //             group.add(shear);
    //             group.add(reflect);
     
        
        // JPanel panel = new JPanel();

        // //grid layout
        // panel.setLayout(new GridLayout(3, 3));



        // panel.add(button);
        // panel.add(x_value_input);
        // panel.add(y_value_input);
        // panel.add(x_value_slider);
        // panel.add(y_value_slider);
        // panel.add(translate);
        // panel.add(scale);
        // panel.add(rotate);
        // panel.add(shear);
        // panel.add(reflect);
        // frame.add(panel);
        // frame.setLayout(new FlowLayout());
      

    

    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setSize(2000, 500);
    // frame.setVisible(true);
    // frame.add(shape);
        //points of lines (x,y) to draw a house

    }
 

}
