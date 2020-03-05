package KeyboardService;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardService {

    public KeyboardService() {

    }

    public void printChar(String printChar) throws AWTException {
            switch (printChar) {
                case "'":
                    pressShiftAndReleaseKey(KeyEvent.VK_1);
                    break;

                case "!":
                    pressShiftAndReleaseKey(KeyEvent.VK_4);
                    break;

                case "?":
                    pressShiftAndReleaseKey(KeyEvent.VK_COMMA);
                    break;

                case "a":
                    singleKeyPressAndRelease(KeyEvent.VK_A);
                    break;

                case "b":
                    singleKeyPressAndRelease(KeyEvent.VK_B);
                    break;

                case "c":
                    singleKeyPressAndRelease(KeyEvent.VK_C);
                    break;

                case "d":
                    singleKeyPressAndRelease(KeyEvent.VK_D);
                    break;

                case "e":
                    singleKeyPressAndRelease(KeyEvent.VK_E);
                    break;

                case "f":
                    singleKeyPressAndRelease(KeyEvent.VK_F);
                    break;

                case "g":
                    singleKeyPressAndRelease(KeyEvent.VK_G);
                    break;

                case "h":
                    singleKeyPressAndRelease(KeyEvent.VK_H);
                    break;

                case "i":
                    singleKeyPressAndRelease(KeyEvent.VK_I);
                    break;

                case "j":
                    singleKeyPressAndRelease(KeyEvent.VK_J);
                    break;

                case "k":
                    singleKeyPressAndRelease(KeyEvent.VK_K);
                    break;

                case "l":
                    singleKeyPressAndRelease(KeyEvent.VK_L);
                    break;

                case "m":
                    singleKeyPressAndRelease(KeyEvent.VK_M);
                    break;

                case "n":
                    singleKeyPressAndRelease(KeyEvent.VK_N);
                    break;

                case "o":
                    singleKeyPressAndRelease(KeyEvent.VK_O);
                    break;

                case "p":
                    singleKeyPressAndRelease(KeyEvent.VK_P);
                    break;

                case "q":
                    singleKeyPressAndRelease(KeyEvent.VK_Q);
                    break;

                case "r":
                    singleKeyPressAndRelease(KeyEvent.VK_R);
                    break;

                case "s":
                    singleKeyPressAndRelease(KeyEvent.VK_S);
                    break;

                case "t":
                    singleKeyPressAndRelease(KeyEvent.VK_T);
                    break;

                case "u":
                    singleKeyPressAndRelease(KeyEvent.VK_U);
                    break;

                case "v":
                    singleKeyPressAndRelease(KeyEvent.VK_V);
                    break;

                case "w":
                    singleKeyPressAndRelease(KeyEvent.VK_W);
                    break;

                case "x":
                    singleKeyPressAndRelease(KeyEvent.VK_X);
                    break;

                case "y":
                    singleKeyPressAndRelease(KeyEvent.VK_Y);
                    break;

                case "z":
                    singleKeyPressAndRelease(KeyEvent.VK_Z);
                    break;

                case " ":
                    singleKeyPressAndRelease(KeyEvent.VK_SPACE);
                    break;

                case "\n":
                    singleKeyPressAndRelease(KeyEvent.VK_ENTER);
                    break;

                case ".":
                    singleKeyPressAndRelease(KeyEvent.VK_PERIOD);
                    break;

                case ",":
                    singleKeyPressAndRelease(KeyEvent.VK_COMMA);
                    break;

                case "-":
                    singleKeyPressAndRelease(KeyEvent.VK_MINUS);
                    break;

                case "/":
                    singleKeyPressAndRelease(KeyEvent.VK_SLASH);
                    break;

                case ";":
                    singleKeyPressAndRelease(KeyEvent.VK_SEMICOLON);
                    break;

                case "=":
                    singleKeyPressAndRelease(KeyEvent.VK_EQUALS);
                    break;
            }

    }

    private void pressShiftAndReleaseKey(int secondaryKey) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(secondaryKey);
        robot.keyRelease(secondaryKey);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    private void singleKeyPressAndRelease(int keyValue) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(keyValue);
        robot.keyRelease(keyValue);
    }
}
