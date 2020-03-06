package PageObjects;

import java.awt.AWTException;

import Service.MouseService;

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
}
