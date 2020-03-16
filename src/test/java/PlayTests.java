import PageObjects.StartingHandPage;
import Service.ImageIdentifyService;
import Service.ScreenshotService;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PlayTests {

    @Test
    public void testChangeCardsInStartingHand() throws AWTException, InterruptedException {
        Thread.sleep(3000);
        StartingHandPage startingHandPage = new StartingHandPage();
        startingHandPage.waitUntilStartingHandIsLoaded();
    }

    //ehhez meg kell csinalni a deck osszes kartyajarol a kis meretu screenshotot, eltenni oket a cardReferences mappaba, elnevezni oket ugy ami a json-ben a nevuk
    @Test
    public void imageIdentifyServiceTest() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
        ScreenshotService screenshotService = new ScreenshotService();
        ImageIdentifyService imageIdentifyService = new ImageIdentifyService();

        System.out.println("Set the card");
        Thread.sleep(5000);
        BufferedImage card = screenshotService.makeIdentifyScreenshotsReturnBufferedImage();
        Calendar now = Calendar.getInstance();
        String cardName = imageIdentifyService.compareCardColorUniqueListWithCardReferenceDataFolder(card);
        ImageIO.write(card, "png", new File("C:\\screenshot\\"+formatter.format(now.getTime())+"_"+cardName+".png"));
        System.out.println(cardName);
    }
}
