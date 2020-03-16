import PageObjects.StartingHandPage;
import Service.ImageIdentifyService;
import Service.JsonManagerService;
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

    //a cardReferences mappaban talalhato kartyakra mukodo identify service, ami a json file-bol kiolvasott kartyahoz tartozo json objectet adja vissza
    @Test
    public void imageIdentifyServiceTest() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
        ScreenshotService screenshotService = new ScreenshotService();
        ImageIdentifyService imageIdentifyService = new ImageIdentifyService();
        JsonManagerService jsonManagerService = new JsonManagerService();

        System.out.println("Set the card");
        Thread.sleep(5000);
        BufferedImage card = screenshotService.makeIdentifyScreenshotsReturnBufferedImage();
        Calendar now = Calendar.getInstance();
        String cardName = imageIdentifyService.compareCardColorUniqueListWithCardReferenceDataFolder(card);

        //EZT AZ IMAGE-ET KELL A cardReferences mappaba tenni
        ImageIO.write(card, "png", new File("C:\\screenshot\\"+formatter.format(now.getTime())+"_"+cardName+".png"));

        cardName = cardName.replace(".png","");
        System.out.println(cardName);
        System.out.println("######################JsonObject#############################");
        System.out.println(jsonManagerService.returnJsonObjectByCardName(cardName).toString());
    }
}
