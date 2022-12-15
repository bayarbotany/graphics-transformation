package com.bayar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

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
    private JTextField angleTextField = new JTextField("0");
    private JTextField xTextField = new JTextField("0");
    private JTextField yTextField = new JTextField("0");
    private JSlider angleSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
    private JButton translate = new JButton("Translate");
    private JButton scale = new JButton("Scale");
    private JLabel infoLabel = new JLabel("Scaling and shearing are dividing the x and y value  by 10 so that it can be in decimal");

    private JButton shear = new JButton("Shear");
    private JButton exit = new JButton("Exit");
    private JButton rotate2 = new JButton("Rotate around point");
    
    


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
            double x1 = points[i][0];
            double y1 = points[i][1];
            // Scale the point by x and y.
            points[i][0] = x1 * x   ;
            points[i][1] = y1 * y  ;

        }
        this.setForeground(Color.blue);
        this.repaint();
    }
    


       public void rotateAroundPoint(double angle) {
        //rotate around the middle of the shape

        //angle variable to degree
        angle = Math.toRadians(angle);
        
        double x = 0;
        double y = 0;
        for (int i = 0; i < points.length; i++) {
            x += points[i][0];
            y += points[i][1];
        }
        x /= points.length;
        y /= points.length;
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i][0];
            double y1 = points[i][1];
            // Rotate the point by angle.
            points[i][0] = x + (x1 - x) * Math.cos(angle) - (y1 - y) * Math.sin(angle);
            points[i][1] = y + (x1 - x) * Math.sin(angle) + (y1 - y) * Math.cos(angle);
        }
        // Set the color to Dark Gray.
        this.setForeground(Color.MAGENTA);
        //redraw the shape
        this.repaint();
        
    }

    //method to shear the points

    public void shear(double x, double y) {
        //shear the points around the middle of the shape
        double x1 = 0;
        double y1 = 0;
        for (int i = 0; i < points.length; i++) {
            x1 += points[i][0];
            y1 += points[i][1];
        }
        x1 /= points.length;
        y1 /= points.length;
        for (int i = 0; i < points.length; i++) {
            points[i][0] += x * (points[i][1] - y1);
            points[i][1] += y * (points[i][0] - x1);
        }
        
        
        this.setForeground(Color.green);
    }

    //method to draw the points

    public void draw() {
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, BorderLayout.CENTER);
        frame.setVisible(true);
        // panel.add(this);
        // panel.setPreferredSize(getPreferredSize());

        
        
    }

    //method to show gui and buttons to transform the points

    public void showGUI() {
        GUI.setSize(1000, 300);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.add(panel);
        //add all sliders in a vertical box
        Box InputBox = Box.createVerticalBox();
        Box verticalBox = Box.createVerticalBox();
        Box ButtonsBox = Box.createVerticalBox();
        //increase the size of the text field
        xTextField.setPreferredSize(new Dimension(50, 20));
        yTextField.setPreferredSize(new Dimension(50, 20));
        angleTextField.setPreferredSize(new Dimension(50, 20));
        InputBox.add(xTextField);
        InputBox.add(yTextField);
        InputBox.add(angleTextField);

        verticalBox.add(xSliderLabel);
        verticalBox.add(xSlider);
        verticalBox.add(ySliderLabel);
        verticalBox.add(ySlider);

        verticalBox.add(angleSliderLabel);
        verticalBox.add(angleSlider);
        verticalBox.add(infoLabel);

        panel.add(InputBox);
        panel.add(verticalBox);
        panel.add(ButtonsBox);
        ButtonsBox.add(translate);
        ButtonsBox.add(scale);

        ButtonsBox.add(rotate2);
        ButtonsBox.add(shear);
        ButtonsBox.add(exit);
        
        GUI.setVisible(true);

        angleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set slider value to the text field value
                angleSlider.setValue(Integer.parseInt(angleTextField.getText()));
            }
        });
        xTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set slider value to the text field value
                xSlider.setValue(Integer.parseInt(xTextField.getText()));
            }
        });
        yTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set slider value to the text field value
                ySlider.setValue(Integer.parseInt(yTextField.getText()));
            }
        });
        xSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                //set text field value to the slider value
                xTextField.setText(Integer.toString(xSlider.getValue()));
            }
        });
        ySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                //set text field value to the slider value
                yTextField.setText(Integer.toString(ySlider.getValue()));
            }
        });
        angleSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                //set text field value to the slider value
                // double angle = angleSlider.getValue() / 100.0;
                double angle = angleSlider.getValue() ;
                angleTextField.setText(angle + "");
            }
        });
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
      
  
        rotate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //rotate the points
                // System.out.println(angleSlider.getValue());
                //to convert from -100 to 100 to -1.0 to 1.0
                // double angle = angleSlider.getValue() / 100.0;
                double angle = angleSlider.getValue() ;
                rotateAroundPoint(angle);
            }
        });


        shear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // convert from -100 to 100 to -1.0 to 1.0
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