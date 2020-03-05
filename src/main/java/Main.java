import java.awt.AWTException;
import java.awt.Color;
import java.util.List;

import Cards.Card;
import Cards.Creature;
import Cards.Teemo;
import net.sourceforge.tess4j.TesseractException;

public class Main {

    public static void main(String[] args) throws Exception {

        final Color RED = new Color(237,28,36);
        final Color VIOLET = new Color(163, 73, 164);
        final Color GREEN = new Color(34, 177, 76);
        final Color BLUE = new Color(0, 162, 232);
        List<Color> list;



        RobotService robotService = new RobotService();
        ReadValuesFromImageService readValuesFromImageService = new ReadValuesFromImageService();

        //System.out.println(readValuesFromImageService.readFromImage("C:\\screenshots\\2020-02-17 12 38 57_screenshot.png"));

        ScreenshotService screenshotService = new ScreenshotService();

        list=screenshotService.getUniqueSequenceFromPicture(screenshotService.getBufferedImageByStaticCoordinates());
        screenshotService.drawUniqueSequenceOfColorsToWhiteFlatBoard(list);
        //screenshotService.cachedScreenshots();    //nem mukodik
        //screenshotService.makeScreenshotInfinitely();

        //robotService.scanForColorValues();

        //screenshotService.makeScreenshotInfinitely(0, 0, 250,376);

        //robotService.printSomethingIfFoundColorAtGivenPosition();

        //robotService.loopOfGetColorValue(237, 28, 36);

//        robotService.loopOfGetColorValue(RED);
//        robotService.loopOfGetColorValue(VIOLET);
//        robotService.loopOfGetColorValue(GREEN);
//        robotService.loopOfGetColorValue(BLUE);

        //robotService.loopOfGetColorValue(2086, 238, RED);

    }

}
