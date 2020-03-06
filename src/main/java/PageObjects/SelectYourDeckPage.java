package PageObjects;

import java.awt.AWTException;

import Service.MouseService;

public class SelectYourDeckPage {

    private MouseService mouseService;


    public SelectYourDeckPage() throws AWTException {
        mouseService = new MouseService();
    }

    public void selectFirstDeck(){
        mouseService.moveMouse(649, 311);
        mouseService.leftClickWithMouseButton();
    }

    public void confirmPlay(){
        mouseService.moveMouse(1639, 1087);
        mouseService.leftClickWithMouseButton();
        //robotService.loopUntilGivenRGBVaueIsFound(35, 177, 77);
    }
}
