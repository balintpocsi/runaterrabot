package PageObjects;

import java.awt.AWTException;

import Service.MouseService;

public class StartingHandPage {
    MouseService mouseService;

    public StartingHandPage() throws AWTException {
        mouseService = new MouseService();
    }

    public void confirmOkayToHand(){
        mouseService.moveMouse(1744, 601);
    }
}
