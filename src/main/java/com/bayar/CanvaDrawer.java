package com.bayar;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;

import javax.swing.*;

public class CanvaDrawer extends JComponent {

    //variable an array of points
    private double[][] points;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
  

    //constructor
    public CanvaDrawer(double[][] points) {
        this.points = points;
    }
    // method to draw the points
    @Override
    public void paintComponent(Graphics g) {
        
        // g.setColor(Color.red);
        for (int i = 0; i < points.length - 1; i++) {
            g.drawLine((int) points[i][0], (int) points[i][1], (int) points[i + 1][0], (int) points[i + 1][1]);
        }
        }

    //method to translate the points
    public void translate(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] += x;
            points[i][1] += y;
        }
        this.setForeground(Color.red);
    }
    //method to scale the points
    public void scale(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            points[i][0] *= x;
            points[i][1] *= y;
        }
        this.setForeground(Color.blue);
    }
    

    //method to rotate the points

    public void rotate(double angle) {
        for (int i = 0; i < points.length; i++) {
            double x = points[i][0];
            double y = points[i][1];
            points[i][0] = x * Math.cos(angle) - y * Math.sin(angle);
            points[i][1] = x * Math.sin(angle) + y * Math.cos(angle);
        }
        this.setForeground(Color.yellow);
    }

    //method to shear the points

    public void shear(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i][0];
            double y1 = points[i][1];
            points[i][0] = x1 + x * y1;
            points[i][1] = y1 + y * x1;
        }
        this.setForeground(Color.green);
    }

    //method to draw the points

    public void draw() {
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        System.out.println(this.getBackground());
        // this.setForeground(Color.red);

        
        
    }


    
   
    

}