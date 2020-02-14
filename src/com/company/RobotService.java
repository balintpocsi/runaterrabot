package com.company;

import static java.awt.event.MouseEvent.MOUSE_PRESSED;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class RobotService {
    private Robot robot;

    public RobotService() throws AWTException {
        this.robot = new Robot();
    }

    public void scanForColorValues() throws InterruptedException {
        Color color;
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        while(true){
            Thread.sleep(1500);
            System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x +
                ", " +
                MouseInfo.getPointerInfo().getLocation().y + ")");
             color = robot.getPixelColor(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
            System.out.println(color.getRed()+", "+color.getGreen()+", "+color.getBlue());

        }
    }

    public int[] scanMousePosition(){
        int[] pos = new int[2];
        pos[0] = MouseInfo.getPointerInfo().getLocation().x;
        pos[1] = MouseInfo.getPointerInfo().getLocation().y;
        System.out.println("x: "+pos[0]+", y: "+pos[1]);
        return pos;
    }

    public Color getColorValuesOfGivenPosition(int[] position){
        return robot.getPixelColor(position[0], position[1]);
    }

    public boolean printSomethingIfFoundColorAtGivenPosition(int r, int g, int b){
        boolean notFound = true;
        Color color = getColorValuesOfGivenPosition(scanMousePosition());
//        System.out.println("printSomethingIfFoundColorAtGivenPosition:");
       System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        if(color.getRed()==r && color.getGreen() == g && color.getBlue() == b){
            notFound = false;
        }
        if (notFound){
            System.out.println("NOT FOUND");
        } else {
            System.out.println("GOT IT!");
        }
        System.out.println();
        return notFound;
    }

    public boolean printSomethingIfFoundColorAtGivenPosition(int x, int y, int r, int g, int b){
        boolean notFound = true;
        robot.mouseMove(x, y);


        Color color = robot.getPixelColor(x, y);
        //        System.out.println("printSomethingIfFoundColorAtGivenPosition:");
        System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        if(color.getRed()==r && color.getGreen() == g && color.getBlue() == b){
            notFound = false;
        }
        if (notFound){
            System.out.println("NOT FOUND");
        } else {
            System.out.println("GOT IT!");
        }
        System.out.println();
        return notFound;
    }


    public void loopOfGetColorValue(int r, int g, int b) throws InterruptedException {
        boolean notFoundTargetColor = true;
        while(notFoundTargetColor){
            Thread.sleep(2000);
            //System.out.println(printSomethingIfFoundColorAtGivenPosition(r, g, b));
            notFoundTargetColor = printSomethingIfFoundColorAtGivenPosition(r, g, b);
        }
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

    }

    public void loopOfGetColorValue(Color color) throws InterruptedException {
        boolean notFoundTargetColor = true;
        while(notFoundTargetColor){
            Thread.sleep(2000);
            //System.out.println(printSomethingIfFoundColorAtGivenPosition(r, g, b));
            notFoundTargetColor = printSomethingIfFoundColorAtGivenPosition(color.getRed(), color.getGreen(), color.getBlue());
        }
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

    }

    public void loopOfGetColorValue(int x, int y, Color color) throws InterruptedException {
        boolean notFoundTargetColor = true;
        while(notFoundTargetColor){
            Thread.sleep(2000);
            //System.out.println(printSomethingIfFoundColorAtGivenPosition(r, g, b));
            notFoundTargetColor = printSomethingIfFoundColorAtGivenPosition(x, y, color.getRed(), color.getGreen(), color.getBlue());
        }
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

    }

}
