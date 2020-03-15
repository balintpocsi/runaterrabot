package PageObjects;

import java.awt.AWTException;

import Service.MouseService;
import Service.RobotService;

public class StartingHandPage {
    private MouseService mouseService;
    private RobotService robotService;

    public StartingHandPage() throws AWTException {
        mouseService = new MouseService();
        robotService = new RobotService();
    }

    public void confirmOkayToHand() throws InterruptedException {
        mouseService.moveMouse(1744, 601);
        robotService.loopUntilGivenRGBVaueIsFoundThenLeftMouseClick(255, 255, 255);
    }

    public void waitUntilStartingHandIsLoaded() throws InterruptedException {
        mouseService.moveMouse(1200, 385);
       boolean goNextStep = robotService.loopUntilGivenRGBVaueIsFoundThenRightMouseClick(255, 255, 255);
       if(goNextStep){
           rightClickOnStartingCard(380, 381);
           rightClickOnStartingCard(583, 381);
           rightClickOnStartingCard(787, 381);
           rightClickOnStartingCard(984, 379);
       }
    }

    private void rightClickOnStartingCard(int x, int y){
        mouseService.moveMouse(x, y);
        mouseService.rightClickWithMouseButton();
        mouseService.rightClickWithMouseButton();
    }
}
