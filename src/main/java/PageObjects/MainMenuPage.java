package PageObjects;

import java.awt.AWTException;

import Service.MouseService;

public class MainMenuPage {

    private MouseService mouseService;

    public MainMenuPage() throws AWTException {
        mouseService = new MouseService();
    }

    public void clickOnPlay() {
        mouseService.moveMouse(86, 411);
        mouseService.leftClickWithMouseButton();
    }
}
