package com.company;

import java.awt.AWTException;
import java.awt.Color;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {

        final Color RED = new Color(237,28,36);
        final Color VIOLET = new Color(163, 73, 164);
        final Color GREEN = new Color(34, 177, 76);
        final Color BLUE = new Color(0, 162, 232);


        RobotService robotService = new RobotService();

        //robotService.scanForColorValues();

        //robotService.printSomethingIfFoundColorAtGivenPosition();

        //robotService.loopOfGetColorValue(237, 28, 36);

//        robotService.loopOfGetColorValue(RED);
//        robotService.loopOfGetColorValue(VIOLET);
//        robotService.loopOfGetColorValue(GREEN);
//        robotService.loopOfGetColorValue(BLUE);

        robotService.loopOfGetColorValue(2086, 238, RED);

    }

}
