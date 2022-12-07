package com.bayar;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;

import javax.swing.*;

public class CanvaDrawer extends JComponent {

    //variable an array of points
    private Point2D[] points;

    //constructor
    public CanvaDrawer(Point2D[] points) {
        this.points = points;
    }
    //method to draw the points
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) {
            g2.draw(new Line2D.Double(points[i], points[(i + 1) % points.length]));
        
        }
    }

    //method to set the points
    public void setPoints(Point2D[] points) {
        this.points = points;
    }

    //method to get the points

    public Point2D[] getPoints() {
        return points;
    }

    //method to translate the points in matrix
    public void translate(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            points[i].setLocation(points[i].getX() + x, points[i].getY() + y);
        }
    }

    //method to scale the points in matrix
    public void scale(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            points[i].setLocation(points[i].getX() * x, points[i].getY() * y);
        }
    }

    //method to rotate the points in matrix

    public void rotate(double theta) {
        for (int i = 0; i < points.length; i++) {
            double x = points[i].getX();
            double y = points[i].getY();
            points[i].setLocation(x * Math.cos(theta) - y * Math.sin(theta), x * Math.sin(theta) + y * Math.cos(theta));
        }
    }

    //method to shear the points in matrix

    public void shear(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i].getX();
            double y1 = points[i].getY();
            points[i].setLocation(x1 + x * y1, y1 + y * x1);
        }
    }

    //method to reflect the points in matrix

    public void reflect(double x, double y) {
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i].getX();
            double y1 = points[i].getY();
            points[i].setLocation(x1 + x * (y1 - y1), y1 + y * (x1 - x1));
        }
    }


    //method to draw the points in matrix

    public void draw() {
        JFrame f = new JFrame();
        f.setSize(640, 480);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.setVisible(true);
    }
    
    

}