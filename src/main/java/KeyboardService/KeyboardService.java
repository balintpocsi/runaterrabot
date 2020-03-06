package KeyboardService;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardService {

    public KeyboardService() {

    }

    public void printChar(String printChar) throws AWTException {
        boolean isUpperCased = false;

        if(printChar.equals(printChar.toUpperCase())){
            isUpperCased = true;
            printChar = printChar.toLowerCase();
        }
            switch (printChar) {
                case "a":
                    caseManagerMethod(KeyEvent.VK_A, isUpperCased);
                    break;

                case "b":
                    caseManagerMethod(KeyEvent.VK_B, isUpperCased);
                    break;

                case "c":
                    caseManagerMethod(KeyEvent.VK_C, isUpperCased);
                    break;

                case "d":
                    caseManagerMethod(KeyEvent.VK_D, isUpperCased);
                    break;

                case "e":
                    caseManagerMethod(KeyEvent.VK_E, isUpperCased);
                    break;

                case "f":
                    caseManagerMethod(KeyEvent.VK_F, isUpperCased);
                    break;

                case "g":
                    caseManagerMethod(KeyEvent.VK_G, isUpperCased);
                    break;

                case "h":
                    caseManagerMethod(KeyEvent.VK_H, isUpperCased);
                    break;

                case "i":
                    caseManagerMethod(KeyEvent.VK_I, isUpperCased);
                    break;

                case "j":
                    caseManagerMethod(KeyEvent.VK_J, isUpperCased);
                    break;

                case "k":
                    caseManagerMethod(KeyEvent.VK_K, isUpperCased);
                    break;

                case "l":
                    caseManagerMethod(KeyEvent.VK_L, isUpperCased);
                    break;

                case "m":
                    caseManagerMethod(KeyEvent.VK_M, isUpperCased);
                    break;

                case "n":
                    caseManagerMethod(KeyEvent.VK_N, isUpperCased);
                    break;

                case "o":
                    caseManagerMethod(KeyEvent.VK_O, isUpperCased);
                    break;

                case "p":
                    caseManagerMethod(KeyEvent.VK_P, isUpperCased);
                    break;

                case "q":
                    caseManagerMethod(KeyEvent.VK_Q, isUpperCased);
                    break;

                case "r":
                    caseManagerMethod(KeyEvent.VK_R, isUpperCased);
                    break;

                case "s":
                    caseManagerMethod(KeyEvent.VK_S, isUpperCased);
                    break;

                case "t":
                    caseManagerMethod(KeyEvent.VK_T, isUpperCased);
                    break;

                case "u":
                    caseManagerMethod(KeyEvent.VK_U, isUpperCased);
                    break;

                case "v":
                    caseManagerMethod(KeyEvent.VK_V, isUpperCased);
                    break;

                case "w":
                    caseManagerMethod(KeyEvent.VK_W, isUpperCased);
                    break;

                case "x":
                    caseManagerMethod(KeyEvent.VK_X, isUpperCased);
                    break;

                case "y":
                    caseManagerMethod(KeyEvent.VK_Y, isUpperCased);
                    break;

                case "z":
                    caseManagerMethod(KeyEvent.VK_Z, isUpperCased);
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
                case "'":
                    pressShiftAndReleaseKey(KeyEvent.VK_1);
                    break;

                case "!":
                    pressShiftAndReleaseKey(KeyEvent.VK_4);
                    break;

                case "?":
                    pressShiftAndReleaseKey(KeyEvent.VK_COMMA);
                    break;
                case ":":
                    pressShiftAndReleaseKey(KeyEvent.VK_PERIOD);
                    break;
                case "0":
                    singleKeyPressAndRelease(KeyEvent.VK_0);
                    break;
                case "1":
                    singleKeyPressAndRelease(KeyEvent.VK_1);
                    break;
                case "2":
                    singleKeyPressAndRelease(KeyEvent.VK_2);
                    break;
                case "3":
                    singleKeyPressAndRelease(KeyEvent.VK_3);
                    break;
                case "4":
                    singleKeyPressAndRelease(KeyEvent.VK_4);
                    break;
                case "5":
                    singleKeyPressAndRelease(KeyEvent.VK_5);
                    break;
                case "6":
                    singleKeyPressAndRelease(KeyEvent.VK_6);
                    break;
                case "7":
                    singleKeyPressAndRelease(KeyEvent.VK_7);
                    break;
                case "8":
                    singleKeyPressAndRelease(KeyEvent.VK_8);
                    break;
                case "9":
                    singleKeyPressAndRelease(KeyEvent.VK_9);
                    break;
                default:
                    System.out.println("Unkown character to write!");
            }
    }

    private void ifUpperCasedThenCallUpperCaseMethod(int charValue) throws AWTException {
            pressShiftAndReleaseKey(charValue);
    }

    private void caseManagerMethod(int KeyeventValue, boolean isUpperCased) throws AWTException {
        if(isUpperCased){
            ifUpperCasedThenCallUpperCaseMethod(KeyeventValue);
        }else{
            singleKeyPressAndRelease(KeyeventValue);
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
