package com.bayar;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;
import javax.swing.*;

public class CanvaDrawer extends JComponent {

    //variable an array of points
    private double[][] oldPoints;
    private double[][] points;

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JFrame GUI = new JFrame();
   // slider to transform the points
   private JLabel xSliderLabel = new JLabel("X");
    private JLabel ySliderLabel = new JLabel("Y");
    private JLabel angleSliderLabel = new JLabel("Angle");
    private JSlider xSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
    private JSlider ySlider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
    private JSlider angleSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
    private JButton translate = new JButton("Translate");
    private JButton scale = new JButton("Scale");
    private JButton rotate = new JButton("Rotate");
    private JButton shear = new JButton("Shear");
    private JButton exit = new JButton("Exit");
    
    


    //constructor
    public CanvaDrawer(double[][] points) {
        this.points = points;
        this.oldPoints = points;
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
            if (x > 0 || x < 0) {
                points[i][0] = x1 + x * y1;
            }
            if (y > 0 || y < 0) {

            points[i][1] = y1 + y * x1;
            }
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

    //method to show gui and buttons to transform the points

    public void showGUI() {
        GUI.setSize(1000, 1000);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.add(panel);
        //add all sliders in a vertical box
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(xSliderLabel);
        verticalBox.add(xSlider);
        verticalBox.add(ySliderLabel);
        verticalBox.add(ySlider);
        verticalBox.add(angleSliderLabel);
        verticalBox.add(angleSlider);
        
        panel.add(verticalBox);
        panel.add(translate);
        panel.add(scale);
        panel.add(rotate);
        panel.add(shear);
        panel.add(exit);
        GUI.setVisible(true);

        translate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //translate the points
                translate(xSlider.getValue(), ySlider.getValue());
                //repaint the points
                repaint();

            }
        });
        scale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //scale the points
                //convert from -100 to 100 to -1.0 to 1.0
                //if the value is 0 then it will be 1.0

                double x = xSlider.getValue() / 10.0;
                double y = ySlider.getValue() / 10.0;
                if (x == 0) {
                    x = 1.0;
                }
                if (y == 0) {
                    y = 1.0;
                }

                scale(x, y);
                //repaint the points
                repaint();
            }
        });
        rotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //rotate the points
                // System.out.println(angleSlider.getValue());
                //to convert from -100 to 100 to -1.0 to 1.0
                double angle = angleSlider.getValue() / 100.0;


                rotate(angle);
                //repaint the points
                repaint();
            }
        });

        shear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //convert from -100 to 100 to -1.0 to 1.0
                double x = xSlider.getValue() / 10.0;
                double y = ySlider.getValue() / 10.0;
                
                shear(x, y);
                //repaint the points
                repaint();

            }
        });

    
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //exit the program
                System.exit(0);
            }
        });


    }



    


    
   
    

}