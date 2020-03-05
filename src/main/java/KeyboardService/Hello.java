package KeyboardService;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Hello {
    public static void main(String[] args) throws InterruptedException, AWTException {
        //moveMouseMethod();
        //moveMouseMethod();
        //pressKeyBoard();
        //pressExpKeys();
        String path = "text.txt";
        ReadFromFileService readFromFileService = new ReadFromFileService();
        readFromFileService.readFromFile(path);
    }

    public static void moveMouseMethod() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        while (true){
            robot.mouseMove(500,500);
            Thread.sleep(5000);
            robot.mouseMove(300,300);
            Thread.sleep(5000);
        }
    }

    public static void pressKey() throws AWTException, InterruptedException {
        Thread.sleep(4000);
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_SEMICOLON);
        robot.keyRelease(KeyEvent.VK_SEMICOLON);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public static void pressExpKeys() throws AWTException, InterruptedException{
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_3);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_T);


    }

}
