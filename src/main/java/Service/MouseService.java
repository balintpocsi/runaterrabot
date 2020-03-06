package Service;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseService {
    private Robot robot;

    public MouseService() throws AWTException {
        robot = new Robot();
    }

    public void leftClickWithMouseButton(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void rightClickWithMouseButton(){
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void moveMouse(int x, int y) {
        robot.mouseMove(x, y);
        waitOneSec();
    }

    private void waitOneSec(){
        try{

            Thread.sleep(1000);
        } catch (InterruptedException exception){
            System.out.println("Thread exception!");
            exception.printStackTrace();
        }
    }
}
