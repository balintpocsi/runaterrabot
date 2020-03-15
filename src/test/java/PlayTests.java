import PageObjects.StartingHandPage;
import org.testng.annotations.Test;

import java.awt.*;

public class PlayTests {

    @Test
    public void testChangeCardsInStartingHand() throws AWTException, InterruptedException {
        Thread.sleep(3000);
        StartingHandPage startingHandPage = new StartingHandPage();
        startingHandPage.waitUntilStartingHandIsLoaded();
    }

}
